package com.example.sanisidrodental.simonsays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class gameover extends AppCompatActivity {
    Button button_save;
    Button button_home;
    Button button_score;
    Intent x;
    Intent y;
    Intent z;
    TextView currentscore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);


        button_save = findViewById(R.id.button_back);
        button_save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                x = new Intent(getApplicationContext(),scorepage.class);
                startActivity(x);
            }

        });

        button_home = findViewById(R.id.button_back2);
        button_home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View vv) {
                y = new Intent(getApplicationContext(),homescreen.class);
                startActivity(y);
            }

        });

        button_score = findViewById(R.id.button_back3);
        button_score.setOnClickListener(new View.OnClickListener() {
            public void onClick(View vvv) {
                z = new Intent(getApplicationContext(),scorepage.class);
                startActivity(z);
            }

        });
    }
}
