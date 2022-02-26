package com.Bilal;

import javax.swing.*;

public class Frame extends JFrame {
    Frame(){
        this.add(new MainPanel());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
