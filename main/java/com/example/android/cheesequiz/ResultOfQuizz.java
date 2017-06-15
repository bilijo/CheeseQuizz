package com.example.android.cheesequiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by dam on 15.06.2017.
 */

public class ResultOfQuizz extends AppCompatActivity {
    final ArrayList<String> arrayListTrueAnswers = new ArrayList<>(5);
    arrayListTrueAnswers.add("1200")
    //arrayListTrueAnswers.add("France");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        // get players quizz responses stored in an  Arraylist via intent from mainActivity
        Intent recupIntent = getIntent();
        ArrayList<String> vArrayList = recupIntent.getStringArrayListExtra("IntentArraylist");
        Log.d("ResultOfQuizz", "IntentArraylist" + vArrayList);

        //compare arraylist of responses -->vArrayList-->arrayListStoreAnswers
        // with arraylist of right responses -->arrayListTrueAnswers

// Loop arrayList2 items
        for (String response : vArrayList) {
            // Loop arrayList1 items
            boolean match = false;
            for (String solution : arrayListTrueAnswers) {
                if (Objects.equals(response, solution)) {
                    match = true;
                }
            }
            Log.d("ResultOfQuizz", "response" + match);
            if (!match) {

                Toast.makeText(ResultOfQuizz.this, "responses matches solutions.",
                        Toast.LENGTH_LONG).show();
            }
        }

    }
}
