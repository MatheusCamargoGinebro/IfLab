package com.projeto.iflab;

import components.test;
import javax.swing.JFrame;


public class IfLab {

    public static void main(String[] args) {
        test screen = new test();
        
        screen.setVisible(true);
        
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
