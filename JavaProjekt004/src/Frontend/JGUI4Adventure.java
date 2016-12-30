/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Data.DataAccess;
import Quests.Quest;
import Quests.Quest.QuestAnswer;
import com.mysql.jdbc.StringUtils;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;



/**
 *
 * @author John Westfield
 */
public class JGUI4Adventure extends JGUI {
    
    private DataAccess myDB;
    private Quest myQuest;
    private GUI_MODE mode;
    
    // Menu Elements
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenu jMenu3;
    private JMenuItem jMenuItem01;
    private JMenuItem jMenuItem02;
    private JMenuItem jMenuItem03;
    private JMenuItem jMenuItem10;
    private JMenuItem jMenuItem11;
    private JMenuItem jMenuItem20;
    private JPopupMenu.Separator jSeparator1;
    private JPopupMenu.Separator jSeparator2;
    
    // Top Panel
    private JPanel topPanel;   
    
    // Right Panel
    private JPanel rightPanel;
    private JScrollPane centerPanelScrollable;
    private JList myQuestList;
    private JButton saveQuestButton;
    private JButton deleteQuestButton;
    private JButton clearQuestButton;
    
    // Center Panel
    private JPanel middlePanel;
    private JScrollPane listscroller;
    private JScrollPane scrollTextArea;
    private JLabel createQuestname; 
    private JLabel createText;
    private JLabel createAnswers;
    private JLabel createAnswerType;
    private JPanel createAnswersPanel;
    private JPanel createQuestnamePanel;
    private JPanel createTextPanel;    
    private JPanel createAnswerTypePanel;
    private JPanel answerContainerPanel;
    private JTextField inputQuestname;
    private JTextArea inputQuesttext;
    private ButtonGroup groupAnswerType;
    private JRadioButton typeCheckbox;
    private JRadioButton typeRadiobutton;
    private JRadioButton typeStringInput;
    private JRadioButton typeIntegerInput;
    private JRadioButton typeDoubleInput; 
    private JTextField[] inputAnswers;
    private JCheckBox[] inputAnswersCheckbox;
    private JRadioButton[] inputAnswersRadio;
    private ButtonGroup inputAnswersRadioGroup;
    
    private JSpinner mySpinner;
    private SpinnerNumberModel  modelSpinner;
    
    private JLabel playerPanel;
    private JLabel questPanel;

    public enum GUI_MODE{
        Adventure, Creation, Debug
    }
    
    
    //          JOptionPane.showMessageDialog(null,
    //          "Error: Please enter number bigger than 0", "Error Massage",
    //          JOptionPane.ERROR_MESSAGE);
    
    // Constructor    
    
    public JGUI4Adventure(String text){
        
        this.setTitle(text);        
        this.setSize(1000, 600);       
        this.setMiddlePosition();       
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        
        this.init_Menu();
        
        // Generate Panels
        this.topPanel = new JPanel();
        //this.topPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));
        //this.topPanel.setLayout(new BorderLayout()); 
        //this.topPanel.setLayout(new FlowLayout()); 
        this.topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        
        this.add(topPanel);
        this.rightPanel = new JPanel();
        this.middlePanel = new JPanel();        
          
        // Panels Arrays
        inputAnswers = new JTextField[10];
        for (int i = 0; i < 10; i++){           
           inputAnswers[i] = new JTextField(60); 
           inputAnswers[i].setEditable(true);

        }        
        inputAnswersCheckbox = new JCheckBox[10];
        for (int i = 0; i < 10; i++){           
           inputAnswersCheckbox[i] = new JCheckBox();
        }
        
        inputAnswersRadioGroup = new ButtonGroup();
        inputAnswersRadio = new JRadioButton[10];
        for (int i = 0; i < 10; i++){           
           inputAnswersRadio[i] = new JRadioButton();
           inputAnswersRadioGroup.add(inputAnswersRadio[i]);
        }
        
        // Data - Model
        this.myDB = new DataAccess();   
        myQuest = new Quest();
        
        
        this.setVisible(true);
    }
    
    
    // Listener     
    
