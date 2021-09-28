package me.cordus;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameSettings {
    private JPanel jPanel;
    private JButton startButton;
    private JComboBox comboBoxDifficulty;
    private static GameScreen gameScreen = new GameScreen();

    public JPanel getjPanel()
    {
        return jPanel;
    }
    public String getDifficulty() { return comboBoxDifficulty.getSelectedItem().toString(); }

    public GameSettings()
    {
        startButton.setText("Start");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.setContentPane(gameScreen.getjPanel());
                gameScreen.createBoardNums(getDifficulty());
                Main.frame.revalidate();
            }
        });

    }
}
