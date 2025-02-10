package com.example.sqliteproject;

import static org.jetbrains.annotations.Nls.Capitalization.Title;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText id, name, marks;
    Button insert, view, edit, delete;
    DatabaseHelper mdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        id = findViewById(R.id.txt_id);
        name = findViewById(R.id.txt_name);
        marks = findViewById(R.id.txt_marks);
        insert = findViewById(R.id.btn_insert);
        view = findViewById(R.id.btn_view);
        edit = findViewById(R.id.btn_Edit);
        delete = findViewById(R.id.btn_delete);

        mdb = new DatabaseHelper(this);

//        insert data
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean insertedData = mdb.insertData(
                        id.getText().toString().trim(),
                        name.getText().toString().trim(),
                        marks.getText().toString().trim());
                if (insertedData == true) {
                    Toast.makeText(MainActivity.this, "Data is inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Something Error!", Toast.LENGTH_SHORT).show();
                }
            }
        });
//View All Data
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cur = mdb.getAllData();
                if (cur.getCount() == 0) {
                    Toast.makeText(MainActivity.this, "Data is Empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (cur.moveToNext()) {
                    buffer.append("ID: " + cur.getString(0) + "\n");
                    buffer.append("Name: " + cur.getString(1) + "\n");
                    buffer.append("Marks: " + cur.getString(2) + "\n");
                }
                show("data", buffer.toString());
                ")
            }
        });
//        Edit Data
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean updateData = mdb.updateData(
                        id.getText().toString().trim(),
                        name.getText().toString().trim(),
                        marks.getText().toString().trim());
                if (updateData == true) {
                    Toast.makeText(MainActivity.this, "Data is Updated", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Something Error!", Toast.LENGTH_SHORT).show();
                }
            }
        });
//        Delete Data
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deleted = mdb.deleteData(id.getText().toString().trim());
                if (deleted > 0) {
                    Toast.makeText(MainActivity.this, "Data is Deleted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Something Error!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void show(String Title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(Title);
        builder.setMessage(Message);
    }
}