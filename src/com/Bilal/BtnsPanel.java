package com.Bilal;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnsPanel extends JPanel implements ActionListener {
    JButton [] btns = new JButton[4];

    static final int PADDING = 20;
    BtnsPanel(){
        this.setPreferredSize(new Dimension(600/4,500));
        this.setLayout(new GridLayout(5,1,20,50));
        this.setBackground(new Color(137, 126, 167));
        this.setBorder(new EmptyBorder(PADDING+20,PADDING-10,PADDING+20,PADDING-10));
//        building();
    }

    public void building(){
        btns[0] = new JButton("Add");
        btns[1] = new JButton("Update");
        btns[2] = new JButton("Search");
        btns[3] = new JButton("Delete");
        for (int i =0; i< btns.length; i++){
            btns[i].setBackground(new Color(35, 4, 38));
            btns[i].setForeground(Color.pink);
            btns[i].setBorder(BorderFactory.createRaisedBevelBorder());
            btns[i].setFont(new Font("TimesRoman", Font.PLAIN, 15));
            btns[i].setFocusable(false);
            btns[i].addActionListener(this);
            this.add(btns[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }
}