     @Override
    public void insertUpdate(DocumentEvent e) {
        this.changedUpdate(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        this.changedUpdate(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        
        if (e.getDocument()== inputQuestname.getDocument()){
            
            String name = inputQuestname.getText().trim();
       
            if(name.equalsIgnoreCase("")){
                System.out.println("changedUpdate - inputQuestname.getText().length(): " + inputQuestname.getText().trim().length());
                createQuestname.setForeground(Color.RED);
                createQuestname.setText("Quest Name: -- is empty!");

            }else if (myDB.checkQuestname(name, myQuest.getID())){
    
                createQuestname.setForeground(Color.RED);
                createQuestname.setText("Quest Name: -- already exists!");

            }else{

                myQuest.setQuestname(name);

                createQuestname.setForeground(Color.BLACK);
                createQuestname.setText("Quest Name:");
            }
            
            
        } else  if (e.getDocument()== inputQuesttext.getDocument()){
            
            myQuest.setQuestname(inputQuesttext.getText());
            
        }  else  if (e.getDocument()== inputAnswers[0].getDocument()){
            
        }  else  if (e.getDocument()== inputAnswers[1].getDocument()){
            
        }  else  if (e.getDocument()== inputAnswers[2].getDocument()){
            
        }  else  if (e.getDocument()== inputAnswers[3].getDocument()){
            
        }  else  if (e.getDocument()== inputAnswers[4].getDocument()){
            
        }  else  if (e.getDocument()== inputAnswers[5].getDocument()){
            
        }  else  if (e.getDocument()== inputAnswers[6].getDocument()){
            
        }  else  if (e.getDocument()== inputAnswers[7].getDocument()){
            
        }  else  if (e.getDocument()== inputAnswers[8].getDocument()){
            
        }  else  if (e.getDocument()== inputAnswers[9].getDocument()){
            
        }
    }
    
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        
        System.out.println("ListSelectionEvent Entered:");             
        
        myQuest = new Quest();
        
        if(e.getSource() == myQuestList){               
            System.out.println("ListSelectionEvent myQuestList.getSelectedValue().toString(): " + myQuestList.getSelectedValue().toString());    
            if(myQuestList.getSelectedValue().toString().equalsIgnoreCase("-1")){
                             
                this.clearCreationPanels();   
                
            }else{
                
                myQuest = myDB.getQuestbyQuestname(myQuestList.getSelectedValue().toString());
                this.showQuestData_CreateMode(myQuest);
            }            

        }
       
    }
    
    @Override
    public void stateChanged(ChangeEvent e) {
       if(e.getSource() == mySpinner){                      
            this.displayModeCreate_AnswerPanels();               
      }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == jMenuItem01){           //questMode
            
            this.changeDisplay(GUI_MODE.Adventure);            
            
        }else if(e.getSource() == jMenuItem02){
            
            
        }else if(e.getSource() == jMenuItem03){
            
            
        }else if(e.getSource() == jMenuItem10){     //creationMode
            
            this.changeDisplay(GUI_MODE.Creation); 
            
         }else if(e.getSource() == jMenuItem11){     //debugMode
            
            this.changeDisplay(GUI_MODE.Debug); 
            
        }else if(e.getSource() == jMenuItem20){
                       
            JGUIDialog myDialog = new JGUIDialog(this, "Das Java Adventure", "Eine Quest, wie keine zuvor. (\u00a9 2016) ");
                               
        }else if(e.getSource() == typeCheckbox){
                     
            int number = (int)mySpinner.getValue();         
            myQuest.setAnswertype(Quest.ANSWERTYPE.CheckBox);
            this.modelSpinner.setMaximum(10);
            this.mySpinner.setValue(Integer.valueOf(number));
            this.displayModeCreate_AnswerPanels();  
           
        }else if(e.getSource() == typeRadiobutton){
                  
            int number = (int)mySpinner.getValue(); 
            myQuest.setAnswertype(Quest.ANSWERTYPE.RadioButton);
            this.modelSpinner.setMaximum(10);
            this.mySpinner.setValue(Integer.valueOf(number));
            this.displayModeCreate_AnswerPanels();  
          
        }else if(e.getSource() == typeStringInput){
                    
            myQuest.setAnswertype(Quest.ANSWERTYPE.String);
            this.modelSpinner.setMaximum(1);
            this.mySpinner.setValue(Integer.valueOf(1));
            this.displayModeCreate_AnswerPanels();  
        
        }else if(e.getSource() == typeIntegerInput){            

            myQuest.setAnswertype(Quest.ANSWERTYPE.Integer);
            this.modelSpinner.setMaximum(1);
            this.mySpinner.setValue(Integer.valueOf(1));
            this.displayModeCreate_AnswerPanels();  
            
        }else if(e.getSource() == typeDoubleInput){
                    
            myQuest.setAnswertype(Quest.ANSWERTYPE.Double);
            this.modelSpinner.setMaximum(1);
            this.modelSpinner.setMaximum(Integer.valueOf(1));
            this.displayModeCreate_AnswerPanels();  
            
        }else if(e.getSource() == saveQuestButton){
            
            Boolean checked = this.checkOnSave();
                            
            if(checked){  
           
                String mySavedQuest = myDB.saveQuest(myQuest);                 
                this.buildRightPanel_CreateMode();
                this.clearCreationPanels();                
                myQuestList.setSelectedValue(mySavedQuest, true);
                myQuestList.requestFocus();

            }            
        
        }else if(e.getSource() == deleteQuestButton){
            
            Boolean checked = this.checkOnDelete();
                    
            if(checked){                
                myDB.deleteQuest(myQuest);  
               
                this.buildRightPanel_CreateMode();
                this.clearCreationPanels();
                myQuest = new Quest();
                
            }          
        
        }else if(e.getSource() == clearQuestButton){
                    
            this.buildRightPanel_CreateMode();
            this.clearCreationPanels();
            myQuest = new Quest();
            
        }else {
            
            System.out.println("MenuItem not defined");
            throw new IllegalStateException();
            
        }      
    
        
    }
    
    
    
