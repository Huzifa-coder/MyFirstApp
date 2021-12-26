package com.example.suggestapp;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    int indexOfSuggest =0;
    Random iRandom;

    int[] arryaViewImege = {R.drawable.beach, R.drawable.bike, R.drawable.football, R.drawable.museum, R.drawable.park, R.drawable.restaurant,
            R.drawable.running, R.drawable.shop, R.drawable.swimming, R.drawable.walking};

    int[] nameOfPlaces = new int[]{R.string.beach, R.string.bike, R.string.football, R.string.museum, R.string.park, R.string.restaurant, R.string.running
                                    , R.string.shop, R.string.swimming, R.string.walking};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.suggust_imageView);
        textView = findViewById(R.id.textView);
        iRandom = new Random();
    }

    private void changPlace(){
        if(indexOfSuggest < arryaViewImege.length && indexOfSuggest >= 0) {
            Drawable drawable = ContextCompat.getDrawable(this, arryaViewImege[indexOfSuggest]);
            String s = getString(nameOfPlaces[indexOfSuggest]);
            imageView.setImageDrawable(drawable);
            textView.setText(s);
        }else if(indexOfSuggest >= 0){
            indexOfSuggest =0;
            Toast.makeText(this, "This is the End", Toast.LENGTH_SHORT).show();
            changPlace();
        }else {
            indexOfSuggest =arryaViewImege.length;
            changPlace();
        }
    }

    public void suggest(View view) {
        Log.i("error", "index Of Suggest = " + indexOfSuggest);
        indexOfSuggest = iRandom.nextInt(arryaViewImege.length);
        changPlace();
    }

    public void next(View view) {
        indexOfSuggest++;
        changPlace();
    }

    public void before(View view) {
        indexOfSuggest--;
        changPlace();
    }
}