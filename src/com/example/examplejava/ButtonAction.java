package com.example.examplejava;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonAction extends JButton implements ActionListener {
    public ButtonAction (ActionDelegate actionDelegate){
        super.addActionListener(this);
        delegate=actionDelegate;
    }

    public ActionDelegate delegate;
    public static int counter = 0;
    public int gamerID=4;

    @Override
    public void actionPerformed (ActionEvent e){
        if (counter==0){
            setIcon(MyImages.X);
            removeActionListener(this);
            gamerID=1;
            delegate.checkWinner();
        }
        else if (counter==1){
            setIcon(MyImages.O);
            removeActionListener(this);
            gamerID=0;
            delegate.checkWinner();
        }
        counter=(counter+1)%2;
    }
}