    // Controller Methods
    
    @Override
    protected void init_Menu(){
        
        jMenu1 = new JMenu();
        jMenu1.setText("Adventure");

        jMenuItem01 = new JMenuItem();
        jMenuItem01.setText("New Adventure");
        jMenu1.add(jMenuItem01);
        jSeparator1 = new JPopupMenu.Separator();
        jMenu1.add(jSeparator1);

        jMenuItem02 = new JMenuItem();
        jMenuItem02.setText("Continue...");
        jMenu1.add(jMenuItem02);
        
        jSeparator1 = new JPopupMenu.Separator();
        jMenu1.add(jSeparator1);

        jMenuItem03 = new JMenuItem();
        jMenuItem03.setText("Exit");
        jMenu1.add(jMenuItem03);

        jMenuBar.add(jMenu1);
        
        jMenuItem01.addActionListener(this);
        jMenuItem02.addActionListener(this);
        jMenuItem03.addActionListener(this);
  
        //----------------------------------------------------
        
        jMenu2 = new JMenu();
        jMenu2.setText("Create");

        jMenuItem10 = new JMenuItem();
        jMenuItem10.setText("Quest");
        jMenu2.add(jMenuItem10);
        jSeparator2 = new JPopupMenu.Separator();
        jMenu2.add(jSeparator2);

        jMenuItem11 = new JMenuItem();
        jMenuItem11.setText("DebugMode");
        jMenu2.add(jMenuItem11);

        jMenuBar.add(jMenu2);
        
        jMenuItem10.addActionListener(this);
        jMenuItem11.addActionListener(this);
        
        //----------------------------------------------------
        
        jMenu3 = new JMenu();
        jMenu3.setText("Info");

        jMenuItem20 = new JMenuItem();
        jMenuItem20.setText("Version");
        jMenu3.add(jMenuItem20);

        jMenuBar.add(jMenu3);
        
        jMenuItem20.addActionListener(this);

        setJMenuBar(jMenuBar);
            
    }
    
    private void changeDisplay(GUI_MODE newMode){          
        
        
        switch (newMode){
            case Adventure:  
                //this.displayModeAdventure();
                break;
                
            case Creation:
                this.displayModeCreate();
                break;
                
            case Debug:
                this.displayModeDebug();
                break;
        }

        
        
    }   
    
       
    private void displayModeDebug(){    
        System.out.println("JGUI: Entered displayModeDebug()");
        
        myQuest = null;
        
        this.topPanel.removeAll();        

        topPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // RIGHT Panel
        this.buildRightPanel_DebugMode();
        
        // CENTER Panel         
        this.buildCenterPanel_DebugMode();
        
        // add TWO panels       
        this.topPanel.add(centerPanelScrollable);        
        
        //this.topPanel.add(rightPanel, BorderLayout.EAST);
        this.topPanel.add(rightPanel);
         
        this.validate();
        
        System.out.println("JGUI: Exited displayModeDebug()");
     }
    
    private void displayModeCreate(){        
        
        System.out.println("JGUI: Entered displayCreationMode()");
        
        
        
        this.topPanel.removeAll();        

        topPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // RIGHT Panel
        this.buildRightPanel_CreateMode();
        
        // CENTER Panel         
        this.buildCenterPanel_CreateMode();
        
        // add TWO panels
        //this.topPanel.add(centerPanelScrollable, BorderLayout.CENTER);
        this.topPanel.add(centerPanelScrollable);        
        
        //this.topPanel.add(rightPanel, BorderLayout.EAST);
        this.topPanel.add(rightPanel);
         
        this.validate();
        
        System.out.println("JGUI: Exited displayCreationMode()");
        
    }
    
