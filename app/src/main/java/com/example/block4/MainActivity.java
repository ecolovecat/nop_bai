package com.example.block4;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    MediaPlayer music;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        music = MediaPlayer.create(this, R.raw.music2);
        Switch switch_loop = findViewById(R.id.switch_loop);
        switch_loop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                music.setLooping(b);
            }
        });
    }

    public void playMusic(View view) {
        music.start();
    }

    public void pauseMusic(View view) {
        if(music.isPlaying()) {
            music.pause();
        }
    }
}