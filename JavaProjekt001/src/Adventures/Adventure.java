/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adventures;

import Actors.Spieler;
import Quests.Quest;
import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author jwest
 */
public class Adventure {
    
    private Random rand = new Random();
    private Spieler mySpieler;
    private ArrayList<Quest> myQuestList = new ArrayList<Quest>();
    private Map<String, Quest> myQuestPool = new HashMap<String, Quest>();
    private List<String> keys;
    private int stage;
    private int anzahlQuests;
  
    Quest activeQuest;
    
    public Adventure (Spieler spieler){
        
        this.mySpieler = spieler;
        this.stage = 0;        
        this.generateQuestPool();
        this.keys = new ArrayList<>(myQuestPool.keySet());
        this.anzahlQuests = myQuestPool.size();
    }   
    
    public void playQuest(){       
                
               
        this.newActiveQuest();        
        
        activeQuest.printQuest(this, stage);
        
        try{
            activeQuest.getAnswer();
            
        }catch (InterruptedException ei) {
            System.out.println("Interrupted Exception!");
            ei.printStackTrace();
        }         
         
    }
    
    public void playQuest(String name){       
                
        
        if(keys.contains(name)){
            activeQuest = myQuestPool.get(name); 
            
            activeQuest.printQuest(this, stage);
        
            try{
                activeQuest.getAnswer();

            }catch (InterruptedException ei) {
                System.out.println("Interrupted Exception!");
                ei.printStackTrace();
            }           
            
        }else{
            System.out.println("Quest mit diesem Namen nicht gefunden");
        }
        
    }
    
    private void newActiveQuest(){
                    
        this.stage += 1;

        if (stage == 1){
            activeQuest = myQuestPool.get("Start");

        } else if(stage >= anzahlQuests){
             
            activeQuest = myQuestPool.get("Final");
            this.stage = anzahlQuests;
            
         }else {       

            do {
                String randomKey = keys.get( rand.nextInt(keys.size()) );
                activeQuest = myQuestPool.get(randomKey);

            }while(activeQuest.getQuestUsed());     

        }   

        activeQuest.setQuestUsed();
        myQuestList.add(activeQuest);          
            
               
    }
    
    private void generateQuestPool(){
        
        Quest tmp;
        
        // Startquest
        tmp = setQuestStart();
        myQuestPool.put(tmp.getquestName(), tmp);
        tmp.setQuestUsed();
        
        tmp = setQuest001();
        myQuestPool.put(tmp.getquestName(), tmp);
        
        tmp = setQuest002();
        myQuestPool.put(tmp.getquestName(), tmp);
        
        tmp = setQuest003();
        myQuestPool.put(tmp.getquestName(), tmp);
        
        tmp = setQuest004();
        myQuestPool.put(tmp.getquestName(), tmp);
        
        tmp = setQuest005();
        myQuestPool.put(tmp.getquestName(), tmp);
        
        tmp = setQuest006();
        myQuestPool.put(tmp.getquestName(), tmp);
        
        tmp = setQuest007();
        myQuestPool.put(tmp.getquestName(), tmp);
        
        tmp = setQuest008();
        myQuestPool.put(tmp.getquestName(), tmp);
                
        tmp = setQuestFinal();
        myQuestPool.put(tmp.getquestName(), tmp);
        tmp.setQuestUsed();
        
        
    }
    
    private Quest setQuestStart(){
       
        String[] stage_text = {
        "Du stehst in deinem Haus, bereit für ein großes Java Abenteuer.",        
        "Alle deine Sachen sind gepackt, da schneit Susanne, dein Tutor ins Haus.",
        "\"Hallo " + mySpieler.getName() + "! Na, bist du bereit?\"",
        "Du nickst.",
        "\"Hast du auch deinen Compiler und die Laufzeit dabei?\""
        };
               
        String[] stage_question = {
        "Wie heissen der Java Compiler und die Laufzeit?"
        };
               
        String[] stage_answer = {
        "1. Java Compiler und Java Laufzeit?",
        "2. JavaCompile und JavaExec?",
        "3. java und javac?",
        "4. Es gibt keine Laufzeit, und java.exe kann alles allein."
        };         
        return (new Quest("Start", stage_text, stage_question, stage_answer, 3));       
    }
    