    private void displayModeCreate_AnswerPanels(){
        
        System.out.println("displayModeCreate_AnswerPanels() entered:");
        
        JLabel label;
        JPanel panel;
        
        int number = (int)mySpinner.getValue();
        System.out.println("createAnswerPanels - Spinner Value:: " + number);
            
        this.answerContainerPanel.removeAll();        
        answerContainerPanel.setLayout(new BoxLayout(answerContainerPanel, BoxLayout.Y_AXIS));
                  
        for(int i = 0; i < number; i++){            
           
            panel = this.getEntryPanel(5, 5, 10, 5);
            
            if (myQuest.getAnswertype() == Quest.ANSWERTYPE.CheckBox){
                panel.add(inputAnswersCheckbox[i]);               
            } else if (myQuest.getAnswertype() == Quest.ANSWERTYPE.RadioButton){
                panel.add(inputAnswersRadio[i]); 
            }
            
            label = new JLabel((i+1) + ". ");
            panel.add(label);           
           
            panel.add(label);
            panel.add(inputAnswers[i]);
            this.answerContainerPanel.add(panel);
            
        }         
        
        this.validate();
        
        System.out.println("displayModeCreate_AnswerPanels() exited:");
   
    }
     
    
    private JPanel getContainerPanel(String mode){
        
        JPanel panel = new JPanel();
        switch (mode){
            case "BoxY":
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                break;
             case "BoxX":
                panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
                break;
            case "FlowL":
                panel.setLayout(new FlowLayout(FlowLayout.LEFT));
                break;
            default:
                panel.setLayout(new BorderLayout());
                break;
            
        }
   
        panel.setOpaque(true);
        
        return panel;
    }
    
    private JPanel getLabelPanel(){
        
        JPanel panel = this.getContainerPanel("FlowL");
        EmptyBorder border = new EmptyBorder(10, 10, 10, 10);  //top left botton right
        panel.setBorder(border);
        panel.setBackground(new Color(200,200,200));
        
        return panel;
    }
    
    private JPanel getEntryPanel(){
        
        JPanel panel = this.getContainerPanel("FlowL");
        EmptyBorder border = new EmptyBorder(10, 10, 10, 10);  //top left botton right
        panel.setBorder(border);
        panel.setBackground(new Color(230,230,230));
        
        return panel;
    }
    
    private JPanel getEntryPanel(int top, int right, int bottom, int left){
        
        JPanel panel = this.getContainerPanel("FlowL");
        EmptyBorder border = new EmptyBorder(top, right, bottom, left);  //top left botton right
        panel.setBorder(border);
        panel.setBackground(new Color(230,230,230));
               
        return panel;
    }
    
    private JPanel getRadioButtonPanel(){      
               
        return this.getContainerPanel("FlowL");
    }
    
      
    private Boolean checkOnSave(){  
        
        if(Quest.ANSWERTYPE.isMember(myQuest.getAnswertype().name())){
            
            System.out.println("Valid Enum ANSWERTYPE: " + myQuest.getAnswertype().name());
            createAnswerType.setForeground(Color.BLACK);
        } else {
            // set message to Label "AnswerType";
            createAnswerType.setForeground(Color.RED);
            return false;
        }            
                
        if(StringUtils.isEmptyOrWhitespaceOnly(inputQuestname.getText())){
            
            // set message to Label "Questname";
            createQuestname.setForeground(Color.RED);
            createQuestname.setText("Quest Name: -- is empty!");
            
            return false;
        } else {
            myQuest.setQuestname(this.inputQuestname.getText());       
            myQuest.setQuesttext(this.inputQuesttext.getText()); 

        }
        
        myQuest.getQuestAnswerList().clear();
        int size = (int)mySpinner.getValue();
        
        for(int i = 0; i < size; i++){
            QuestAnswer myQA = myQuest.new QuestAnswer();
            myQA.setAnswer(inputAnswers[i].getText());
            if(StringUtils.isEmptyOrWhitespaceOnly(myQA.getAnswer())){ 
                
                // set message to Label "Questanswers";
                createAnswers.setForeground(Color.RED);
                return false;
            } else {
                createAnswers.setForeground(Color.BLACK);
            }
            
            switch (myQuest.getAnswertype()){
                              
                case CheckBox:
                    
                    if(this.inputAnswersCheckbox[i].isSelected())
                        myQA.setCorrect(true);
                    else
                        myQA.setCorrect(false);
                    break;
                    
                case RadioButton:
                    
                   if(this.inputAnswersRadio[i].isSelected())
                        myQA.setCorrect(true);
                    else
                        myQA.setCorrect(false);
                    break;
                    
                default:
                    
                     myQA.setCorrect(true);
                    
            }            
            myQuest.getQuestAnswerList().add(myQA);     
                    
            }           
        
     
        return true;
    }
    
