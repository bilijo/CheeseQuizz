package com.example.android.cheesequiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.android.cheesequiz.R.id.radioGroupQuestion1;
import static com.example.android.cheesequiz.R.id.radioGroupQuestion2;


public class MainActivity extends AppCompatActivity {


    // define an global arraylist to store answers from questions fields
    private final ArrayList<String> arrayListStoreAnswers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //***************************  Question 1  *************************************
        //define an instance of radiogroup and check button linked to question 1
        Button btn1 = (Button) findViewById(R.id.button_check_Q1);
        final RadioGroup rg1 = (RadioGroup) findViewById(radioGroupQuestion1);

        // add clicklistener to the button which is devoted to check the selected answer for question1
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the checked Radio Button ID from Radio Group
                int selectedRadioButtonID = rg1.getCheckedRadioButtonId();

                // If nothing is selected from Radio Group, then it return -1
                if (selectedRadioButtonID != -1) {

                    RadioButton selectedRadioButton = (RadioButton) findViewById(selectedRadioButtonID);
                    String selectedRadioButtonText = selectedRadioButton.getText().toString();

                    // add the selected answer in the arraylist
                    arrayListStoreAnswers.add(selectedRadioButtonText);

                    String data = arrayListStoreAnswers.get(0);
                    Log.v("MainActivity", "checkQuestionOne: " + data);

                } else {
                    //Toast.setGravity(Gravity.TOP|Gravity.START, 0, 0);
                    Toast.makeText(MainActivity.this, "Nothing selected from Radio Group.",
                            Toast.LENGTH_LONG).show();
                }

            }
        });
        //******************************************************

        //***************************  Question 2  *************************************
        //define an instance of radiogroup and check button linked to question 2
        Button btn2 = (Button) findViewById(R.id.button_check_Q2);
        final RadioGroup rg2 = (RadioGroup) findViewById(radioGroupQuestion2);

        // add clicklistener to the button which is devoted to check the selected answer for question1
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the checked Radio Button ID from Radio Group
                int selectedRadioButtonID = rg2.getCheckedRadioButtonId();

                // If nothing is selected from Radio Group, then it return -1
                if (selectedRadioButtonID != -1) {

                    RadioButton selectedRadioButton = (RadioButton) findViewById(selectedRadioButtonID);
                    String selectedRadioButtonText = selectedRadioButton.getText().toString();

                    // add the selected answer in the arraylist
                    arrayListStoreAnswers.add(selectedRadioButtonText);

                    String data = arrayListStoreAnswers.get(1);
                    Log.v("MainActivity", "checkQuestionOne: " + data);

                } else {
                    //Toast.setGravity(Gravity.TOP|Gravity.START, 0, 0);
                    Toast.makeText(MainActivity.this, "Nothing selected from Radio Group.",
                            Toast.LENGTH_LONG).show();
                }

            }
        });
        //******************************************************


        // button which will send responses to the ResultOfQuizz class
        Button btn_result = (Button) findViewById(R.id.button_final_result);
        // add clicklistener to the button about results
        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // send an intent to ResultOfQuizz class which will give results
                Intent resultIntent = new Intent(MainActivity.this, ResultOfQuizz.class);
                resultIntent.putStringArrayListExtra("IntentArraylist", arrayListStoreAnswers);
                resultIntent.putExtra("IntentArraylist", arrayListStoreAnswers);

                // launch ResultOfQuizz activity once button_final_result has been clicked
                startActivity(resultIntent);
            }
        });

    }
}