    private Quest setQuest001(){
       
        String[] stage_text = {
        "Nach der ersten Pruefung bist du guter Dinge.",       
        "\"Zeig mir, dass du Klasse hast.\", meint dein Tutor.",
        "\"Gerne!\", erwiderst du guter Dinge."
        };       
        
        String[] stage_question = {
        "Welche Klassendeklaration ist korrekt?"
        };
               
        String[] stage_answer = {
        "1. Class main {}",
        "2. class private extends Object {}",
        "3. class object extends Object {}",
        "4. class static myClass {}",
        "5. private class myClass {}"
                
        };
       
        return (new Quest("Klasse", stage_text, stage_question, stage_answer, 3));
                
    }
    
    private Quest setQuest002(){
       
        String[] stage_text = {
        "\nEin letzter Check nun\", Susanne zeigt auf die Kiste mit den Variablen.",       
        "\"Eine dieser Variablen ist ein Blindgänger!\"",
        "Gespannt blickst du auf die Truhe."
        };
                
        String[] stage_question = {
        "Welche Variablendeklaration ist falsch?"
        };
               
        String[] stage_answer = {
        "1. private int zehn;",
        "2. boolean drei = true;",
        "3. char string ='c';",
        "4. final double Peter;",
        "5. static Integer bool;"                
        };      
        
        return (new Quest("Variablen", stage_text, stage_question, stage_answer, 4));
        
    }
    
    private Quest setQuest003(){
       
        String[] stage_text = {
        "Guter Dinge lässt du dein Zuhause hinter dir.",       
        "An einer Kreuzung machst du halt, und schaust auf den Wegweiser.",
        };
        
        String[] stage_question = {
        "Welche Schleife lässt dich weiter?"
        };
        
        String[] stage_answer = {
        "1. for (int i = 2; i > -1; i--){ if(++i == 1) i *= 2;}",
        "2. char c = '0'; switch (c){ case 0: return 0;}",
        "3. while(true) {if (true){ while (!false != !true){ } } else break; }",
        "4. do{ boolean test = false;} while(test);"               
        };
       
        return (new Quest("Kreuzung", stage_text, stage_question, stage_answer, 2));
        
    }
    
    private Quest setQuest004(){
       
        String[] stage_text = {
        "Du machst Halt an einer Höhle.",       
        "Plötzlich kommt ein sehr wilder Bär heraus.",
        "Er will fünf Beeren von dir.",
        };
               
        String[] stage_question = {
        "Welche Anweisung gibt '5 Beeren' aus?"
        };
              
        String[] stage_answer = {
        "1. for (int i = 10; i > 5; i--){ System.out.println(i + \" Beeren\");}",
        "2. byte nix = (byte)255; System.out.println(nix + 6 + \" Beeren\");",
        "3. System.out.println(04 + 0x11 - 0b1111 + \" Beeren\");",              
        "4. int i = 5; while(i == 5) { System.out.println(i++ + \" Bären\");}"
        };
          
        return (new Quest("Beeren", stage_text, stage_question, stage_answer, 2));
        
    }
    
