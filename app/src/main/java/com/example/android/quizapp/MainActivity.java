package com.example.android.quizapp;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void resultButton(View view) {

        int points = 0;

        boolean answer1 = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.answer1_1:
                if (answer1)
                    points += 1;
                break;
            case R.id.answer1_2:
                if (answer1)
                    break;
            case R.id.answer1_3:
                if (answer1)
                    break;
        }

        CheckBox answerCheckBox2_1 = (CheckBox) findViewById(R.id.answer2_1);
        boolean answer2_1 = answerCheckBox2_1.isChecked();
        if (answer2_1) {
            points += 1;
        }
        CheckBox answerCheckBox2_2 = (CheckBox) findViewById(R.id.answer2_2);
        boolean answer2_2 = answerCheckBox2_2.isChecked();
        if (answer2_2) {
            points += 1;
        }
        CheckBox answerCheckBox2_3 = (CheckBox) findViewById(R.id.answer2_3);
        answerCheckBox2_3.isChecked();
        CheckBox answerCheckBox2_4 = (CheckBox) findViewById(R.id.answer2_4);
        answerCheckBox2_4.isChecked();

        CheckBox answerCheckBox3_1 = (CheckBox) findViewById(R.id.answer3_1);
        answerCheckBox3_1.isChecked();
        CheckBox answerCheckBox3_2 = (CheckBox) findViewById(R.id.answer3_2);
        boolean answer3_2 = answerCheckBox3_2.isChecked();
        if (answer3_2) {
            points += 1;
        }
        CheckBox answerCheckBox3_3 = (CheckBox) findViewById(R.id.answer3_3);
        boolean answer3_3 = answerCheckBox3_3.isChecked();
        if (answer3_3) {
            points += 1;
        }
        CheckBox answerCheckBox3_4 = (CheckBox) findViewById(R.id.answer3_4);
        boolean answer3_4 = answerCheckBox3_4.isChecked();
        if (answer3_4) {
            points += 1;
        }
        CheckBox answerCheckBox3_5 = (CheckBox) findViewById(R.id.answer3_5);
        boolean answer3_5 = answerCheckBox3_5.isChecked();
        if (answer3_5) {
            points += 1;
        }

        displayMark(points);

    }

    private void displayMark(int total) {
        TextView scoreTextView = (TextView) findViewById(R.id.score);
        scoreTextView.setText("" + total);
    }

}