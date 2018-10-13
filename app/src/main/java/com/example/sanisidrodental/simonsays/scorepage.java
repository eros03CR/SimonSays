package com.example.sanisidrodental.simonsays;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class scorepage extends AppCompatActivity {
    Button button_back;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorepage);

        button_back = findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                i = new Intent(getApplicationContext(),homescreen.class);
                startActivity(i);
            }

        });
    }
}
