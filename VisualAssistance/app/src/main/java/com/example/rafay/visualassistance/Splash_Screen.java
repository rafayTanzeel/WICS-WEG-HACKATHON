package com.example.rafay.visualassistance;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);

        final ImageView iv=(ImageView)findViewById(R.id.logoPic);
        final Animation an= AnimationUtils.loadAnimation(getBaseContext(),R.anim.logo_rotates);
        final Animation an2= AnimationUtils.loadAnimation(getBaseContext(),R.anim.logo_fade);

        iv.startAnimation(an);

        an.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                iv.startAnimation(an2);
                finish();
                Intent i=new Intent(getBaseContext() , MainActivity.class);
                startActivity(i);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        Intent i=new Intent(this, MainActivity.class);
    }
}
