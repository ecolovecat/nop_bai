package com.example.block7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity {

    NumberPicker possibilities;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        possibilities = findViewById(R.id.numberPicker);
        webView = (WebView) findViewById(R.id.webView);
        String[] possibilitiesStrings = {
                "Dantri",
                "W3school",
                "Coursera",
                "Youtube"
        };
        possibilities.setDisplayedValues(possibilitiesStrings);
        possibilities.setMinValue(0);
        possibilities.setMaxValue(possibilitiesStrings.length-1);
    }

    public void navigate(View view) {
        int choice = possibilities.getValue();
        if (choice == 0)
        webView.loadUrl("file:///android_asset/dantri.html");

        else if (choice == 1)
            webView.loadUrl("file:///android_asset/w3school.html");
        else if (choice == 3)
            webView.loadUrl("http://www.coursera.org");
        else if (choice == 0)
            webView.loadUrl("file:///android_asset/youtube.html");
    }
}