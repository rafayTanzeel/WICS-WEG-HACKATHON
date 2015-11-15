package com.example.rafay.visualassistance;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(MainActivity.this, R.raw.welcome);
        mp.start();

        Button b=(Button) findViewById(R.id.movegy);
        b.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //mp.start();
                        Intent i = new Intent(MainActivity.this, SecondMainActivity.class);
                        startActivity(i);
                    }
                }
        );



    }

    protected void onPause() {
        super.onPause();
        mp.release();
    }

}
