package com.example.sanisidrodental.simonsays;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class game extends AppCompatActivity {
    //Here define variables
    TextView currentscore;
    Button button_start;
    ImageButton button_japan;
    ImageButton button_poland;
    ImageButton button_germany;
    ImageButton button_italy;
    ImageButton button_turkey;
    ImageButton button_brazil;
    MediaPlayer sound_japan;
    MediaPlayer sound_poland;
    MediaPlayer sound_germany;
    MediaPlayer sound_italy;
    MediaPlayer sound_turkey;
    MediaPlayer sound_brazil;
    int option;
    int min = 0;
    int max = 4;
    int selecting;
    int count;
    int n = 1;
    int level=1;
    Intent x;

    String score;
    private Handler mHandler = new Handler();
    //End Variable Definition
    Queue<Integer> sequence = new LinkedList<>();
    Queue<Integer> playersequence = new LinkedList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
 
        currentscore = findViewById(R.id.currentScore);
        currentscore.setText("0");

        //when the start button is pressed
        //start button functionality
        button_start = findViewById(R.id.startButton);
        sound_japan = MediaPlayer.create(this, R.raw.japanese);
        sound_poland = MediaPlayer.create(this, R.raw.polish);
        sound_germany = MediaPlayer.create(this, R.raw.german);
        sound_italy = MediaPlayer.create(this, R.raw.italian);
        sound_turkey = MediaPlayer.create(this, R.raw.turkish);
        sound_brazil = MediaPlayer.create(this, R.raw.portuguese);


        button_start.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (level!=0) {
                    //Random number is created

                    for (int i = 0; i < n; i++) {
                        Random rm = new Random();
                        int selectedOption = rm.nextInt(max - min + 1) - min;
                        sequence.add(selectedOption);
                        System.out.println("Random Number: " + selectedOption);
                    }

                    next:
                    for (int i = 0; i < n; i++) {
                        mHandler.postDelayed(Runnable, 2000);
                        int peek = ((LinkedList<Integer>) sequence).peekFirst();
                        System.out.println("Sequence: " + sequence);
                        System.out.println("Numero: " + peek);
                        switch (peek) {
                            case 0:
                                //For Japan
                                SimonSaysJapan();
                                sequence.remove();
                                continue next;
                                //ends automatic sequence for Japan
                            case 1:
                                //For Japan
                                SimonSaysPoland();
                                sequence.remove();
                                continue next;
                                //ends automatic sequence for Poland
                            case 2:
                                //For Poland
                                SimonSaysGermany();
                                sequence.remove();
                                continue next;
                                //ends automatic sequence for Germany
                            case 3:
                                //For Japan
                                SimonSaysItaly();
                                sequence.remove();
                                continue next;
                                //ends automatic sequence for Italy
                            case 4:
                                //For Japan
                                SimonSaysTurkey();
                                sequence.remove();
                                continue next;
                                //ends automatic sequence for Turkey
                            case 5:
                                //For Japan
                                SimonSaysBrazil();
                                sequence.remove();
                                continue next;
                                //ends automatic sequence for Brazil

                            default:
                                System.out.println("FIN");
                                break;
                            //ends autoplay
                        }
                    }
                    //after it is selected
                    System.out.println("Switch was completed");
                    JapanSelected();
                    PolandSelected();
                    GermanySelected();
                    ItalySelected();
                    TurkeySelected();
                    BrazilSelected();
                    mHandler.postDelayed(Runnable, 5000);

                }else{

                    if (option != selecting) {
                        System.out.println("GAME OVER");
                        mHandler.postDelayed(stop, 1);
                        x = new Intent(getApplicationContext(), gameover.class);
                        startActivity(x);

                    }
                }

            }
        });
    }


    //HERE DEFINE AUTO PLAY SEQUENCE
    //Japan sound autoplay
    public void SimonSaysJapan() {
        //select button to use
        button_japan = findViewById(R.id.japanButton);
        //defines what to do when button is pressed

        //background button is changed(turned on)
        //play the sound
        //The option is defined
        option = 0;
        button_japan.setBackgroundResource(R.drawable.japan_on);
        //reproduces sound
        sound_japan.start();

        //going back to original background
        mHandler.postDelayed(stop, 1000);

    }

    //Poland sound autoplay
    public void SimonSaysPoland() {
        //select button to use
        button_poland = findViewById(R.id.polandButton);
        //defines what to do when button is pressed

        //background button is changed(turned on)
        //play the sound
        button_poland.setBackgroundResource(R.drawable.poland_on);
        //The option is defined
        option = 1;
        //reproduces sound
        sound_poland.start();
        //going back to original background
        mHandler.postDelayed(stop, 1000);
    }

    //Germany sound autoplay
    public void SimonSaysGermany() {
        //select button to use
        button_germany = findViewById(R.id.germanyButton);
        //defines what to do when button is pressed

        //background button is changed(turned on)
        //play the sound
        button_germany.setBackgroundResource(R.drawable.germany_on);
        //The option is defined
        option = 2;
        //reproduces sound
        sound_germany.start();
        //going back to original background
        mHandler.postDelayed(stop, 1000);
    }

    //Germany sound autoplay
    public void SimonSaysItaly() {
        //select button to use
        button_italy = findViewById(R.id.italyButton);
        //defines what to do when button is pressed

        //background button is changed(turned on)
        //play the sound
        button_italy.setBackgroundResource(R.drawable.italy_on);
        //The option is defined
        option = 3;
        //reproduces sound
        sound_italy.start();
        //going back to original background
        mHandler.postDelayed(stop, 1000);
    }

    //Turkey sound autoplay
    public void SimonSaysTurkey() {
        //select button to use
        button_turkey = findViewById(R.id.turkeyButton);
        //defines what to do when button is pressed

        //background button is changed(turned on)
        //play the sound
        button_turkey.setBackgroundResource(R.drawable.turkey_on);
        //The option is defined
        option = 4;
        //reproduces sound
        sound_turkey.start();
        //going back to original background
        mHandler.postDelayed(stop, 1000);
    }

    //Brazil sound autoplay
    public void SimonSaysBrazil() {
        //select button to use
        button_brazil= findViewById(R.id.brazilButton);
        //defines what to do when button is pressed

        //background button is changed(turned on)
        //play the sound
        button_brazil.setBackgroundResource(R.drawable.brazil_on);
        //The option is defined
        option = 5;
        //reproduces sound
        sound_brazil.start();
        //going back to original background
        mHandler.postDelayed(stop, 1000);
    }
    //END AUTOPLAY EXECUTION

    //PLAYER MOVES DEFINITION
    //PLAYER MOVES
    public void JapanSelected() {
        final MediaPlayer sound_japan = MediaPlayer.create(this, R.raw.japanese);
        //select button to use
        //For Japan
        button_japan = findViewById(R.id.japanButton);

        button_japan.setOnClickListener(new View.OnClickListener() {
            //defines what to do when button is pressed
            @Override
            public void onClick(View v) {
                //background button is changed
                button_japan.setBackgroundResource(R.drawable.japan_on);
                //play the sound
                sound_japan.start(); // no need to call prepare(); create() does that for you
                selecting = 0;
                System.out.println("Japan: " + selecting);
                //Updating Score
                scoring();
                //going back to original background
                mHandler.postDelayed(stop, 1000);
            }
        });
    }


    public void PolandSelected() {
        final MediaPlayer sound_poland = MediaPlayer.create(this, R.raw.polish);
        //select button to use
        //For Poland
        button_poland = findViewById(R.id.polandButton);
        button_poland.setOnClickListener(new View.OnClickListener() {
            //defines what to do when button is pressed
            @Override
            public void onClick(View v) {
                //background button is changed
                button_poland.setBackgroundResource(R.drawable.poland_on);
                //play the sound
                sound_poland.start(); // no need to call prepare(); create() does that for you
                selecting = 1;
                System.out.println("Poland: " + selecting);
                //Updating Score
                scoring();
                //going back to original background
                mHandler.postDelayed(stop, 1000);
            }
        });
    }

    public void GermanySelected() {
        final MediaPlayer sound_germany = MediaPlayer.create(this, R.raw.german);
        //select button to use
        //For Poland
        button_germany = findViewById(R.id.germanyButton);
        button_germany.setOnClickListener(new View.OnClickListener() {
            //defines what to do when button is pressed
            @Override
            public void onClick(View v) {
                //background button is changed
                button_germany.setBackgroundResource(R.drawable.germany_on);
                //play the sound
                sound_germany.start(); // no need to call prepare(); create() does that for you
                selecting = 2;
                System.out.println("Germany: " + selecting);
                //Updating Score
                scoring();
                //going back to original background
                mHandler.postDelayed(stop, 1000);
            }
        });
    }

    public void ItalySelected() {
        final MediaPlayer sound_italy = MediaPlayer.create(this, R.raw.italian);
        //select button to use
        //For Poland
        button_italy = findViewById(R.id.italyButton);
        button_italy.setOnClickListener(new View.OnClickListener() {
            //defines what to do when button is pressed
            @Override
            public void onClick(View v) {
                //background button is changed
                button_italy.setBackgroundResource(R.drawable.italy_on);
                //play the sound
                sound_italy.start(); // no need to call prepare(); create() does that for you
                selecting = 3;
                System.out.println("Italy: " + selecting);
                //Updating Score
                scoring();
                //going back to original background
                mHandler.postDelayed(stop, 1000);
            }
        });
    }

    public void TurkeySelected() {
        final MediaPlayer sound_turkey = MediaPlayer.create(this, R.raw.turkish);
        //select button to use
        //For Turkey
        button_turkey = findViewById(R.id.turkeyButton);
        button_turkey.setOnClickListener(new View.OnClickListener() {
            //defines what to do when button is pressed
            @Override
            public void onClick(View v) {
                //background button is changed
                button_turkey.setBackgroundResource(R.drawable.turkey_on);
                //play the sound
                sound_turkey.start(); // no need to call prepare(); create() does that for you
                selecting = 4;
                System.out.println("Turkey: " + selecting);
                //Updating Score
                scoring();
                //going back to original background
                mHandler.postDelayed(stop, 1000);
            }
        });
    }

    public void BrazilSelected() {
        final MediaPlayer sound_brazil = MediaPlayer.create(this, R.raw.portuguese);
        //select button to use
        //For Poland
        button_brazil = findViewById(R.id.brazilButton);
        button_brazil.setOnClickListener(new View.OnClickListener() {
            //defines what to do when button is pressed
            @Override
            public void onClick(View v) {
                //background button is changed
                button_brazil.setBackgroundResource(R.drawable.brazil_on);
                //play the sound
                sound_brazil.start(); // no need to call prepare(); create() does that for you
                selecting = 5;
                System.out.println("Brazil: " + selecting);
                //Updating Score
                scoring();
                //going back to original background
                mHandler.postDelayed(stop, 1000);
            }
        });
    }

    //END PLAYER MOVES DEFINITION

    //OTHERS DEFINITIONS

    private Runnable stop;
    {
        stop = new Runnable() {
            @Override
            public void run() {
                switch (option) {
                    case 0:
                        if (sound_japan.isPlaying()) {
                            sound_japan.pause();
                        }
                        button_japan.setBackgroundResource(R.drawable.japan_off);
                        break;
                    case 1:
                        if (sound_poland.isPlaying()) {
                            sound_poland.pause();
                        }
                        button_poland.setBackgroundResource(R.drawable.poland_off);
                        break;
                    case 2:
                        if (sound_germany.isPlaying()) {
                            sound_germany.pause();
                        }
                        button_germany.setBackgroundResource(R.drawable.germany_off);
                        break;
                    case 3:
                        if (sound_italy.isPlaying()) {
                            sound_italy.pause();
                        }
                        button_italy.setBackgroundResource(R.drawable.italy_off);
                        break;
                    case 4:
                        if (sound_turkey.isPlaying()) {
                            sound_turkey.pause();
                        }
                        button_turkey.setBackgroundResource(R.drawable.turkey_off);
                        break;
                    case 5:
                        if (sound_brazil.isPlaying()) {
                            sound_brazil.pause();
                        }
                        button_brazil.setBackgroundResource(R.drawable.brazil_off);
                        break;
                }
            }
        };
    }

    private Runnable Runnable;
    {
        Runnable = new Runnable() {
            @Override
            public void run() {
                switch (option) {
                    case 0:
                        button_japan.setBackgroundResource(R.drawable.japan_off);
                        break;

                    case 1:
                        button_poland.setBackgroundResource(R.drawable.poland_off);
                        break;
                    case 2:
                        button_germany.setBackgroundResource(R.drawable.germany_off);
                        break;
                    case 3:
                        button_italy.setBackgroundResource(R.drawable.italy_off);
                        break;
                    case 4:
                        button_turkey.setBackgroundResource(R.drawable.turkey_off);
                        break;
                    case 5:
                        button_brazil.setBackgroundResource(R.drawable.brazil_off);
                        break;
                }
            }
        };
    }

    public void scoring(){
        if (selecting == option) {
            count++;
            //converting int to String
            score = Integer.toString(count);

            currentscore = findViewById(R.id.currentScore);
            currentscore.setText(score);
        }else{
            count=0;
            System.out.println("NO SON IGUALES");
            x = new Intent(getApplicationContext(),gameover.class);
            startActivity(x);

        }
    }



    //OTHERS DEFINITIONS
}



