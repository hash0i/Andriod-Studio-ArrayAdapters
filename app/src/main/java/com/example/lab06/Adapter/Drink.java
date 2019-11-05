package com.example.lab06.Adapter;

import com.example.lab06.R;

public class Drink {
private String name, description;
private int imgResourceId;

public static final Drink[] drinks={
        new Drink("Latte","A Couple of espresso shots with steamed milk", R.drawable.latte),
        new Drink("Espresso","A shot of steamed coffee",R.drawable.espresso),
        new Drink ("Cappuccino","Espresso , steamed milk Foam, and hot milk",R.drawable.cappuccino)
};

public Drink(String name, String description, int imgResourceId)
{
    this.description=description;
    this.name=name;
    this.imgResourceId=imgResourceId;
}
public String getName(){ return name; }
public String getDescription(){ return description; }
public int getImgResourceId(){ return imgResourceId; }

public void setName(String name) { this.name=name; }
public void setDescription(String description){ this.description=description; }
public String toString(){
        return this.name;
    }

}
