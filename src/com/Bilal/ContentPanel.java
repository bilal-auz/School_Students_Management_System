package com.Bilal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ContentPanel extends JPanel {
    ArrayList<Student> stList;
    JTextField count = new JTextField();
    JLabel label = new JLabel("Students:");
    JTable table;

    ContentPanel(ArrayList<Student> stList){
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 70,50));
        this.setBackground(new Color(83,49,92));
        this.stList = stList;
        table = new JTable();
        building();
    }

    public void building(){
        Object [] col = {"ID","First Name","Last Name", "Age", "Level","Email"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(col);


        for (Student st : stList){
            Object [] row = new Object[6];
            row[0] = st.getID();
            row[1] = st.getFirstName();
            row[2] = st.getLastName();
            row[3] = st.getAge();
            row[4] = st.getLvlOfStudy();
            row[5] = st.getEmail();
            model.addRow(row);
        }

        table.setModel(model);
        table.setVisible(true);
        table.setDefaultEditor(Object.class, null);
        table.setRowSelectionAllowed(true);
        table.setRowHeight(20);
        table.getColumnModel().getColumn(0).setPreferredWidth(12);
        table.getColumnModel().getColumn(3).setPreferredWidth(30);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setPreferredWidth(150);
        table.setFont(new Font("arial", Font.BOLD, 15));
        table.setBackground(new Color(159, 176, 226));
        table.setForeground(Color.BLACK);

        JScrollPane pane = new JScrollPane(table);
        pane.setPreferredSize(new Dimension(500,250));
        pane.setEnabled(false);
        add(pane);

        label.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        label.setForeground(Color.BLACK);

        count.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        count.setPreferredSize(new Dimension(22, 30));
        count.setHorizontalAlignment(JTextField.CENTER);
        count.setText(Student.getCounter());
        count.setEditable(false);

        JPanel foot = new JPanel(new FlowLayout(FlowLayout.LEADING));
        foot.setBackground(this.getBackground());

        foot.add(label,BorderLayout.WEST);
        foot.add(count);

        add(foot);
    }


}
