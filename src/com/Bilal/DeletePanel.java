package com.Bilal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeletePanel extends JPanel implements ActionListener {
    ArrayList<Student> stList;
    JTable table;
    JButton btnDelete = new JButton("Delete");

    DeletePanel(ArrayList<Student> stList){
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 70,50));
        this.setBackground(new Color(83,49,92));
        this.stList = stList;
        table = new JTable();
        building();
    }

    private void building(){
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
        table.setDefaultEditor(Object.class, null);//editing option
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
        getPanel().add(pane);

        btnDelete.setBackground(new Color(35, 4, 38));
        btnDelete.setForeground(Color.pink);
        btnDelete.setBorder(BorderFactory.createRaisedBevelBorder());
        btnDelete.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        btnDelete.setFocusable(false);
        btnDelete.setPreferredSize(new Dimension(150,40));
        btnDelete.addActionListener(this);
        this.add(btnDelete);
    }

    private JPanel getPanel(){
        return this;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(stList.size() <= 0){
                throw new Exception("No Students To Delete");
            }

            if(table.getSelectedRow() < 0){
                throw new Exception("No Selected Row");
            }

            if(stList.size() > 0){
                int row = table.getSelectedRow();
                stList.remove(row);
                Student.decrementCounter();

                var p = getParent();
                p.setVisible(false);
                p.remove(getPanel());
                p.add(new ContentPanel(stList));
                p.revalidate();
                p.repaint();
                p.setVisible(true);
            }
        }catch (Exception ex){
            JOptionPane.showMessageDialog(this,ex.getMessage());
        }


    }
}
