package com.example.homework;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    MediaPlayer ActualSound;
    String sound="sound_id";
    int x=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sound="a";
        Sound(sound);

        final ImageView img=(ImageView) findViewById(R.id.contact) ;
        img.setImageResource(R.drawable.weronika);

        final TextView name = (TextView) findViewById(R.id.nameText);
        name.setText("Weronika");


        final FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (x==0) {
                    Snackbar.make(view, "Odtwarznie", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Sound(sound);
                    ActualSound.start();
                    fab.setImageResource(android.R.drawable.ic_media_pause);
                    x=1;
                }
                else {
                    Snackbar.make(view, "Pausa", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    ActualSound.stop();
                    fab.setImageResource(android.R.drawable.ic_media_play);
                    x=0;
                }
            }
        });
        set();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void set(){
        final Button Sound =(Button) findViewById(R.id.soundButton);
        final Button Contact=(Button) findViewById(R.id.contactButton);
        final FloatingActionButton fab=findViewById(R.id.fab);

        View.OnClickListener myClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.soundButton:
                        ActualSound.stop();
                        fab.setImageResource(android.R.drawable.ic_media_play);
                        x = 0;
                        startActivityForResult(new Intent(MainActivity.this, SoundActivity.class), 1);
                        break;
                    case R.id.contactButton:
                        ActualSound.stop();
                        fab.setImageResource(android.R.drawable.ic_media_play);
                        x = 0;
                        startActivityForResult(new Intent(MainActivity.this, ContactActivity.class), 2);
                        break;
                }
            }
        };
        Sound.setOnClickListener(myClickListener);
        Contact.setOnClickListener(myClickListener);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                sound = data.getStringExtra("sound");
                Sound(sound);
            }
        }
        if (requestCode==2) {
            if (resultCode == RESULT_OK) {
                String ContactName = data.getStringExtra("ContactName");
                TextView name = (TextView) findViewById(R.id.nameText);
                name.setText(ContactName);
                final int random = new Random().nextInt(3);
                Pic(random);
            }

        }
    }

    void Sound(String sound){
        switch(sound){
            case "a":
                ActualSound = MediaPlayer.create(this, R.raw.a);
                break;
            case "b":
                ActualSound = MediaPlayer.create(this, R.raw.b);
                break;
            case "c":
                ActualSound = MediaPlayer.create(this, R.raw.c);
                break;
            case "d":
                ActualSound = MediaPlayer.create(this, R.raw.d);
                break;
            case "e":
                ActualSound = MediaPlayer.create(this, R.raw.e);
                break;
            default:
        }
    }

    void Pic(int number){
        final ImageView img = (ImageView) findViewById(R.id.contact);
        switch(number){
            case 0:
                img.setImageResource(R.drawable.monika);
                break;
            case 1:
                img.setImageResource(R.drawable.paulina);
                break;
            case 2:
                img.setImageResource(R.drawable.sandra);
                break;
            case 3:
                img.setImageResource(R.drawable.weronika);
                break;
        }
    }
}
