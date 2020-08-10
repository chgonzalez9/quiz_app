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

    RadioButton answer1_1, answer1_2, answer1_3;

    CheckBox answer2_1, answer2_2, answer2_3, answer2_4, answer3_1, answer3_2, answer3_3, answer3_4, answer3_5;

    boolean answered = false;

    float result = 0;

    String Q4S = "1954";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answer1_1 = findViewById(R.id.answer1_1);
        answer1_2 = findViewById(R.id.answer1_2);
        answer1_3 = findViewById(R.id.answer1_3);
        answer2_1 = findViewById(R.id.answer2_1);
        answer2_2 = findViewById(R.id.answer2_2);
        answer2_3 = findViewById(R.id.answer2_3);
        answer2_4 = findViewById(R.id.answer2_4);
        answer3_1 = findViewById(R.id.answer3_1);
        answer3_2 = findViewById(R.id.answer3_2);
        answer3_3 = findViewById(R.id.answer3_3);
        answer3_4 = findViewById(R.id.answer3_4);
        answer3_5 = findViewById(R.id.answer3_5);
    }

    public void radioButtonAnswer(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        String str = "";

        switch (view.getId()) {
            case R.id.answer1_1:
                if (checked)
                    str = "Answer A Selected";
                break;
            case R.id.answer1_2:
                if (checked)
                    str = "Answer B Selected";
                break;
            case R.id.answer1_3:
                if (checked)
                    str = "Answer C Selected";
                break;
        }
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }

    public void checkBoxAnswer(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        String str = "";
        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.answer2_1:
                str = checked ? "Thermodynamics Selected" : "Thermodynamics Deselected";
                break;
            case R.id.answer2_2:
                str = checked ? "Quantum mechanics Selected" : "Quantum mechanics Deselected";
                break;
            case R.id.answer2_3:
                str = checked ? "Scientology Selected" : "Scientology Deselected";
                break;
            case R.id.answer2_4:
                str = checked ? "Astronomy Selected" : "Astronomy Deselected";
                break;
            case R.id.answer3_1:
                str = checked ? "China Selected" : "China Deselected";
                break;
            case R.id.answer3_2:
                str = checked ? "Spain Selected" : "Spain Deselected";
                break;
            case R.id.answer3_3:
                str = checked ? "Italy Selected" : "Italy Deselected";
                break;
            case R.id.answer3_4:
                str = checked ? "Belgium Selected" : "Belgium Deselected";
                break;
            case R.id.answer3_5:
                str = checked ? "Germany Selected" : "Germany Deselected";
                break;
        }
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }

    public void resultButton(View view) {

        EditText nameField = findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        String answerResult = "Quiz Answers \nName: " + name;

        if (!answered) {

            if (answer1_1.isChecked()) {
                result++;
                answerResult += "\nAnswer 1-A is Correct";
            }

            if (answer1_2.isChecked()) {
                result--;
                answerResult += "\nAnswer 1-B is Incorrect";
            }

            if (answer1_3.isChecked()) {
                result--;
                answerResult += "\nAnswer 1-C is Incorrect";
            }

            if (answer2_1.isChecked() && answer2_2.isChecked() && !answer2_3.isChecked() && !answer2_4.isChecked()) {
                result++;
                answerResult += "\nAnswer 2 is Correct";
            } else {
                answerResult += "\nAnswer 2 is Incorrect";
            }

            if (!answer3_1.isChecked() && answer3_2.isChecked() && answer3_3.isChecked() && answer3_4.isChecked() && answer3_5.isChecked()) {
                result++;
                answerResult += "\nAnswer 3 is Correct";
            } else {
                answerResult += "\nAnswer 3 is Incorrect";
            }

            EditText questionFour = findViewById(R.id.answer4);
            String questionFourAnswer = questionFour.getText().toString();
            if (questionFourAnswer.equalsIgnoreCase(Q4S)) {
                result++;
                answerResult += "\nAnswer 4 is Correct";
            } else {
                answerResult += "\nAnswer 4 is Incorrect";
            }

            answered = true;

        }

        Context context = getApplicationContext();
        CharSequence text = totalMark(result, answerResult);
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }

    public void resetButton(View view) {
        answered = false;
        result = 0;
    }

    private String totalMark(float mark, String answer) {

        if (mark <= 2) {
            return answer + "\nTotal mark = " + mark + "\nYou fail the test.\nTry Again!";
        }

        if (mark < 4) {
            return answer + "\nTotal mark = " + mark + "\nCongratulations!\nYou pass!";
        }

        if (mark == 4) {
            return answer + "\nTotal mark = " + mark + "\nYou´re amazing!\nYou pass with a 10!";
        }
        return answer;
    }

}