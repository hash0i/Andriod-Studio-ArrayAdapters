package com.example.lab06;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.core.view.MenuItemCompat;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.lab06.Adapter.Drink;
public class DrinkActivity extends AppCompatActivity {

    public static final String EXTRA_DRINK = "drinkID";
    private ShareActionProvider shareActionProvider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        Toolbar toolbar = (Toolbar)findViewById(R.id.Description_Toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        int drinkid = (Integer)getIntent().getExtras().get(EXTRA_DRINK);
        Drink drink = Drink.drinks[drinkid];

        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        imageView.setImageResource(drink.getImgResourceId());
        imageView.setContentDescription(drink.getName());

        TextView name=(TextView) findViewById(R.id.tv_Name);
        name.setText(drink.getName());

        TextView description = (TextView)findViewById(R.id.tv_description);
        description.setText(drink.getDescription());

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);

        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        setShareActionIntent("Latte, Espresso, Cappuccino");

        return super.onCreateOptionsMenu(menu);
    }


    private void setShareActionIntent(String text){

        //        Intent intent = new Intent(Intent.ACTION_SEND);
//        intent.setType("text/plain");
//        intent.putExtra(Intent.EXTRA_TEXT,text);


        Uri uri = Uri.parse("smsto:1234");
        Intent intent = new Intent(Intent.ACTION_SENDTO,uri);
        intent.putExtra("sms_body",text);



        shareActionProvider.setShareIntent(intent);

    }
}
