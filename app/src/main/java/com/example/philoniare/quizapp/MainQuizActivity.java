package com.example.philoniare.quizapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainQuizActivity extends AppCompatActivity {
    RadioGroup yearFounded, firstCourses;
    EditText founderName, nanodegreeYear;
    CheckBox drivingCars, marsColonization, googleGlass, deepMind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_quiz);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        yearFounded = (RadioGroup) findViewById(R.id.question_one);
        founderName = (EditText) findViewById(R.id.question_two);
        drivingCars = (CheckBox) findViewById(R.id.question_three_one);
        marsColonization = (CheckBox) findViewById(R.id.question_three_two);
        googleGlass = (CheckBox) findViewById(R.id.question_three_three);
        deepMind = (CheckBox) findViewById(R.id.question_three_four);
        firstCourses = (RadioGroup) findViewById(R.id.question_four);
        nanodegreeYear = (EditText) findViewById(R.id.question_five);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "You got " + Integer.toString(calculateQuizScore()) + " out of 5 correct!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private int calculateQuizScore() {
        int score = 0;

        // Check first question
        int yearFoundedSelectedId = yearFounded.getCheckedRadioButtonId();
        if (yearFoundedSelectedId == R.id.question_one_correct_answer) {
            score += 1;
        }

        // Check second question
        String founderNameStr = founderName.getText().toString();
        if (founderNameStr.equals(getString(R.string.founder_name))) {
            score += 1;
        }

        // Check third question
        if (drivingCars.isChecked() && !marsColonization.isChecked() &&
                googleGlass.isChecked() && !deepMind.isChecked()) {
            score += 1;
        }

        // Check fourth question
        int firstCoursesSelectedId = firstCourses.getCheckedRadioButtonId();
        if (firstCoursesSelectedId == R.id.question_four_correct_answer) {
            score += 1;
        }

        // Check fifth question
        String nanodegreeYearStr = nanodegreeYear.getText().toString();
        if (nanodegreeYearStr.equals(getString(R.string.nanodegree_year))) {
            score += 1;
        }


        return score;
    }
}