    private Boolean checkOnDelete(){        
       
        myQuest.setQuestname(this.inputQuestname.getText());       
               
        if(StringUtils.isEmptyOrWhitespaceOnly(myQuest.getQuestname())){
            
            // set message to Label "Questname";
            createQuestname.setForeground(Color.RED);
            return false;
        } else {
            createQuestname.setForeground(Color.BLACK);
        } 
     
        return true;
    }    
       
    private void showQuestData_CreateMode(Quest myQuest){
         
        this.inputQuestname.setText(myQuest.getQuestname());
        this.inputQuesttext.setText(myQuest.getQuesttext()); 
         
          if(Quest.ANSWERTYPE.isMember(myQuest.getAnswertype().name())){
             
            System.out.println("showQuestData Valid Enum ANSWERTYPE: " + myQuest.getAnswertype().name());
            
            int size = myQuest.getQuestAnswerList().size();
            System.out.println("showQuestData myQuest.getQuestAnswerList().size(): " + size);
            
            
            if((size >= 1) && (size <= 10)){
                this.mySpinner.setValue(size);this.displayModeCreate_AnswerPanels(); 
                
                int i = 0;
            
                switch (myQuest.getAnswertype()){

                    case Integer:
                        this.inputAnswers[0].setText(myQuest.getQuestAnswerList().get(0).getAnswer());
                        typeIntegerInput.setSelected(true);
                        break;
                    case Double:
                        this.inputAnswers[0].setText(myQuest.getQuestAnswerList().get(0).getAnswer());
                        typeDoubleInput.setSelected(true);
                        break;
                    case String:
                        this.inputAnswers[0].setText(myQuest.getQuestAnswerList().get(0).getAnswer());
                        typeStringInput.setSelected(true);
                        break;
                    case RadioButton:
                        i = 0;
                        for(QuestAnswer myQA : myQuest.getQuestAnswerList()){

                            this.inputAnswers[i].setText(myQA.getAnswer());
                            System.out.println("showQuestData - inputAnswers[i].setText(" + myQA.getAnswer() + ")");
                            this.inputAnswersRadio[i].setSelected(myQA.getCorrect().booleanValue());
                            i++;
                        }                    
                        typeRadiobutton.setSelected(true);
                        break;
                    case CheckBox:                    
                        i = 0;
                        for(QuestAnswer myQA : myQuest.getQuestAnswerList()){

                            this.inputAnswers[i].setText(myQA.getAnswer());
                            System.out.println("showQuestData - inputAnswers[i].setText(" + myQA.getAnswer() + ")");
                            System.out.println("showQuestData - inputAnswersCheckbox[i].setSelected(" + myQA.getCorrect() + ")");
                            System.out.println("showQuestData - inputAnswersCheckbox[i].setSelected(" + myQA.getCorrect().booleanValue() + ")");
                            
                            if(myQA.getCorrect())
                                this.inputAnswersCheckbox[i].setSelected(true);
                            else
                                this.inputAnswersCheckbox[i].setSelected(false);
                            
                            i++;
                        }
                        typeCheckbox.setSelected(true);    
                        break;
                }       
                
                
            }else{
                this.mySpinner.setValue(1);
                this.displayModeCreate_AnswerPanels();
                
            }
      
        }
          
        this.validate();
       
         
     }
     
    private void clearCreationPanels(){
         
                           
        typeCheckbox.setSelected(true);    
            
        this.inputQuestname.setText("");
        this.inputQuesttext.setText("");    
  
        this.mySpinner.setValue(1);
        this.displayModeCreate_AnswerPanels(); 
        
        
        for(int i = 0; i < 10; i++){
            
            this.inputAnswers[i].setText("");
            this.inputAnswersCheckbox[i].setSelected(false);
        }
        
        this.validate();

     }
     
