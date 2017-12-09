package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreA = 0;
    int scoreB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addScore(View view){
        switch (view.getId()){
            case R.id.a_plus_3 : scoreA+=3;
                displayScoreA(scoreA);
                break;
            case R.id.a_plus_2 : scoreA+=2;
                displayScoreA(scoreA);
                break;
            case R.id.a_free : scoreA+=0;
                displayScoreA(scoreA);
                break;
            case R.id.b_plus_3 : scoreB+=3;
                displayScoreB(scoreB);
                break;
            case R.id.b_plus_2 : scoreB+=2;
                displayScoreB(scoreB);
                break;
            case R.id.b_free : scoreB+=0;
                displayScoreB(scoreB);
                break;
            case R.id.reset : scoreB = scoreA = 0;
                displayScoreA(scoreA);
                displayScoreB(scoreB);
                break;
        }
    }

    public void displayScoreA(int a){
        TextView score_aTV = (TextView) findViewById(R.id.score_a_textView);
        score_aTV.setText(""+a);
    }

    public void displayScoreB(int b){
        TextView score_bTV = (TextView) findViewById(R.id.score_b_textView);
        score_bTV.setText(""+b);
    }
}
