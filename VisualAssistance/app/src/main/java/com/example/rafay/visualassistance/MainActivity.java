package com.example.rafay.visualassistance;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextToSpeech ttsobj;
    private int result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ttsobj=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
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

        Button b=(Button) findViewById(R.id.voiceOutputer);
        b.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA) {

                            Toast.makeText(getApplicationContext(), "Feature Not Supported", Toast.LENGTH_SHORT).show();

                        } else {
                            ttsobj.speak("Welcome to Visual Assistance, click the button in the center to state location", TextToSpeech.QUEUE_FLUSH, null);

                        }
                    }
                }
        );




    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ttsobj.stop();
        ttsobj.shutdown();
    }

}