    private void buildRightPanel_CreateMode(){
         
        JPanel panel = null;
        
        this.rightPanel.removeAll();  
        this.rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        
        String[] myQuests = this.myDB.getQuestnames(); 

        myQuestList = new JList(myQuests);
        myQuestList.addListSelectionListener(this);
        myQuestList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        listscroller = new JScrollPane(myQuestList);
        
                
        panel = this.getContainerPanel("BoxY");
        
        //listscroller.setSize(new Dimension(250, 80));
               
        panel.add(listscroller);
//        EmptyBorder myborder = new EmptyBorder(2, 2, 2, 2);  //top left botton right
//        listscroller.setBorder(myborder);
        this.rightPanel.add(panel);
        
        panel = this.getContainerPanel("BoxX");
        
        panel.setBackground(new Color(0,230,230));
        panel.setOpaque(true);  
        //panel.setPreferredSize(new Dimension(30,30));
        
        saveQuestButton = new JButton("Save");
        saveQuestButton.addActionListener(this);
        panel.add(saveQuestButton);
        
        panel.add(Box.createHorizontalGlue()); 
        
        clearQuestButton = new JButton("Clear All");   
        clearQuestButton.addActionListener(this);
        panel.add(clearQuestButton); 
        
        panel.add(Box.createHorizontalGlue()); 
        
        deleteQuestButton = new JButton("Delete");   
        deleteQuestButton.addActionListener(this);
        panel.add(deleteQuestButton); 
  
        this.rightPanel.add(panel);
        this.validate();
     }
     
    private void buildCenterPanel_CreateMode(){
         
        JPanel panel = null;
        
        middlePanel.removeAll();
        middlePanel.setLayout(new BoxLayout( middlePanel, BoxLayout.Y_AXIS ));
        middlePanel.setBackground(new Color(180,180,180));
        middlePanel.setOpaque(true);
        middlePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // Questname Panel - Label
        createQuestnamePanel = this.getLabelPanel();
        createQuestname = new JLabel("Quest Name:"); // MessageText if error RED/BOLD
        createQuestnamePanel.add(createQuestname);      
        this.middlePanel.add(createQuestnamePanel);      
        
        // TextField - Questname
        panel = this.getEntryPanel();
        inputQuestname = new JTextField(40); 
        inputQuestname.setEditable(true);
        panel.add(inputQuestname);
        this.inputQuestname.getDocument().addDocumentListener(this);
        this.middlePanel.add(panel);               
            
        // Test Panel - Label
        createTextPanel = this.getLabelPanel();
        createText = new JLabel("Quest Text:"); // MessageText if error RED/BOLD
        createTextPanel.add(createText);      
        this.middlePanel.add(createTextPanel);   
     
        
        inputQuesttext = new JTextArea(20, 0);
        inputQuesttext.setEditable(true);
        inputQuesttext.setLineWrap (true);
        inputQuesttext.setWrapStyleWord (true);
        inputQuesttext.setMargin( new Insets(10,10,10,10) );
        
        this.scrollTextArea = new JScrollPane(inputQuesttext,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); 
        this.middlePanel.add(scrollTextArea);
        
        // AnswerType Panel - Label
        createAnswerTypePanel = this.getLabelPanel();
        createAnswerType = new JLabel("Quest AnswerType:"); // MessageText if error RED/BOLD
        createAnswerTypePanel.add(createAnswerType);      
        this.middlePanel.add(createAnswerTypePanel);       
        
        //Group the radio buttons.
       
        groupAnswerType = new ButtonGroup();
        typeCheckbox = new JRadioButton("Checkboxes");
        typeRadiobutton = new JRadioButton("Radiobuttons");
        typeStringInput = new JRadioButton("Input Text");
        typeIntegerInput = new JRadioButton("Input Integer");
        typeDoubleInput = new JRadioButton("Input Double");
         
        //typeCheckbox.setMnemonic(KeyEvent.VK_B);
        //typeCheckbox.setActionCommand(typeCheckbox);
        typeCheckbox.setSelected(true); 

        //typeRadiobutton.setMnemonic(KeyEvent.VK_C);
        //typeRadiobutton.setActionCommand(typeRadiobutton);
 
        //typeTextInput.setMnemonic(KeyEvent.VK_D);
        //typeTextInput.setActionCommand(typeTextInput);
        panel = this.getRadioButtonPanel();
        panel.add(typeCheckbox);        
        this.middlePanel.add(panel);   
        groupAnswerType.add(typeCheckbox);
        
        panel = this.getRadioButtonPanel();
        panel.add(typeRadiobutton);
        this.middlePanel.add(panel);
        groupAnswerType.add(typeRadiobutton);
                
        panel = this.getRadioButtonPanel();
        panel.add(typeStringInput);
        this.middlePanel.add(panel);
        groupAnswerType.add(typeStringInput);
        
        panel = this.getRadioButtonPanel();
        panel.add(typeIntegerInput);
        this.middlePanel.add(panel);
        groupAnswerType.add(typeIntegerInput);
                
        panel = this.getRadioButtonPanel();
        panel.add(typeDoubleInput);
        this.middlePanel.add(panel);
        groupAnswerType.add(typeDoubleInput);

 
        //Register a listener for the radio buttons.
        typeCheckbox.addActionListener(this);
        typeRadiobutton.addActionListener(this);
        typeStringInput.addActionListener(this);
        typeIntegerInput.addActionListener(this);
        typeDoubleInput.addActionListener(this);
               
        // Answers Panel - Label
        createAnswersPanel = this.getLabelPanel();
        createAnswers = new JLabel("Quest Answer(s):"); // MessageText if error RED/BOLD
        createAnswersPanel.add(createAnswers);      
        this.middlePanel.add(createAnswersPanel);
        
        // Answer - Spinner
        panel = this.getEntryPanel();
        modelSpinner = new SpinnerNumberModel(1, 1, 10, 1); //initial value, min, max, step
        mySpinner= new JSpinner(modelSpinner); 
        mySpinner.addChangeListener(this);
        panel.add(mySpinner);       
        this.middlePanel.add(panel);  
        
        // Panel - answerContainerPanel
        this.answerContainerPanel = this.getContainerPanel("FlowL");
        this.middlePanel.add(answerContainerPanel);       
        this.displayModeCreate_AnswerPanels();

        // JScrollpane - Panel
        int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER; 
        
        this.centerPanelScrollable = new JScrollPane(middlePanel,v,h);
        centerPanelScrollable.setPreferredSize(new Dimension(this.getWidth()- 250, Integer.MAX_VALUE));
        this.validate();
     }
    
    
    
