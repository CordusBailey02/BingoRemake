package me.cordus;

import me.cordus.utilities.Randomizer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class GameScreen {
    private JPanel jPanel;
    private JButton buttonNextCall;
    private JButton buttonPrevCall;
    private JLabel labelCall;
    private JLabel labelDifficulty;
    private JPanel boardPanel;
    private JLabel b1;
    private JLabel i1;
    private JLabel n1;
    private JLabel g1;
    private JLabel o1;
    private JLabel b2;
    private JLabel i2;
    private JLabel n2;
    private JLabel g2;
    private JLabel o2;
    private JLabel b3;
    private JLabel i3;
    private JLabel Free;
    private JLabel g3;
    private JLabel o3;
    private JLabel b4;
    private JLabel i4;
    private JLabel n4;
    private JLabel g4;
    private JLabel o4;
    private JLabel b5;
    private JLabel i5;
    private JLabel n5;
    private JLabel g5;
    private JLabel o5;
    private JLabel bHeader;
    private JLabel iHeader;
    private JLabel nHeader;
    private JLabel gHeader;
    private JLabel oHeader;
    private static Game game = new Game();
    private static GameSettings gameSettings= new GameSettings();
    private String[][] boardNums = new String[5][5];
    private JLabel[] labelHeaders = {bHeader, iHeader, nHeader, gHeader, oHeader};
    private boolean clickPrevCall = false;

    public JPanel getjPanel()
    {
        return jPanel;
    }

    public GameScreen()
    {
        labelCall.setFont(new Font("Calibri", Font.PLAIN, 20));
        labelDifficulty.setFont(new Font("Calibri", Font.PLAIN, 20));
        labelCall.setForeground(Color.BLUE);
        labelDifficulty.setForeground(Color.BLUE);

        buttonNextCall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clickPrevCall == true)
                {
                    labelCall.setText(game.getLastCall());
                    clickPrevCall = false;
                }
                else
                {
                    labelCall.setText(game.generateCall(gameSettings.getDifficulty()));
                }
            }
        });

        // HAS ISSUE IF YOU DO PREV CALL THEN NEXT CALL
        buttonPrevCall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(game.getPrevCall().equalsIgnoreCase(""))
                {
                    labelCall.setText("No Previous Call");
                }
                else
                {
                    labelCall.setText(game.getPrevCall());
                }
                clickPrevCall = true;
            }
        });

        b1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(b1.getText().equalsIgnoreCase(String.valueOf(game.getNextCallNum())))
                {
                    b1.setForeground(Color.RED);
                }
            }
        });

    }

    /* Function that creates the numbers to put on the board and prints them there.
     * Creates board from left to right/top to bottom(Generates 1st row then moves down).
     * @parm diff The difficulty selected that determines the biggest that will be used on the board.
     */
    public void createBoardNums(String diff)
    {
        labelCall.setText(game.generateCall(gameSettings.getDifficulty()));

        int biggestNum;
        if(diff.equalsIgnoreCase("easy"))
        {
            biggestNum = 25;
            labelDifficulty.setText("Easy");
        }
        else if(diff.equalsIgnoreCase("medium"))
        {
            biggestNum = 75;
            labelDifficulty.setText("Medium");
        }
        else
        {
            biggestNum = 100;
            labelDifficulty.setText("Hard");
        }
        for(int row = 0; row < boardNums.length; row++)
        {
            List<Integer> repeats = new ArrayList<Integer>();
            for(int col = 0; col < boardNums.length ; col++)
            {
                labelHeaders[row].setFont(new Font("Calibri", Font.PLAIN, 25));

                int nextCall = Randomizer.nextInt(0, biggestNum);
                boardNums[row][col] = String.valueOf(nextCall);
                repeats.add(nextCall);
                while(repeats.contains(Integer.parseInt(boardNums[row][col])))
                {
                    nextCall = Randomizer.nextInt(0, biggestNum);
                    boardNums[row][col] = String.valueOf(nextCall);
                }

                if(row == 0 && col == 0)
                {
                    b1.setText(boardNums[row][col]);
                }
                else if(row == 0 && col == 1)
                {
                    i1.setText(boardNums[row][col]);
                }
                else if(row == 0 && col == 2)
                {
                    n1.setText(boardNums[row][col]);
                }
                else if(row == 0 && col == 3)
                {
                    g1.setText(boardNums[row][col]);
                }
                else if(row == 0 && col == 4)
                {
                    o1.setText(boardNums[row][col]);
                }

                else if(row == 1 && col == 0)
                {
                    b2.setText(boardNums[row][col]);
                }
                else if(row == 1 && col == 1)
                {
                    i2.setText(boardNums[row][col]);
                }
                else if(row == 1 && col == 2)
                {
                    n2.setText(boardNums[row][col]);
                }
                else if(row == 1 && col == 3)
                {
                    g2.setText(boardNums[row][col]);
                }
                else if(row == 1 && col == 4)
                {
                    o2.setText(boardNums[row][col]);
                }

                else if(row == 2 && col == 0)
                {
                    b3.setText(boardNums[row][col]);
                }
                else if(row == 2 && col == 1)
                {
                    i3.setText(boardNums[row][col]);
                }
                // N3 is the free space and is skipped here.
                else if(row == 2 && col == 3)
                {
                    g3.setText(boardNums[row][col]);
                }
                else if(row == 2 && col == 4)
                {
                    o3.setText(boardNums[row][col]);
                }

                else if(row == 3 && col == 0)
                {
                    b4.setText(boardNums[row][col]);
                }
                else if(row == 3 && col == 1)
                {
                    i4.setText(boardNums[row][col]);
                }
                else if(row == 3 && col == 2)
                {
                    n4.setText(boardNums[row][col]);
                }
                else if(row == 3 && col == 3)
                {
                    g4.setText(boardNums[row][col]);
                }
                else if(row == 3 && col == 4)
                {
                    o4.setText(boardNums[row][col]);
                }

                else if(row == 4 && col == 0)
                {
                    b5.setText(boardNums[row][col]);
                }
                else if(row == 4 && col == 1)
                {
                    i5.setText(boardNums[row][col]);
                }
                else if(row == 4 && col == 2)
                {
                    n5.setText(boardNums[row][col]);
                }
                else if(row == 4 && col == 3)
                {
                    g5.setText(boardNums[row][col]);
                }
                else if(row == 4 && col == 4)
                {
                    o5.setText(boardNums[row][col]);
                }
            }
            repeats.clear();
        }
    }

}
