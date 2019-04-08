package com.example.homework;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SoundActivity extends AppCompatActivity {
     String sound1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound);

        set();
    }

    public void set(){
        final Button cancel = (Button) findViewById(R.id.cancelButton);
        final Button ok = (Button) findViewById(R.id.okButton);
        RadioGroup radiogroup = (RadioGroup) findViewById(R.id.radioGroup);
        final RadioButton radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        final RadioButton radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        final RadioButton radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        final RadioButton radioButton4 = (RadioButton) findViewById(R.id.radioButton4);
        final RadioButton radioButton5 = (RadioButton) findViewById(R.id.radioButton5);


        View.OnClickListener myClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.cancelButton:
                        onBackPressed();
                        break;
                    case R.id.radioButton1:
                        sound1=getString(R.string.sound_1);
                        break;
                    case R.id.radioButton2:
                        sound1=getString(R.string.sound_2);
                        break;
                    case R.id.radioButton3:
                        sound1=getString(R.string.sound_3);
                        break;
                    case R.id.radioButton4:
                        sound1=getString(R.string.sound_4);
                        break;
                    case R.id.radioButton5:
                        sound1=getString(R.string.sound_5);
                        break;
                    case R.id.okButton:
                        Intent resultData = new Intent();
                        resultData.putExtra("sound", sound1);
                        setResult(Activity.RESULT_OK, resultData);
                        finish();
                        break;
                }
            }
        };

        cancel.setOnClickListener(myClickListener);
        ok.setOnClickListener(myClickListener);
        radioButton1.setOnClickListener(myClickListener);
        radioButton2.setOnClickListener(myClickListener);
        radioButton3.setOnClickListener(myClickListener);
        radioButton4.setOnClickListener(myClickListener);
        radioButton5.setOnClickListener(myClickListener);
    }
}



