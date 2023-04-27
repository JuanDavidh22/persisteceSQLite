package com.edu.unipiloto.sqlite_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class FindBeerTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer_test);
        Button find = findViewById(R.id.findbeer_button);

        EditText textFind = findViewById(R.id.findBeer_editText);
        Spinner findBy = findViewById(R.id.spinner_option);
        Intent tableIntent = new Intent(this, TableActivity.class);



        find.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                tableIntent.putExtra("spinner", findBy.getSelectedItem().toString());
                tableIntent.putExtra("data", textFind.getText().toString());
                startActivity(tableIntent);


            }
        });
    }
}