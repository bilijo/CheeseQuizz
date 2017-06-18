package com.example.android.cheesequiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static com.example.android.cheesequiz.R.id.checkbox3_1;
import static com.example.android.cheesequiz.R.id.checkbox3_2;
import static com.example.android.cheesequiz.R.id.checkbox3_3;
import static com.example.android.cheesequiz.R.id.checkbox3_4;
import static com.example.android.cheesequiz.R.id.editText4_1;
import static com.example.android.cheesequiz.R.id.radioGroupQuestion1;
import static com.example.android.cheesequiz.R.id.radioGroupQuestion2;


public class MainActivity extends AppCompatActivity {

    // tokens to store right or wrong responses
    private int rightAnswers = 0;
    private boolean noAnswers = false;

    // tokens to watch if responses were given
    private int sentinel_q1 = 0;
    private int sentinel_q2 = 0;
    private int sentinel_q3 = 0;
    private int sentinel_q4 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //************ Button to display toast  ************************
        // button which will send responses to the ResultOfQuizz class
        Button btn_result = (Button) findViewById(R.id.button_final_result);

        // add clicklistener to the button about results
        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //***************************  Question 1  *************************************
                //define an instance of radiogroup and check button linked to question 1

                final RadioGroup rg1 = (RadioGroup) findViewById(radioGroupQuestion1);

                // Get the checked Radio Button ID from Radio Group
                int selectedRadioButtonID = rg1.getCheckedRadioButtonId();

                // Check if some radioButton is selected then dedicated token
                if (selectedRadioButtonID != -1) {
                    sentinel_q1++;
                    RadioButton selectedRadioButton1 = (RadioButton) findViewById(selectedRadioButtonID);
                    String selectedRadioButtonText1 = selectedRadioButton1.getText().toString();

                    //Check if item selected is correct then increase token by 1
                    if (selectedRadioButtonText1.equals("1200")) {
                        rightAnswers++;
                        noAnswers = false;
                    }

                } else {
                    noAnswers = true;
                    // If nothing is selected from Radio Group, then it return Toast message
                    Toast.makeText(MainActivity.this, "Nothing selected from Radio Group 1.",
                            Toast.LENGTH_LONG).show();
                }

                //******************************************************

                //***************************  Question 2  *************************************
                //define an instance of radiogroup and check button linked to question 2

                final RadioGroup rg2 = (RadioGroup) findViewById(radioGroupQuestion2);

                // Get the checked Radio Button ID from Radio Group
                int selectedRadioButtonID2 = rg2.getCheckedRadioButtonId();

                // If nothing is selected from Radio Group, then it return a toast message
                if (selectedRadioButtonID2 != -1) {
                    sentinel_q2++;
                    RadioButton selectedRadioButton2 = (RadioButton) findViewById(selectedRadioButtonID2);
                    String selectedRadioButtonText2 = selectedRadioButton2.getText().toString();

                    //Check if item selected is correct then increase token by 1
                    if (selectedRadioButtonText2.equals("France")) {
                        rightAnswers++;
                        noAnswers = false;
                    }

                } else {
                    noAnswers = true;
                    //Toast.setGravity(Gravity.TOP|Gravity.START, 0, 0);
                    Toast.makeText(MainActivity.this, "Nothing selected from Radio Group 2.",
                            Toast.LENGTH_LONG).show();
                }

                //******************************************************

                //***************************  Question 3  *************************************

                final CheckBox checkBox1 = (CheckBox) findViewById(checkbox3_1);
                final CheckBox checkBox2 = (CheckBox) findViewById(checkbox3_2);
                final CheckBox checkBox3 = (CheckBox) findViewById(checkbox3_3);
                final CheckBox checkBox4 = (CheckBox) findViewById(checkbox3_4);

                // Check if at least one checkbox is selected
                sentinel_q3 = (!checkBox1.isChecked() && !checkBox3.isChecked() && !checkBox4.isChecked() && !checkBox2.isChecked()) ? 0 : 1;

                // Check right answer
                if ((checkBox1.isChecked() && checkBox3.isChecked() && checkBox4.isChecked()) && (!checkBox2.isChecked())) {
                    sentinel_q3++;
                    rightAnswers++;
                    noAnswers = false;
                }

                if (sentinel_q3 == 0) {
                    noAnswers = true;
                    //message if no checkboxes selected
                    Toast.makeText(MainActivity.this, "Nothing selected from checkboxes.",
                            Toast.LENGTH_LONG).show();
                }


                //******************************************************

                //***************************  Question 4  *************************************
                EditText mEditText = (EditText) findViewById(editText4_1);
                String yourCheese = mEditText.getText().toString();

                if (!mEditText.getText().toString().equals("")) {
                    sentinel_q4++;
                    noAnswers = false;

                } else {
                    noAnswers = true;
                    //message if no checkboxes selected
                    Toast.makeText(MainActivity.this, "Nothing entered in input text field.",
                            Toast.LENGTH_LONG).show();
                }


                //******************************************************

                //***** Check result and display them *********************
                int totalSentinelles = sentinel_q4 + sentinel_q3 + sentinel_q2 + sentinel_q1;
                /*
                // send an intent to ResultOfQuizz class which will give results
                Intent resultIntent = new Intent(MainActivity.this, ResultOfQuizz.class);
                resultIntent.putExtra("Sentinelles", totalSentinelles);
                resultIntent.putExtra("rightAnswers", rightAnswers);
                */


                // launch ResultOfQuizz activity once button_final_result has been clicked
                if (!noAnswers) {

                // startActivity(resultIntent);
                    Toast.makeText(MainActivity.this, "responses matches solutions." + rightAnswers + " by " + 3 + "\n" +
                                    "Your preferred cheese is: " + yourCheese,
                        Toast.LENGTH_LONG).show();

                // Reset follow-up tokens
                rightAnswers = 0;
                    noAnswers = false;
                sentinel_q1 = 0;
                sentinel_q2 = 0;
                sentinel_q3 = 0;
                sentinel_q4 = 0;
                }

            }
        });

        //************ Button to display toast  ************************

    }
}




