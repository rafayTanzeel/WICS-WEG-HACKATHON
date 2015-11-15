package com.example.rafay.visualassistance;


import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class Splash_Screen extends AppCompatActivity {

    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);

        mp = MediaPlayer.create(Splash_Screen.this, R.raw.speech);
        final ImageView iv=(ImageView)findViewById(R.id.logoPic);
        final Animation an= AnimationUtils.loadAnimation(getBaseContext(),R.anim.logo_rotates);
        final Animation an2= AnimationUtils.loadAnimation(getBaseContext(),R.anim.logo_fade);

        iv.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        iv.startAnimation(an);
                    }
                }
        );

        iv.setOnLongClickListener(
                new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        iv.startAnimation(an2);
                        finish();
                        Intent i = new Intent(getBaseContext(), SecondMainActivity.class);
                        startActivity(i);
                        return false;
                    }
                }
        );


        an.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                mp.start();
                iv.startAnimation(an);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

        iv.startAnimation(an);

    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.release();
    }

}
