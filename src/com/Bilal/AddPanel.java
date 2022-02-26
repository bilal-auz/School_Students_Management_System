package com.Bilal;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.*;

public class AddPanel extends JPanel implements ActionListener {
    JLabel firstName = new JLabel("First Name:");
    JLabel lastName = new JLabel("Last Name:");
    JLabel age = new JLabel("Age:");
    JLabel level = new JLabel("Level:");
    JLabel email = new JLabel("Email:");
    JTextField txtFName = new JTextField("", 10);
    JTextField txtLName= new JTextField("", 10);
    JTextField txtEmail= new JTextField("", 10);
//    JComboBox<Integer> cmboAge = new JComboBox<>();
    JTextField txtAge= new JTextField("", 2);
    JComboBox<String> lvlStudy = new JComboBox<String>();
    JButton btnSubmit;
    JButton btnClear;
    ArrayList<Student> stlist;
    //checking valid inputs
    boolean valid = false;
    //for Updating
    int row;

    AddPanel(ArrayList<Student> stList){
        this.setLayout(new GridLayout(6,1,20,20));
        this.setBackground(new Color(83,49,92));
        this.stlist = stList;

        btnSubmit = new JButton("Add");
        btnClear = new JButton("Clear");
        building();


        btnSubmit.addActionListener(this);
        btnClear.addActionListener(this);

        JPanel btnsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,0));
        btnsPanel.setBackground(new Color(83,49,92));
        btnsPanel.add(btnSubmit);
        btnsPanel.add(btnClear);
