package com.example.examplejava;

import javax.swing.*;
import java.awt.*;

public class Game {public static ButtonAction[][] gameButtons;
    public JPanel panel;
    public JFrame window;
    public boolean isGameOver = false;
    public int gameCols;
    public int gameRows;

    public void setGameCols (int cols){
        gameCols=cols;
    }
    public void setGameRows (int rows){
        gameRows=rows;
    }
    public int getGameCols (){
        return gameCols;
    }
    public int getGameRows (){
        return gameRows;
    }

    public static void startGame (){
        panel = new JPanel();
        panel.setLayout(new GridLayout(gameRows,gameCols));
        window.add(panel);
        gameButtons = GameButtons.createButtons(panel, gameCols, gameRows);
        window.setVisible(true);
    }

    public static JFrame setGameWindow (int x, int y) {
        JFrame window = new JFrame();
        window.setSize(x, y);
        window.setTitle("Крестики-нолики");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return window;
    }

    public static void checkWinner () {
        int diagonal1 = gameButtons[0][0].gamerID + gameButtons[1][1].gamerID + gameButtons[2][2].gamerID;
        int dioganal2 = gameButtons[0][2].gamerID + gameButtons[1][1].gamerID + gameButtons[2][0].gamerID;
        int goriz1 = gameButtons[0][0].gamerID + gameButtons[0][1].gamerID + gameButtons[0][2].gamerID;
        int goriz2 = gameButtons[1][0].gamerID + gameButtons[1][1].gamerID + gameButtons[1][2].gamerID;
        int goriz3 = gameButtons[2][0].gamerID + gameButtons[2][1].gamerID + gameButtons[2][2].gamerID;
        int vertical1 = gameButtons[0][0].gamerID + gameButtons[1][0].gamerID + gameButtons[2][0].gamerID;
        int vertical2 = gameButtons[0][1].gamerID + gameButtons[1][1].gamerID + gameButtons[2][1].gamerID;
        int vertical3 = gameButtons[0][2].gamerID + gameButtons[1][2].gamerID + gameButtons[2][2].gamerID;
        if (diagonal1==3||dioganal2==3||goriz1==3||goriz2==3||goriz3==3||vertical1==3||vertical2==3||vertical3==3){
            dialog(MyImages.X, "Победили!");
        }
        else  if (diagonal1==0||dioganal2==0||goriz1==0||goriz2==0||goriz3==0||vertical1==0||vertical2==0||vertical3==0){
            dialog(MyImages.O, "Победили!");
        }
        boolean drawCheck = true;
        for (int x=0; x<gameRows; x++){
            for (int y=0; y<gameCols; y++){
                if (gameButtons[x][y].getIcon()==null){
                    drawCheck = false;
                    break;
                }
            }
        }
        if (drawCheck){
            dialog(MyImages.D, "Победила\n   дружба!");
        }

    }
    public static void dialog (ImageIcon picture, String message){
        Object[] options = {"Ещё играть!",
                "Закончить"};
        int n = JOptionPane.showOptionDialog(window,
                message,
                "Игра окончена!",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                picture,
                options,
                options[0]);
        if (n==0){
            window.remove(panel);
            ButtonAction.counter=0;
            startGame();
        }
        else {
            window.dispose();
        }
    }
}
