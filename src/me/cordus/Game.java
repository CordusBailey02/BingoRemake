package me.cordus;

import me.cordus.utilities.Randomizer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game
{
    private static GameSettings gameSettings = new GameSettings();
    private static List calls = new ArrayList<>(1);
    private char[] letters = {'B', 'I', 'N', 'G', 'O'};
    private String nextCall = "";
    private String prevCall;
    private int nextCallNum;

    public Game()
    {

    }

    public String getPrevCall()
    {
        return calls.get(calls.size() - 2)+"";
    }

    public int getNextCallNum()
    {
        return nextCallNum;
    }

    public String getLastCall()
    {
        return calls.get(calls.size() - 1)+"";
    }

    public String generateCall(String diff)
    {
        prevCall = nextCall;
        nextCall = "";
        int biggestNum;
        if(diff.equalsIgnoreCase("easy"))
        {
            biggestNum = 25;
        }
        else if(diff.equalsIgnoreCase("medium"))
        {
            biggestNum = 75;
        }
        else
        {
            biggestNum = 100;
        }
        int letterSel = Randomizer.nextInt(0,4);
        switch (letterSel) {
            case 0 -> nextCall += letters[0];
            case 1 -> nextCall += letters[1];
            case 2 -> nextCall += letters[2];
            case 3 -> nextCall += letters[3];
            case 4 -> nextCall += letters[4];
        }
        nextCallNum = Randomizer.nextInt(0,biggestNum);
        nextCall += " " + nextCallNum;

        calls.add(nextCall);
        return nextCall;
    }
}