//        this.add(btnSubmit);
//        this.add(btnClear);
        this.add(btnsPanel);
    }
    //update
    AddPanel(int row,ArrayList<Student> stlist){
        System.out.println("udpate cons");
        this.setLayout(new GridLayout(6,1,20,30));
        this.setBackground(new Color(83,49,92));
//        this.setBorder(new EmptyBorder(100,100,100,100));
        this.stlist = stlist;

        btnSubmit = new JButton("Edit");
        btnClear = new JButton("Clear");
        building();

        this.row = row;
        fillingWithInfo();
        btnSubmit.addActionListener(this);
        this.add(btnSubmit);
    }


    public void building(){
        JPanel panel[] = new JPanel[5];
        Color c = new Color(83,49,92);
        for (int i =0; i < 5; i++) {
            panel[i] = new JPanel(new FlowLayout(FlowLayout.LEADING, 10,25));
            panel[i].setBackground(c);
            panel[i].setBorder(new EmptyBorder(10,50,10,10));
        }

//        panel[0] = new JPanel(new FlowLayout(FlowLayout.LEADING));
//        panel[0].setBackground(c);
        panel[0].add(firstName);
        panel[0].add(txtFName);
//        this.add(panel[0]);

//        panel[1] = new JPanel(new FlowLayout(FlowLayout.LEADING));
//        panel[1].setBackground(c);
        panel[1].add(lastName);
        panel[1].add(txtLName);
//        this.add(panel[1]);

        //editing panel design
//        txtAge.setBorder(new EmptyBorder(0,100,0,0));
        panel[2].add(age);
        panel[2].add(txtAge);
//        this.add(panel[2]);
        lvlStudy.addItem("Sophomore");
        lvlStudy.addItem("Junior");
        lvlStudy.addItem("Senior");
        lvlStudy.setSelectedIndex(0);
//        panel[3] = new JPanel(new FlowLayout(FlowLayout.LEADING));
//        panel[3].setBackground(c);
        panel[3].add(level);
        panel[3].add(lvlStudy);
//        this.add(panel[3]);

//        panel[4] = new JPanel(new FlowLayout(FlowLayout.LEADING));
//        panel[4].setBackground(c);
        panel[4].add(email);
        panel[4].add(txtEmail);
//        this.add(panel[4]);

        for (int i = 0; i < panel.length; i++){
            this.add(panel[i]);
        }
        settingComponents();
    }


    public void settingComponents(){
        Font f = new Font("TimesRoman", Font.PLAIN, 25);
//        Color bf =  new Color(35, 4, 38);
        Color bf =  Color.WHITE;
        Color txtColor = Color.BLACK;

        firstName.setFont(f);
        firstName.setForeground(bf);

        txtFName.setFont(f);
        txtFName.setForeground(txtColor);

        lastName.setFont(f);
        lastName.setForeground(bf);

        txtLName.setFont(f);
        txtLName.setForeground(txtColor);

        age.setBorder(new EmptyBorder(0,35,0,38));
        age.setFont(f);
        age.setForeground(bf);

        txtAge.setFont(f);
        txtAge.setForeground(txtColor);

        level.setBorder(new EmptyBorder(0,25,0,29));
        level.setFont(f);
        level.setForeground(bf);

        lvlStudy.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        lvlStudy.setPreferredSize(new Dimension(220,35));
        lvlStudy.setForeground(txtColor);
        lvlStudy.setBackground(Color.WHITE);

        email.setBorder(new EmptyBorder(0,25,0,20));
        email.setFont(f);
        email.setForeground(bf);

        txtEmail.setFont(f);
        txtEmail.setForeground(txtColor);

        btnSubmit.setBackground(new Color(35, 4, 38));
        btnSubmit.setForeground(Color.pink);
        btnSubmit.setPreferredSize(new Dimension(150,40));
        btnSubmit.setBorder(BorderFactory.createRaisedBevelBorder());
        btnSubmit.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        btnSubmit.setFocusable(false);

        btnClear.setBackground(new Color(35,4,38));
        btnClear.setForeground(Color.pink);
        btnClear.setPreferredSize(new Dimension(150,40));
        btnClear.setBorder(BorderFactory.createRaisedBevelBorder());
        btnClear.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        btnClear.setFocusable(false);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Add":
                addingNewStudent();
                break;
            case "Edit":
                System.out.println("event edit");
                updatingStudent();
                break;
            case "Clear":
                clearTxtFeild();
                break;
            default:
                System.out.println("no adding no updating");
        }
        if(valid){
            var p = this.getParent();
            p.setVisible(false);
            p.remove(this);
            p.add(new ContentPanel(stlist));
            p.revalidate();
            p.repaint();
            p.setVisible(true);
            valid = false;
        }

    }

    private void addingNewStudent(){
        String fName =  capitalize(txtFName.getText());
        String lName = txtLName.getText().toUpperCase();
        int age;
        try {
            if(txtAge.getText().isEmpty()){
                age = 0;
            }else{
                age = Integer.parseInt(txtAge.getText());
            }
        }catch (Exception NumberFormatException){
            age = 0;
        }
        System.out.println(age);
        String lvl = lvlStudy.getItemAt(lvlStudy.getSelectedIndex());
        String email = txtEmail.getText();
        try{
            isValidName(fName,lName);
            isValidAge(age);
            isValidEmail(email);
            Student s = new Student(fName,lName,age,lvl,email);
            stlist.add(s);
            valid = true;
        }catch (Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage(), "Warring", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updatingStudent(){
        String fName = capitalize(txtFName.getText());
        String lName = txtLName.getText().toUpperCase();
        int age;
        try {
            if(txtAge.getText().isEmpty()){
                age = 0;
            }else{
                age = Integer.parseInt(txtAge.getText());
            }
        }catch (Exception NumberFormatException){
            age = 0;
        }
        String lvl = lvlStudy.getItemAt(lvlStudy.getSelectedIndex());
        String email = txtEmail.getText();

        try{
            isValidName(fName,lName);
            isValidAge(age);
            isValidEmail(email);
            System.out.println(row+"::update");
            stlist.get(row).setFirstName(fName);
            stlist.get(row).setLastName(lName);
            stlist.get(row).setAge(age);
            stlist.get(row).setLvlOfStudy(lvl);
            stlist.get(row).setEmail(email);
            valid = true;
        }catch (Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage(), "Warring", JOptionPane.ERROR_MESSAGE);
        }
    }


    //clear Fields
    private void clearTxtFeild(){
        txtFName.setText("");
        txtLName.setText("");
        txtAge.setText("");
        lvlStudy.setSelectedIndex(0);
        txtEmail.setText("");
    }


    //Capitalizeing Strings
    private String capitalize(String str){
        if(str == null || str.isEmpty())
            return str;
        return str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();
    }

    private boolean isValidName(String f, String l) throws Exception {
        if (f.isEmpty() || l.isEmpty()){
            throw new Exception("Empty Field");
        }
        for(Student st : stlist){
            if(st.getFirstName().equals(f) && st.getLastName().equals(l) && st.getID()!= row+1){
                throw new Exception("The Name is Taken");
            }
        }
        return true;
    }

    private boolean isValidAge(int age) throws Exception {
        if(age < 16){
            throw new Exception("The Student Must be 16 or older");
        }
        return true;
    }

    private boolean isValidEmail(String email) throws Exception{
        if(email.isEmpty()){
            throw new Exception("Empty Field");
        }

        //check if email is taken
        for (Student st : stlist){
            if(st.getEmail().equals(email) && st.getID() != row+1){
                throw new Exception("The email is Taken");
            }
        }
        //end of checking

        Pattern p = Pattern.compile("(^[a-zA-Z])([a-zA-Z0-9]){4,}(@univ.com)$");
        Matcher m = p.matcher(email);
        if(m.find()){
            return true;
        }else{
            throw new Exception("The Invalid Email");
        }
    }

    private void fillingWithInfo(){
        txtFName.setText(stlist.get(row).getFirstName());
        txtLName.setText(stlist.get(row).getLastName());
        txtAge.setText(String.valueOf(stlist.get(row).getAge()));
        lvlStudy.setSelectedItem(stlist.get(row).getLvlOfStudy());
        txtEmail.setText(stlist.get(row).getEmail());
    }
}