    private void buildRightPanel_DebugMode(){
         
        JPanel panel = null;
        
        this.rightPanel.removeAll();  
        this.rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        
        String[] myQuests = this.myDB.getQuestnames(); 

        myQuestList = new JList(myQuests);
        myQuestList.addListSelectionListener(this);
        myQuestList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       
        listscroller = new JScrollPane(myQuestList);
        
                
        panel = this.getContainerPanel("BoxY");
        
        //listscroller.setSize(new Dimension(250, 80));
               
        panel.add(listscroller);
        EmptyBorder myborder = new EmptyBorder(2, 2, 2, 2);  //top left botton right
        listscroller.setBorder(myborder);
        this.rightPanel.add(panel);
        
        panel = this.getContainerPanel("BoxX");
        
        panel.setBackground(new Color(0,230,230));
        panel.setOpaque(true);  
        //panel.setPreferredSize(new Dimension(30,30));
        
//        saveQuestButton = new JButton("Save");
//        saveQuestButton.addActionListener(this);
//        panel.add(saveQuestButton);
//        
//        panel.add(Box.createHorizontalGlue()); 
//        
//        clearQuestButton = new JButton("Clear All");   
//        clearQuestButton.addActionListener(this);
//        panel.add(clearQuestButton); 
//        
//        panel.add(Box.createHorizontalGlue()); 
//        
//        deleteQuestButton = new JButton("Delete");   
//        deleteQuestButton.addActionListener(this);
//        panel.add(deleteQuestButton); 
  
        this.rightPanel.add(panel);
        this.validate();
     }
    
    private void buildCenterPanel_DebugMode(){       
        
        JPanel panel = null;
        
        middlePanel.removeAll();
        middlePanel.setLayout(new BoxLayout( middlePanel, BoxLayout.Y_AXIS ));
        middlePanel.setBackground(new Color(180,180,180));
        middlePanel.setOpaque(true);
        middlePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // Questname Panel - Label
        panel = this.getLabelPanel();
        createQuestname = new JLabel(); 
        createQuestnamePanel.add(createQuestname);      
        this.middlePanel.add(createQuestnamePanel);      

        private JLabel playerPanel;
        private JLabel questPanel;
        // Player Panel - Label
        createPlayerPanel = this.getLabelPanel();
        createText = new JLabel("Some Text.....Health, LEvel, etc."); 
        createTextPanel.add(createText);      
        this.middlePanel.add(createTextPanel);   
     
        
        inputQuesttext = new JTextArea(20, 0);
        inputQuesttext.setEditable(false);
        inputQuesttext.setLineWrap (true);
        inputQuesttext.setWrapStyleWord (true); 
        Color c = new Color(0,0,0,100);
        inputQuesttext.setBackground(c);
        inputQuesttext.setMargin( new Insets(10,10,10,10) );
        
        this.scrollTextArea = new JScrollPane(inputQuesttext,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); 
        this.middlePanel.add(scrollTextArea);
        
        
        // AnswerType Panel - Label
        createAnswerTypePanel = this.getLabelPanel();
        createAnswerType = new JLabel("Quest AnswerType:"); // MessageText if error RED/BOLD
        createAnswerTypePanel.add(createAnswerType);      
        this.middlePanel.add(createAnswerTypePanel);       
        
        
        
        //Group the radio buttons.       
                   
        // Answers Panel - Label
        createAnswersPanel = this.getLabelPanel();
        createAnswers = new JLabel("Quest Answer(s):"); // MessageText if error RED/BOLD
        createAnswersPanel.add(createAnswers);      
        this.middlePanel.add(createAnswersPanel);
        
       // Panel - answerContainerPanel
        this.answerContainerPanel = this.getContainerPanel("FlowL");
        this.middlePanel.add(answerContainerPanel);       
        this.displayModeDebug_AnswerPanels();

        // JScrollpane - Panel
        int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER; 
        
        this.centerPanelScrollable = new JScrollPane(middlePanel,v,h);
        centerPanelScrollable.setPreferredSize(new Dimension(this.getWidth()- 250, Integer.MAX_VALUE));
        this.validate();
     }
    
