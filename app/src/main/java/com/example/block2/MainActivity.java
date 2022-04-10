package com.example.block2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listViewAnimal = findViewById(R.id.listAnimalView);
        ArrayAdapter<CharSequence> adapterAnimal = ArrayAdapter.createFromResource(this,
                R.array.listAnimal,
                android.R.layout.simple_list_item_1);
        listViewAnimal.setAdapter(adapterAnimal);

        listViewAnimal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String message = getString(R.string.pick) + " " + adapterAnimal.getItem(i);
                Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
            }
        });
    }
}