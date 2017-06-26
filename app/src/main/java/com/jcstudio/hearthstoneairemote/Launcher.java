package com.jcstudio.hearthstoneairemote;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class Launcher extends AppCompatActivity {
    ArrayList<Card> cards;
    LinearLayout cardBlock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        cardBlock = (LinearLayout) findViewById(R.id.card_block);

        DeckBuilder db = new DeckBuilder();
        cards = db.createDeck();

        for(Card c : cards){
            View v = c.createView(this, cardBlock, false, 0);
            if(v == null){
                continue;
            }
            v.setLayoutParams(new LinearLayoutCompat.LayoutParams(600, 900));
            cardBlock.addView(v);
        }
    }
}
