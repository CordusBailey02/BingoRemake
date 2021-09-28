package me.cordus;

import me.cordus.utilities.ConsoleProgram;

import javax.swing.*;

public class Main extends ConsoleProgram {

    public static JFrame frame = new JFrame();
    private static GameSettings gameSettings = new GameSettings();

    public void run()
    {
        frame.setTitle("Bingo Remake");
        frame.setVisible(true);
        frame.setSize(650,650);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(true);

        frame.setContentPane(gameSettings.getjPanel());
    }
}
