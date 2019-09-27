package com.example.examplejava;

import java.io.*;
import java.security.PublicKey;
import java.util.*;
import java.lang.*;
import java.awt.*;
import javax.swing.*;


public class ExampleJava {

    public static void main(String[] args) throws Exception {
        Game game = new Game();
        game.gameCols = 3;
        game.gameRows = 3;
        game.width = 350;
        game.height = 350;
        game.setGameWindow(game.width, game.height);
        game.startGame();
    }
}



