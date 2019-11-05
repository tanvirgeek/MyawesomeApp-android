package com.tanvirgeek.myawesomeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickFindBeer(View view){
        TextView brand = (TextView) findViewById(R.id.text_brands);
        Spinner color = (Spinner) findViewById(R.id.color);
        //Get the selected Item on the spinner
        String beerType = String.valueOf(color.getSelectedItem());
        // Get recommendation from expert
        List<String> brandList = expert.getBrands(beerType);

        //Building a string of recommended beer in a new line
        StringBuilder brandsString = new StringBuilder();
        for(String b : brandList ){
            brandsString.append(b).append('\n');
        }
        //display the brands
        brand.setText(brandsString);

    }
    //btn_send_message click handler
    public void onSendMessage(View view){
        Intent intent = new Intent(this, recieve.class);

    }
}
