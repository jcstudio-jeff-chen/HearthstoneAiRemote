package com.jcstudio.hearthstoneairemote;

import java.util.ArrayList;

/**
 * Created by jeffrey on 2017/6/19.
 */

public class Game {
    public static final int ENEMY = 0;
    public static final int SELF = 1;
    public ArrayList<ArrayList<Card>> decks;
    public ArrayList<ArrayList<Card>> handCards;
    public ArrayList<ArrayList<Minion>> minions;
}
