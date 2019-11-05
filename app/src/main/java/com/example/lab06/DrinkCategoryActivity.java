package com.example.lab06;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.lab06.Adapter.Drink;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DrinkCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_category);

      Toolbar toolbar2 = (Toolbar)findViewById(R.id.Drink_Toolbar);
      setSupportActionBar(toolbar2);

      ActionBar actionBar = getSupportActionBar();
      actionBar.setDisplayHomeAsUpEnabled(true);


        ArrayAdapter <Drink> listAdapter = new ArrayAdapter<>(

                this,
                android.R.layout.simple_list_item_1,
                Drink.drinks);

        ListView listDrinks = (ListView) findViewById(R.id.options);
        listDrinks.setAdapter(listAdapter);


        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(DrinkCategoryActivity.this, DrinkActivity.class);
                intent.putExtra(DrinkActivity.EXTRA_DRINK,(int) l);
                startActivity(intent);

            }
        };

        listDrinks.setOnItemClickListener(itemClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_create_order:
                Intent intent = new Intent(this,ActivitySMS.class);
                startActivity(intent);
                return true;


            default: return super.onOptionsItemSelected(item);
        }

    }


}
