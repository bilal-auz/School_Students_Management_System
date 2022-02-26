package com.Bilal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UpdatePanel extends JPanel implements ActionListener {
    ArrayList<Student> stList;
    JTable table;
    JButton btnEdit = new JButton("Edit");

    UpdatePanel(ArrayList<Student> stList){
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 65,50));
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
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane pane = new JScrollPane(table);
        pane.setPreferredSize(new Dimension(500,250));
        pane.setEnabled(false);
        add(pane);

        btnEdit.setPreferredSize(new Dimension(150,40));
        btnEdit.setBackground(new Color(35, 4, 38));
        btnEdit.setForeground(Color.pink);
        btnEdit.setBorder(BorderFactory.createRaisedBevelBorder());
        btnEdit.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        btnEdit.setFocusable(false);
        btnEdit.addActionListener(this);
        add(btnEdit);
    }
    public JPanel getPanel(){
        return this;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int row = table.getSelectedRow();
        if(row>-1){
            System.out.println("Row:"+row);

            //calling AddPanel but for Updating
            var p = getPanel().getParent();
            p.setVisible(false);
            p.remove(getPanel());
            p.add(new AddPanel(row,stList));
            p.revalidate();
            p.repaint();
            p.setVisible(true);
        }
    }
}
