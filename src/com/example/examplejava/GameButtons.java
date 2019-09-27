package com.example.examplejava;

import javax.swing.*;

public class GameButtons {
    public static ButtonAction[][] createButtons (JPanel panel, int cols, int rows, Game game) {
        ButtonAction button;
        ButtonAction[][] allButtons = new ButtonAction[cols][rows];

        for (int x=0; x<3; x++){
            for (int y=0; y<3; y++){
                button = new ButtonAction(game);
                allButtons[x][y] = button;
                panel.add(button);
            }
        }
        return allButtons;
    }
}