    private void displayModeDebug_AnswerPanels(){
        
        System.out.println("displayModeCreate_AnswerPanels() entered:");
        
//        JLabel label;
//        JPanel panel;
//        
//        int number = (int)mySpinner.getValue();
//        System.out.println("createAnswerPanels - Spinner Value:: " + number);
//            
//        this.answerContainerPanel.removeAll();        
//        answerContainerPanel.setLayout(new BoxLayout(answerContainerPanel, BoxLayout.Y_AXIS));
//                  
//        for(int i = 0; i < number; i++){            
//           
//            panel = this.getEntryPanel(5, 5, 10, 5);
//            
//            if (myQuest.getAnswertype() == Quest.ANSWERTYPE.CheckBox){
//                panel.add(inputAnswersCheckbox[i]);               
//            } else if (myQuest.getAnswertype() == Quest.ANSWERTYPE.RadioButton){
//                panel.add(inputAnswersRadio[i]); 
//            }
//            
//            label = new JLabel((i+1) + ". ");
//            panel.add(label);           
//           
//            panel.add(label);
//            panel.add(inputAnswers[i]);
//            this.answerContainerPanel.add(panel);
//            
//        }         
        
        this.validate();
        
        System.out.println("displayModeCreate_AnswerPanels() exited:");
   
    }
    
    private void showQuestData_DebugMode(Quest myQuest){
         
        if (myQuest == null)
            return;
        
        this.inputQuesttext.setText(myQuest.getQuesttext()); 
        
        this.createQuestname.setText("This is Quest \"" + myQuest.getQuestname() + "\"");
        
        int size = myQuest.getQuestAnswerList().size();
        System.out.println("showQuestData myQuest.getQuestAnswerList().size(): " + size);

        int i;
        switch (myQuest.getAnswertype()){

            case Integer:
                this.inputAnswers[0].setText(myQuest.getQuestAnswerList().get(0).getAnswer());
                typeIntegerInput.setSelected(true);
                break;
            case Double:
                this.inputAnswers[0].setText(myQuest.getQuestAnswerList().get(0).getAnswer());
                typeDoubleInput.setSelected(true);
                break;
            case String:
                this.inputAnswers[0].setText(myQuest.getQuestAnswerList().get(0).getAnswer());
                typeStringInput.setSelected(true);
                break;
            case RadioButton:
                i = 0;
                for(QuestAnswer myQA : myQuest.getQuestAnswerList()){

                    this.inputAnswers[i].setText(myQA.getAnswer());
                    System.out.println("showQuestData - inputAnswers[i].setText(" + myQA.getAnswer() + ")");
                    this.inputAnswersRadio[i].setSelected(myQA.getCorrect().booleanValue());
                    i++;
                }                    
                typeRadiobutton.setSelected(true);
                break;
            case CheckBox:                    
                i = 0;
                for(QuestAnswer myQA : myQuest.getQuestAnswerList()){

                    this.inputAnswers[i].setText(myQA.getAnswer());
                    System.out.println("showQuestData - inputAnswers[i].setText(" + myQA.getAnswer() + ")");
                    System.out.println("showQuestData - inputAnswersCheckbox[i].setSelected(" + myQA.getCorrect() + ")");
                    System.out.println("showQuestData - inputAnswersCheckbox[i].setSelected(" + myQA.getCorrect().booleanValue() + ")");

                    if(myQA.getCorrect())
                        this.inputAnswersCheckbox[i].setSelected(true);
                    else
                        this.inputAnswersCheckbox[i].setSelected(false);

                    i++;
                }
                typeCheckbox.setSelected(true);    
                break;
        }                  
              
        this.validate();
                
     }
    
   
}



