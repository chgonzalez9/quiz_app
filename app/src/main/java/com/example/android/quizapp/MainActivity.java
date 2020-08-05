package com.example.android.quizapp;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    boolean answered = false;

    float result = 0;

    String Q5S = "1954";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void resultButton(View view) {

        EditText nameField = findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        if (!answered) {

            if (((RadioButton) findViewById(R.id.answer1_1)).isChecked()) {
                result++;
            }

            if (((RadioButton) findViewById(R.id.answer1_2)).isChecked()) {
                result--;
            }

            if (((RadioButton) findViewById(R.id.answer1_3)).isChecked()) {
                result--;
            }

            if (((CheckBox) findViewById(R.id.answer2_1)).isChecked()) {
                result = result + 0.5f;
            }

            if (((CheckBox) findViewById(R.id.answer2_2)).isChecked()) {
                result = result + 0.5f;
            }

            if (((CheckBox) findViewById(R.id.answer2_3)).isChecked()) {
                result = result - 0.5f;
            }

            if (((CheckBox) findViewById(R.id.answer2_4)).isChecked()) {
                result = result - 0.5f;
            }

            if (((CheckBox) findViewById(R.id.answer3_1)).isChecked()) {
                result = result - 0.5f;
            }

            if (((CheckBox) findViewById(R.id.answer3_2)).isChecked()) {
                result = result + 0.25f;
            }

            if (((CheckBox) findViewById(R.id.answer3_3)).isChecked()) {
                result = result + 0.25f;
            }

            if (((CheckBox) findViewById(R.id.answer3_4)).isChecked()) {
                result = result + 0.25f;
            }

            if (((CheckBox) findViewById(R.id.answer3_5)).isChecked()) {
                result = result + 0.25f;
            }

            EditText questionFour = (EditText) findViewById(R.id.answer4);
            String questionFourAnswer = questionFour.getText().toString();

            if (questionFourAnswer.equalsIgnoreCase(Q5S)) {
                result++;
            }

            answered = true;

        }

        Context context = getApplicationContext();
        CharSequence text = totalMark(result, name);
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }

    public void resetButton(View view) {
        answered = false;
    }


    private String totalMark(float mark, String name) {

        if (mark <= 2) {
            return name + "\nYou fail the test.\nTry Again!";
        }

        if (mark < 4) {
            return name + "\nCongratulations!\nYou pass!";
        }

        if (mark == 4) {
            return name + "\nYou´re amazing!\nYou pass with a 10!";
        }
        return name;
    }

}