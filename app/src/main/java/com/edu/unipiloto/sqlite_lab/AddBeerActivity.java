package com.edu.unipiloto.sqlite_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AddBeerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_beer);

        BeerDatabaseHelper beerDatabaseHelper = new BeerDatabaseHelper(this);

        Button insertBtn = findViewById(R.id.insert_btn);
        EditText brandInput = findViewById(R.id.brand_input);
        EditText colorInput = findViewById(R.id.color_input);
        Spinner scoreSpinner = findViewById(R.id.score_spinner);
        EditText countryInput = findViewById(R.id.country_input);
        EditText priceInput = findViewById(R.id.price_input);

        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String brand = brandInput.getText().toString();
                String color = colorInput.getText().toString();
                int score = scoreSpinner.getSelectedItem().toString().length();
                String country = countryInput.getText().toString();
                int price = Integer.parseInt(priceInput.getText().toString());
                boolean result = beerDatabaseHelper.insertBeer(brand, color, score, country, price);
                if (result) {
                    Toast.makeText(AddBeerActivity.this, "Se inserto correctamente la cerveza", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(AddBeerActivity.this, "No se pudo insertar la cerveza", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}