package com.example.sanisidrodental.simonsays;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class homescreen extends AppCompatActivity {
    Button button_game;
    Button button_score;
    Intent game;
    Intent highscores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        button_game = findViewById(R.id.playgamebutton);
        button_game.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                game = new Intent(getApplicationContext(),game.class);
                startActivity(game);                 }

        });

        button_score= findViewById(R.id.highscorebutton);
        button_score.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                highscores = new Intent(getApplicationContext(),scorepage.class);
                startActivity(highscores);                 }

        });
    }
}

