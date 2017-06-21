package com.jcstudio.hearthstoneairemote;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class Launcher extends AppCompatActivity {
    FrameLayout cardSlot;
    FrameLayout cardSlot2;
    FrameLayout cardSlot3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        cardSlot = (FrameLayout) findViewById(R.id.card_slot);
        cardSlot2 = (FrameLayout) findViewById(R.id.card_slot_2);
        cardSlot3 = (FrameLayout) findViewById(R.id.card_slot_3);
        Card card = new Card();
        card.name = "超級賽亞人 尤格";
        card.cost = 10;
        card.picRes = R.drawable.goku;
        card.hasTaunt = false;
        card.hasShield = false;
        card.hasWindfury = false;
        card.hasStealth = false;
        card.cantBeTargeted = false;
        card.isCharged = false;
        card.isWeapon = false;
        card.isYogg = true;
        card.atk = 7;
        card.hp = 5;
        card.createView(this, cardSlot, true, 0);

        card = new Card();
        card.name = "超級賽亞人 奧拉基";
        card.cost = 8;
        card.picRes = R.drawable.goku;
        card.hasTaunt = true;
        card.hasShield = true;
        card.hasWindfury = true;
        card.hasStealth = false;
        card.cantBeTargeted = false;
        card.isCharged = true;
        card.isWeapon = false;
        card.isYogg = false;
        card.atk = 3;
        card.hp = 5;
        card.createView(this, cardSlot2, true, 0);

        card = new Card();
        card.name = "超級賽亞人 工程師";
        card.cost = 2;
        card.picRes = R.drawable.goku;
        card.hasTaunt = false;
        card.hasShield = false;
        card.hasWindfury = false;
        card.hasStealth = false;
        card.cantBeTargeted = false;
        card.isCharged = false;
        card.isWeapon = false;
        card.isYogg = false;
        card.drawCard = 1;
        card.atk = 1;
        card.hp = 1;
        card.createView(this, cardSlot3, true, 0);
    }
}
