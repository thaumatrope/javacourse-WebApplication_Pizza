/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprojekt001;

import java.util.Random;


/**
 *
 * @author jwest
 */
public class Adventure {
    
    private Random rand = new Random();
    private String name;
    private int stage;
    private int health;
        
    private final String richtig = "Deine Antwort war richtig.";
    private final String falsch = "Deine Antwort war falsch.";
    
    Stage activeStage;
    
    
    public Adventure (String name){
        this.name = name;
        this.health = 100;
        this.stage = 1;
        
    } 
    
    public void nextStage(){
        this.stage += 1 + rand.nextInt(2); 
    }
    
    public void initStage(int num) {
        
        stage = num;
        try {
            this.initStage();
        } catch (InterruptedException ei) {
            System.out.println("Debugmode Exception!");
            ei.printStackTrace();
        }
        
    }
    
    public void initStage() throws InterruptedException{
            
        activeStage = new Stage (stage, 1);
        activeStage.init_stage(health);
        
        switch (stage){
            case 1:                
                this.getStage(this.setStage_001());
                break;
                
            case 2:                
                this.getStage(this.setStage_002());
                break;
                
            case 3:                
                this.getStage(this.setStage_003());
                break;
                
            case 4:                
                this.getStage(this.setStage_004());
                break;                
                
            case 5:                
                this.getStage(this.setStage_005());
                break;
                
            case 6:                
                this.getStage(this.setStage_006());
                break;
             
            case 7:                
                this.getStage(this.setStage_007());
                break;
                
            case 8:                
                this.getStage(this.setStage_008());
                break;
                
            default:
                System.out.println("Please add Quests.");
        }
        
    }
    
    private void getStage(int korrekt) throws InterruptedException{        
        
        int myInt = activeStage.getInputInteger();
        
        if(myInt == korrekt)      
            System.out.println(richtig);
        else {
            System.out.println(falsch);
            health -= stage;
        }
        
        activeStage.printEmptyLine(1);
        Thread.sleep(3000);
        
    }
    
    private void getStage(double korrekt) throws InterruptedException{        
        
        double myDouble = activeStage.getInputDouble();
        
        if(Double.compare(myDouble, korrekt) == 0) {  
            System.out.println(richtig);
        }else {
            System.out.println(falsch);
            health -= stage;
        }

        activeStage.printEmptyLine(1);
        Thread.sleep(3000);
        
    }
    
    private void getStage(String[] korrekt) throws InterruptedException{        
        
        boolean treffer = false;
        String myString = activeStage.getInputString();
        for (String item : korrekt){            
            if(myString.equalsIgnoreCase(item)){   
                System.out.println(richtig);
                treffer = true;
                break;
            }
        }
            
        if (!treffer) {
            System.out.println(falsch);
            health -= stage;
        }
        
        activeStage.printEmptyLine(1);
        Thread.sleep(3000);
        
    }
    
    private int setStage_001(){
       
        String[] stage_text = {
        "Du stehst in deinem Haus, bereit für ein großes Java Abenteuer.",        
        "Alle deine Sachen sind gepackt, da schneit Susanne, dein Tutor ins Haus.",
        "\"Hallo " + name + "! Na, bist du bereit?\"",
        "Du nickst.",
        "\"Hast du auch deinen Compiler und die Laufzeit dabei?\""
        };
        activeStage.setText(stage_text);
        
        String[] stage_question = {
        "Wie heissen der Java Compiler und die Laufzeit?"
        };
        activeStage.setQuestion(stage_question);
        
        String[] stage_answer = {
        "1. Java Compiler und Java Laufzeit?",
        "2. JavaCompile und JavaExec?",
        "3. java und javac?",
        "4. Es gibt keine Laufzeit, und java.exe kann alles allein."
        };
        activeStage.setAnswer(stage_answer);
        
        return 3;
        
    }
    
    private int setStage_002(){
       
        String[] stage_text = {
        "Nach der ersten Pruefung bist du guter Dinge.",       
        "\"Zeig mir, dass du Klasse hast.\", meint dein Tutor.",
        "\"Gerne!\", erwiderst du guter Dinge."
        };
        activeStage.setText(stage_text);
        
        String[] stage_question = {
        "Welche Klassendeklaration ist korrekt?"
        };
        activeStage.setQuestion(stage_question);
        
        String[] stage_answer = {
        "1. Class main {}",
        "2. class private extends Object {}",
        "3. class object extends Object {}",
        "4. class static myClass {}",
        "5. private class myClass {}"
                
        };
        activeStage.setAnswer(stage_answer);
        
        return 3;
        
    }
    
