package com.edu.unipiloto.sqlite_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BeerDatabaseHelper beerDatabaseHelper = new BeerDatabaseHelper(this);
        try {
            SQLiteDatabase db = beerDatabaseHelper.getReadableDatabase();
        }catch (SQLException e){
            Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, "Database available", Toast.LENGTH_SHORT).show();
    }
}