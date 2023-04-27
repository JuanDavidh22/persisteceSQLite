package com.edu.unipiloto.sqlite_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BeerDatabaseHelper beerDatabaseHelper = new BeerDatabaseHelper(this);
        try {
//            SQLiteDatabase db = beerDatabaseHelper.getReadableDatabase();
        } catch (SQLException e) {
            Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, "Database available", Toast.LENGTH_SHORT).show();

        Button add_btn = findViewById(R.id.add);
        Intent addIntent = new Intent(this, AddBeerActivity.class);
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(addIntent);
            }
        });

        Button find_btn = findViewById(R.id.select);
        Intent findIntent = new Intent(this, FindBeerTestActivity.class);

        find_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(findIntent);
            }
        });
    }
}