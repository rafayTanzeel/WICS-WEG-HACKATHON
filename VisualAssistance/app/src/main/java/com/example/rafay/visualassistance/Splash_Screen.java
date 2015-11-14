package com.example.rafay.visualassistance;


import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Locale;

public class Splash_Screen extends AppCompatActivity {
    public TextToSpeech ttsobj;
    private int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);

        ttsobj=new TextToSpeech(getBaseContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS){
                    result=ttsobj.setLanguage(Locale.UK);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Feature Not Supported", Toast.LENGTH_SHORT).show();
                }
            }
        }
        );

        final ImageView iv=(ImageView)findViewById(R.id.logoPic);
        final Animation an= AnimationUtils.loadAnimation(getBaseContext(),R.anim.logo_rotates);
        final Animation an2= AnimationUtils.loadAnimation(getBaseContext(),R.anim.logo_fade);

        iv.startAnimation(an);

        an.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                if (result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA) {
                    Toast.makeText(getApplicationContext(), "Feature Not Supported", Toast.LENGTH_SHORT).show();

                } else {
                    ttsobj.stop();
                    ttsobj.speak("Welcome to Visual Assistance, click the button in the center to state location", TextToSpeech.QUEUE_FLUSH, null);
                    iv.startAnimation(an);
                }
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                iv.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA) {
                                    Toast.makeText(getApplicationContext(), "Feature Not Supported", Toast.LENGTH_SHORT).show();

                                } else {
                                    ttsobj.stop();
                                    ttsobj.speak("Welcome to Visual Assistance, click the button in the center to state location", TextToSpeech.QUEUE_FLUSH, null);
                                    iv.startAnimation(an);
                                }
                            }
                        }
                );

                iv.setOnLongClickListener(
                        new View.OnLongClickListener() {
                            @Override
                            public boolean onLongClick(View v) {
                                iv.startAnimation(an2);
                                finish();
                                Intent i = new Intent(getBaseContext(), MainActivity.class);
                                startActivity(i);
                                return false;
                            }
                        }
                );
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

    }
}
