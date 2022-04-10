package com.example.block5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences preferences = getSharedPreferences("COLOR_PREF", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = preferences.edit();


        RelativeLayout layout = findViewById(R.id.layout);
        if(preferences.contains("colorId")){
            layout.setBackgroundColor(preferences.getInt("colorId",0));
        }
        RadioGroup radioGroup_colors = findViewById(R.id.radioGroup_color);
        radioGroup_colors.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int colorCode = 0;
                switch (i) {
                    case R.id.radioButton_green:
                        colorCode = Color.GREEN;
                        break;
                    case R.id.radioButton_red:
                        colorCode = Color.RED;
                        break;
                    case R.id.radioButton_yellow:
                        colorCode = Color.YELLOW;
                        break;
                }
                layout.setBackgroundColor(colorCode);
                editor.putInt("colorId",colorCode);
                editor.commit();
            }
        });
    }
}