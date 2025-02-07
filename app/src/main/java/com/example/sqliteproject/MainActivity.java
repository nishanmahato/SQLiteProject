package com.example.sqliteproject;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText id,name,marks;
    Button insert, view, edit,delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        id=findViewById(R.id.txt_id);
        name=findViewById(R.id.txt_name);
        marks=findViewById(R.id.txt_marks);
        insert=findViewById(R.id.btn_insert);
        view=findViewById(R.id.btn_view);
        edit=findViewById(R.id.btn_Edit);
        delete=findViewById(R.id.btn_delete);

    }
}