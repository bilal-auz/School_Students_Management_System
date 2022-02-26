package com.Bilal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.ArrayList;

public class MainPanel extends JPanel implements ActionListener {
    static final int SCREEN_WIDTH = 700;
    static final int SCREEN_HEIGHT = 600;
    JButton [] btns = new JButton[5];
    public JPanel btnsPanel,contentPanel;
    ArrayList<Student> studentList = new ArrayList<>();
    MainPanel(){
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
//        this.setBackground(new Color(35, 4, 38, 0));
        btnsPanel = new BtnsPanel();
        contentPanel = new ContentPanel(studentList);
        building();
        this.add(btnsPanel,BorderLayout.WEST);
        this.add(contentPanel,BorderLayout.CENTER);
//        this.add(addPanel, BorderLayout.CENTER);
    }


    public void building(){
        btns[0] = new JButton("Add");
        btns[1] = new JButton("Update");
        btns[2] = new JButton("Search");
        btns[3] = new JButton("Delete");
        btns[4] = new JButton("Generate");
        for (int i =0; i< btns.length; i++){
            btns[i].setBackground(new Color(35, 4, 38));
            btns[i].setForeground(Color.pink);
            btns[i].setBorder(BorderFactory.createRaisedBevelBorder());
            btns[i].setFont(new Font("TimesRoman", Font.PLAIN, 20));
            btns[i].setFocusable(false);
            btns[i].addActionListener(this);
            btnsPanel.add(btns[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Add":
                this.setVisible(false);
                this.removeAll();
                this.add(btnsPanel, BorderLayout.WEST);
                contentPanel = new AddPanel(studentList);
                this.add(contentPanel,BorderLayout.CENTER);
                this.revalidate();
                this.repaint();
                this.setVisible(true);
                break;
            case "Update":
                this.setVisible(false);
                this.removeAll();
                this.add(btnsPanel, BorderLayout.WEST);
                contentPanel = new UpdatePanel(studentList);
                this.add(contentPanel, BorderLayout.CENTER);
                this.revalidate();
                this.repaint();
                this.setVisible(true);
                break;
            case "Delete":
                this.setVisible(false);
                this.removeAll();
                this.add(btnsPanel, BorderLayout.WEST);
                contentPanel = new DeletePanel(studentList);
                this.add(contentPanel,BorderLayout.CENTER);
                this.revalidate();
                this.repaint();
                this.setVisible(true);
                break;
            case "Search":
                this.setVisible(false);
                this.removeAll();
                this.add(btnsPanel,BorderLayout.WEST);
                contentPanel = new SearchPanel(studentList);
                this.add(contentPanel, BorderLayout.CENTER);
                this.revalidate();
                this.repaint();
                this.setVisible(true);
                break;
            case "Generate":
                generateFile();
                break;
            default:
                System.out.println("Error Selecting function");
        }
    }

    private void generateFile(){
        String listInfo = "";
        try{
            FileWriter fileWriter = new FileWriter("src/StudentRecords.txt");
            for(Student student: studentList){
                listInfo += student.toString();
            }
            fileWriter.write(listInfo);
            fileWriter.close();
        }catch (Exception e){
            System.out.println("Error Happend");
        }
    }
}