    private int setStage_003(){
       
        String[] stage_text = {
        "\nEin letzter Check nun\", Susanne zeigt auf die Kiste mit den Variablen.",       
        "\"Eine dieser Variablen ist ein Blindgänger!\"",
        "Gespannt blickst du auf die Truhe."
        };
        activeStage.setText(stage_text);
        
        String[] stage_question = {
        "Welche Variablendeklaration ist falsch?"
        };
        activeStage.setQuestion(stage_question);
        
        String[] stage_answer = {
        "1. private int zehn;",
        "2. boolean drei = true;",
        "3. char string ='c';",
        "4. final double Peter;",
        "5. static Integer bool;"
                
        };
        activeStage.setAnswer(stage_answer);
        
        return 4;
        
    }
    
    private int setStage_004(){
       
        String[] stage_text = {
        "Guter Dinge lässt du dein Zuhause hinter dir.",       
        "An einer Kreuzung machst du halt, und schaust auf den Wegweiser.",
        };
        activeStage.setText(stage_text);
        
        String[] stage_question = {
        "Welche Schleife lässt dich weiter?"
        };
        activeStage.setQuestion(stage_question);
        
        String[] stage_answer = {
        "1. for (int i = 2; i > -1; i--){ if(++i == 1) i *= 2;}",
        "2. char c = '0'; switch (c){ case 0: return 0;}",
        "3. while(true) {if (true){ while (!false != !true){ } } else break; }",
        "4. do{ boolean test = false;} while(test);"               
        };
        activeStage.setAnswer(stage_answer);
        
        return 2;
        
    }
    
    private int setStage_005(){
       
        String[] stage_text = {
        "Du machst Halt an einer Höhle.",       
        "Plötzlich kommt ein sehr wilder Bär heraus.",
        "Er will fünf Beeren von dir.",
        };
        activeStage.setText(stage_text);
        
        String[] stage_question = {
        "Welche Anweisung gibt '5 Beeren' aus?"
        };
        activeStage.setQuestion(stage_question);
        
        String[] stage_answer = {
        "1. for (int i = 10; i > 5; i--){ System.out.println(i + \" Beeren\");}",
        "2. byte nix = (byte)255; System.out.println(nix + 6 + \" Beeren\");",
        "3. System.out.println(04 + 0x11 - 0b1111 + \" Beeren\");",              
        "4. int i = 5; while(i == 5) { System.out.println(i++ + \" Bären\");}"
        };
        activeStage.setAnswer(stage_answer);
        
        return 2;
        
    }
    
    private String[] setStage_006(){
       
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
        activeStage.setText(stage_text);
        
        String[] stage_question = {            
        "Wie nennt man ZumZum's Funktion?"
        };
        activeStage.setQuestion(stage_question);
        
        String[] stage_answer = {
        "Das ist eine ... Funktion. (englisches oder deutsches Wort)",
        "Bitte Antwort Eingeben:"
        };
        
        activeStage.setAnswer(stage_answer);
        String[] temp = {"rekursive", "recursive"};
        
        return temp;
        
    }
    
    private int setStage_007(){
       
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
        activeStage.setText(stage_text);
        
        String[] stage_question = {            
        "Was macht ZumZum's Funktion eigentlich?"
        };
        activeStage.setQuestion(stage_question);
        
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
        
        activeStage.setAnswer(stage_answer);
                
        return 4;
        
    }
    
    private double setStage_008(){
       
        String[] stage_text = {
        "Am Wegrand steht ein kleines Mädchen, und weint.",
        "\"Was macht dich denn so traurig?\", fragst du sie.",
        "\"Ich suche Flip, aber er hat sich versteckt!\"",
        "Kannst du Flip finden?",
        "\n",
        "double Flip =  7 ^ 3 - 4 * 2 / 4 % 4 >>> 1 << 3",
        };
        activeStage.setText(stage_text);
        
        String[] stage_question = {            
        "Welchen Wert hat 'Flip' nach Ausführung der Anweisung?"
        };
        activeStage.setQuestion(stage_question);
        
        String[] stage_answer = {
        "Gib bitte den Wert als Zahl an:"        
        };
        
        activeStage.setAnswer(stage_answer);
                
        return 7.0;
        
    }

}

