package com.example.android.cheesequiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by dam on 15.06.2017.
 */

public class ResultOfQuizz extends AppCompatActivity {
    final ArrayList<String> arrayListTrueAnswers = new ArrayList<>(5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        arrayListTrueAnswers.add("1200");
        arrayListTrueAnswers.add("France");
        arrayListTrueAnswers.add("Cow");
        arrayListTrueAnswers.add("Goat");
        arrayListTrueAnswers.add("Sheep");

        // get players quizz responses stored in an  Arraylist via intent from mainActivity
        Intent recupIntent = getIntent();
       int sentinelles = recupIntent.getIntExtra("Sentinelles",-1);
        int goodAnswers = recupIntent.getIntExtra("rightAnswers",-1);

        Log.d("ResultOfQuizz", "rightAnswers " + goodAnswers +" " + sentinelles);

// Loop arrayList2 items


                Toast.makeText(ResultOfQuizz.this, "responses matches solutions."+goodAnswers+ " "+sentinelles,
                        Toast.LENGTH_LONG).show();
        }
}
