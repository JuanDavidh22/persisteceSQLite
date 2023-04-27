package com.edu.unipiloto.sqlite_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class TableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        BeerDatabaseHelper beerDatabaseHelper = new BeerDatabaseHelper(this);

        Bundle datos = getIntent().getExtras();

        String spinner = datos.getString("spinner");
        String dateFind = datos.getString("date");
        TableLayout tableLayout = (TableLayout) findViewById(R.id.tableBeer);

        int id = 1;
        String brand = "budweiser";
        String color = "rubia";
        int price = 4000;
        String country = "USA";
        String score = "xxxxx";
        ArrayList<ArrayList<String>> dateTable = new ArrayList<>();
        ArrayList<String> resultdb = new ArrayList();

        resultdb.add(String.valueOf(id));
        resultdb.add(brand);
        resultdb.add(color);
        resultdb.add(String.valueOf(price));
        resultdb.add(country);
        resultdb.add(score);

        dateTable.add(resultdb);
        tableLayout.removeAllViews();

        for (int i = 0; i < dateTable.size(); i++) {

            View registro = LayoutInflater.from(this).inflate(R.layout.tablerow, null, false);
            TextView id_table = registro.findViewById(R.id.id_table);
            TextView color_table = registro.findViewById(R.id.color_table);
            TextView brand_table = registro.findViewById(R.id.brand_table);
            TextView score_table = registro.findViewById(R.id.score_table);
            TextView country_table = registro.findViewById(R.id.country_table);
            TextView price_table = registro.findViewById(R.id.price_table);

            id_table.setText(dateTable.get(i).get(0).toString());
            color_table.setText(dateTable.get(i).get(1).toString());
            brand_table.setText(dateTable.get(i).get(2).toString());
            score_table.setText(dateTable.get(i).get(3).toString());
            country_table.setText(dateTable.get(i).get(4).toString());
            price_table.setText(dateTable.get(i).get(5).toString());

            System.out.println(id_table.getText().toString());
            System.out.println(color_table.getText().toString());
            System.out.println(brand_table.getText().toString());
            System.out.println(score_table.getText().toString());
            System.out.println(country_table.getText().toString());
            System.out.println(price_table.getText().toString());
            tableLayout.addView(registro);

        }

        Cursor result = null;
        /*if (spinner.equals("ID")) {
            result = beerDatabaseHelper.findBeerById(Integer.parseInt(dateFind));
        } else {
            result = beerDatabaseHelper.findBeerByColor(dateFind);
        }
        System.out.println(result.toString());
*/

        /*
        System.out.println(result.toString());
                result.moveToFirst();


                ArrayList<ArrayList<String>> dateTable = new ArrayList<>();
                do {
                    ArrayList<String> resultdb = new ArrayList();
                    resultdb.add(String.valueOf(result.getInt(0)));
                    resultdb.add(result.getString(1));
                    resultdb.add(result.getString(2));
                    resultdb.add(result.getString(3));
                    resultdb.add(result.getString(4));
                    resultdb.add(result.getString(5));

                    dateTable.add(resultdb);
                } while (result.moveToNext());
                tableLayout.addView(view);
        */
    }
}