package com.example.easytutonotes;

import androidx.appcompat.app.AppCompatActivity;
import io.realm.Realm;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class AddNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        EditText titleInput = findViewById(R.id.titleInput);
        EditText descriptionInput = findViewById(R.id.descriptionInput);
        MaterialButton saveBtn = findViewById(R.id.saveBtn);


        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleInput.getText().toString();
                String description = descriptionInput.getText().toString();
                if (title.isEmpty() || description.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Vui lòng điền đầy đủ thông tin",Toast.LENGTH_SHORT).show();
                } else {
                    long createdTime = System.currentTimeMillis();

                    realm.beginTransaction();
                    Note note = realm.createObject(Note.class);
                    note.setTitle(title);
                    note.setDescription(description);
                    note.setCreatedTime(createdTime);
                    realm.commitTransaction();
                    Toast.makeText(getApplicationContext(),"Đã lưu",Toast.LENGTH_SHORT).show();
                    finish();
                }




            }
        });


    }
}