    private Quest setQuest005(){
       
        String[] stage_text = {
        "Du kommst an den Rand eines kleines Forsts.",
        "Plötzlich spricht jemand zu dir.",    
        "\"Hallo Knollennase, ich bin die Biene ZumZum.\"",
        "\"Ich wollte von dir wissen, was das izzzt?\"",
        "Fragend schaust du auf ein Blatt Papier.",
        "Darauf zu sehen ist folgendes...",
        "\n",
        "public static int ZumZum(int zz, int zzz){",
        "\tif(zzz == 0) return zz;",
        "\tint zzum = zz ^ zzz;",
        "\tint zzzum = (zz & zzz) << 1;",
        "\treturn ZumZum(zzum, zzzum);",
        "}"
        };
                
        String[] stage_question = {            
        "Wie nennt man ZumZum's Funktion?"
        };
                
        String[] stage_answer = {
        "Das ist eine ... Funktion. (englisches oder deutsches Wort)",
        "Bitte Antwort Eingeben:"
        };
        
        String[] temp = {"rekursive", "recursive", "rekursion"};
        
        return (new Quest("ZumZum", stage_text, stage_question, stage_answer, temp));
        
    }
    
    private Quest setQuest006(){
       
        String[] stage_text = {
        "Die Biene ZumZum sieht dich immer noch mit großen Augen an.",
        "\"Knollennase, und was macht meine Funktion?\"",
        "Wissbegierig schaust du nochmal auf das Blatt Papier.",
        "\n",
        "public static int ZumZum(int zz, int zzz){",
        "\tif(zzz == 0) return zz;",
        "\tint zzZ = zz ^ zzz;",
        "\tint zzzZ = (zz & zzz) << 1;",
        "\treturn ZumZum(zzZ, zzzZ);",
        "}"
        };
                
        String[] stage_question = {            
        "Was macht ZumZum's Funktion eigentlich?"
        };
                
        String[] stage_answer = {
        "Die Funktion ZUMZUM...",
        "1. macht zz zum zzZ;",
        "2. multipliziert zwei Zahlen mit sich selbst.",
        "3. berechnet die Fibonacci-Folge.",
        "4. addiert zwei Zahlen.",
        "5. multipliziert zwei Integer Zahlen;",
        "6. ermittelt alle Primzahlen im Bereich zweier Zahlen.",
        "7. macht gar nichts. Das ist eine Biene, und die machen Honig!"
        };
        
        return (new Quest("ZumZum zum 2.", stage_text, stage_question, stage_answer, 4));
        
    }
    
    private Quest setQuest007(){
       
        String[] stage_text = {
        "Am Wegrand steht ein kleines Mädchen, und weint.",
        "\"Was macht dich denn so traurig?\", fragst du sie.",
        "\"Ich suche Flip, aber er hat sich versteckt!\"",
        "Kannst du Flip finden?",
        "\n",
        "double Flip =  7 ^ 3 - 4 * 2 / 4 % 4 >>> 1 << 3",
        };
                
        String[] stage_question = {            
        "Welchen Wert hat 'Flip' nach Ausführung der Anweisung?"
        };
                
        String[] stage_answer = {
        "Gib bitte den Wert als Zahl an:"        
        };
        
        return (new Quest("Flip", stage_text, stage_question, stage_answer, 7.0));
        
    }
    
    private Quest setQuest008(){
       
        String[] stage_text = {
        "Guter Dinge lässt du dein Zuhause hinter dir.",       
        "An einer Kreuzung machst du halt, und schaust auf den Wegweiser.",
        };
        
        String[] stage_question = {
        "Welche Schleife lässt dich weiter?"
        };
        
        String[] stage_answer = {
        "1. for (int i = 2; i > -1; i--){ if(++i == 1) i *= 2;}",
        "2. char c = '0'; switch (c){ case 0: return 0;}",
        "3. while(true) {if (true){ while (!false != !true){ } } else break; }",
        "4. do{ boolean test = false;} while(test);"               
        };
       
        return (new Quest("Kreuzung", stage_text, stage_question, stage_answer, 2));
        
    }
    
    private Quest setQuestFinal(){
       
        String[] stage_text = null;
                
        String[] stage_question = null;        
                
        String[] stage_answer = {"Please add more Quests."};
        
        return (new Quest("Final", stage_text, stage_question, stage_answer, 0));
        
    }
    
    public Spieler getSpieler() {
        return mySpieler;
    }

}

