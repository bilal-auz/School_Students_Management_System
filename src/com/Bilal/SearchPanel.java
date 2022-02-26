package com.Bilal;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchPanel extends JPanel implements ActionListener {
    ArrayList<Student> stList;
    JPanel panel[] = new JPanel[3];
    JTable table;
    JLabel firstName = new JLabel("First Name:");
    JLabel lastName = new JLabel("Last Name:");
    JTextField txtFName = new JTextField("", 10);
    JTextField txtLName= new JTextField("", 10);
    JButton btnSearch = new JButton("Search");

    SearchPanel(ArrayList<Student> stList){
        this.setLayout(new FlowLayout(FlowLayout.CENTER,20,50));
        this.setBorder(new EmptyBorder(60,0,0,0));
        this.setBackground(new Color(83,49,92));
        this.stList = stList;
        table = new JTable();
        building();
    }

    private void building(){
        panel[0] = new JPanel(new FlowLayout(FlowLayout.LEADING));
        panel[0].add(firstName);
        panel[0].add(txtFName);

        panel[1] = new JPanel(new FlowLayout(FlowLayout.LEADING));
        panel[1].add(lastName);
        panel[1].add(txtLName);

        panel[2] = new JPanel(new FlowLayout(FlowLayout.LEADING));
        btnSearch.addActionListener(this);
        panel[2].add(btnSearch);

        settingComps();
        this.add(panel[0]);
        this.add(panel[1]);
        this.add(panel[2]);
    }

    private void settingComps(){
        Font font = new Font("TimesRoman", Font.PLAIN, 25);
//        Color f = new Color(35, 4, 38);
        Color f = Color.BLACK;
        for (int i = 0; i < panel.length; i++){
//            panel[i].setBackground(this.getBackground());
            panel[i].setForeground(f);
            panel[i].setBackground(Color.WHITE);
        }
        firstName.setFont(font);
        firstName.setForeground(f);

        lastName.setFont(font);
        lastName.setForeground(f);

        txtFName.setFont(font);
        txtFName.setForeground(f);

        txtLName.setFont(font);
        txtLName.setForeground(f);

        //btn panel
        panel[2].setBackground(getBackground());

        btnSearch.setBackground(new Color(35, 4, 38));
        btnSearch.setForeground(Color.pink);
        btnSearch.setBorder(BorderFactory.createRaisedBevelBorder());
        btnSearch.setFont(font);
        btnSearch.setFocusable(false);
        btnSearch.setPreferredSize(new Dimension(150,40));
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String fName = txtFName.getText();
        String lName = txtLName.getText();
        boolean found = false;
        ArrayList<Student> tempList = new ArrayList<>();
        for (Student st : stList){
            if(st.getFirstName().equalsIgnoreCase(fName) && st.getLastName().equalsIgnoreCase(lName)){
                Object [] col = {"ID","First Name","Last Name", "Age", "Level","Email"};
                DefaultTableModel model = new DefaultTableModel();
                model.setColumnIdentifiers(col);

                Object [] row = new Object[6];
                row[0] = st.getID();
                row[1] = st.getFirstName();
                row[2] = st.getLastName();
                row[3] = st.getAge();
                row[4] = st.getLvlOfStudy();
                row[5] = st.getEmail();
                model.addRow(row);
                table.setModel(model);
                table.setDefaultEditor(Object.class, null);
                tempList.add(st);
                found = true;
            }
        }

        if(found){
            JScrollPane pane = new JScrollPane(table);
            this.setVisible(false);
            this.remove(panel[0]);
            this.remove(panel[1]);
            this.remove(panel[2]);
            this.add(pane);
            this.revalidate();
            this.repaint();
            this.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this,"Can't Find The Student","Result", JOptionPane.ERROR_MESSAGE);
//            var p = this.getParent();
//            p.setVisible(false);
//            p.remove(this);
//            p.add(new ContentPanel(stList));
//            p.revalidate();
//            p.repaint();
//            p.setVisible(true);
        }
    }
}
