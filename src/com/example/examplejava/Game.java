package com.example.examplejava;

import javax.swing.*;
import java.awt.*;

public class Game implements ActionDelegate{
    public ButtonAction[][] gameButtons;
    public JPanel panel;
    public JFrame window;
    public boolean isGameOver = false;
    public int height;
    public int width;
    public int gameCols;
    public int gameRows;

    public void startGame (){
        this.panel = new JPanel();
        this.panel.setLayout(new GridLayout(this.gameRows,this.gameCols));
        this.window.add(this.panel);
        this.gameButtons = GameButtons.createButtons(this.panel, this.gameCols, this.gameRows, this);
        this.window.setVisible(true);
    }

    public void setGameWindow (int x, int y) {
        this.window = new JFrame();
        this.window.setSize(x, y);
        this.window.setTitle("Крестики-нолики");
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void checkWinner () {
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
        else  if (diagonal1==0||dioganal2==0||goriz1==0||goriz2==0||goriz3==0||vertical1==0||vertical2==0|| vertical3==0){
            dialog(MyImages.O, "Победили!");
        }
        boolean drawCheck = true;
        for (int x=0; x<gameRows; x++){
            for (int y=0; y<gameCols; y++){
                if (gameButtons[x][y].gamerID==4){
                    drawCheck = false;
                    break;
                }
            }
        }
        if (drawCheck){
            dialog(MyImages.D, "Победила\n   дружба!");
        }
    }

    public void dialog (ImageIcon picture, String message){
        Object[] options = {"Ещё играть!",
                "Закончить"};
        int userResponse = JOptionPane.showOptionDialog(this.window,
                message,
                "Игра окончена!",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                picture,
                options,
                options[0]);
        if (userResponse==0){
            this.window.remove(this.panel);
            ButtonAction.counter=1;
            startGame();
        }
        else {
            this.window.dispose();
        }
    }
}
