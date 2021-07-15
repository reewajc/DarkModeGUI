package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Debug {

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();

    public static void main(String[] args) {
        new Debug();
    }

    public Debug(){
        // setting frame dimensions
        frame.setPreferredSize(new Dimension(300,225));
        panel.setBorder(BorderFactory.createEmptyBorder(30,10,15,10));
        Font verdana = new Font("Verdana", Font.PLAIN, 12);
        // create label with text to show the dark mode better
        JLabel loremLabel = new JLabel(getLoremIpsum());
        loremLabel.setFont(verdana);
        panel.add(loremLabel);

        // checkbox - if clicked, should change background and foregrounds
        JCheckBox themeCheckBox = new JCheckBox(" Dark Theme");
        themeCheckBox.setFont(verdana);
        panel.add(themeCheckBox);

        //Add the themeCheckBox actionListerner here
        themeCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBox checkBox = (JCheckBox) e.getSource();
                Component[] components = panel.getComponents();
                // if selected, enable dark mode
                if (checkBox.isSelected()){
                    panel.setBackground(Color.BLACK);
                    panel.setForeground(Color.WHITE);
                    for (int i = 0; i < components.length; i++) {
                        components[i].setBackground(Color.BLACK);
                        components[i].setForeground(Color.WHITE);
                    }
                }
                // else light mode
                else{
                    panel.setBackground(Color.WHITE);
                    panel.setForeground(Color.BLACK);
                    for (int i = 0; i < components.length; i++) {
                        components[i].setBackground(Color.WHITE);
                        components[i].setForeground(Color.BLACK);
                    }
                }
            }
        });

        // basic frame completion stuff
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Lorem Ipsum");
        frame.pack();
        frame.setVisible(true);

    }





    private String getLoremIpsum(){
        // wrapping the text in an HTML tag lets us use <br> as line breaks
        return "<html>Lorem ipsum dolor sit amet,<br>consectetur adipiscing elit." +
                "<br>Mauris dignissim a risus in imperdiet.<br>Phasellus fermentum suscipit lorem," +
                "<br>ac ornare metus accumsan eget.<br>Vestibulum sodales placerat molestie." +
                "<br>Duis quis vulputate.</html>";
    }
}
