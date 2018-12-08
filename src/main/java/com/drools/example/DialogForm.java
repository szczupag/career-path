package com.drools.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogForm {
    private JButton yesButton;
    private JButton noButton;
    private JButton maybeButton;
    private JPanel mainPanel;

    public DialogForm(){
        yesButton.addActionListener(e -> JOptionPane.showMessageDialog(null,"Yes"));
        noButton.addActionListener(e -> JOptionPane.showMessageDialog(null,"No"));
        maybeButton.addActionListener(e -> JOptionPane.showMessageDialog(null,"Maybe"));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new DialogForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
