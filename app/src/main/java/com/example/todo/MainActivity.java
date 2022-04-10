package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickVisible(View view) {
        view.setVisibility(View.INVISIBLE);
    }

    public void onClickTodo(View view) {
        Toast.makeText(getApplicationContext(),"Todo come up", Toast.LENGTH_SHORT).show();
    }
}