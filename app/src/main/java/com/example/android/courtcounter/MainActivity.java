package com.example.android.courtcounter;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreA = 0;
    int scoreB = 0;
    private EditText editTeamA;
    private EditText editTeamB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is used to add score value depends on which button clicked
     */
    public void addScore(View view){

        switch (view.getId()){
            case R.id.a_plus_3 : scoreA+=3;
                displayScoreA(scoreA);
                break;
            case R.id.a_plus_2 : scoreA+=2;
                displayScoreA(scoreA);
                break;
            case R.id.a_free : scoreA+=1;
                displayScoreA(scoreA);
                break;
            case R.id.b_plus_3 : scoreB+=3;
                displayScoreB(scoreB);
                break;
            case R.id.b_plus_2 : scoreB+=2;
                displayScoreB(scoreB);
                break;
            case R.id.b_free : scoreB+=1;
                displayScoreB(scoreB);
                break;
            case R.id.reset : scoreB = scoreA = 0;
                displayScoreA(scoreA);
                displayScoreB(scoreB);
                break;
        }
    }

    /**
     * This method used to display the score and change text color
     */
    public void displayScoreA(int a){
        //To set textColor
        TextView score_aTV = (TextView) findViewById(R.id.score_a_textView);
        TextView score_bTV = (TextView) findViewById(R.id.score_b_textView);
        score_aTV.setTextColor(Color.parseColor("#D81B60"));
        score_bTV.setTextColor(Color.parseColor("#536DFE"));
        //To set score text
        score_aTV.setText(""+a);
    }

    public void displayScoreB(int b){
        //To set textColor
        TextView score_aTV = (TextView) findViewById(R.id.score_a_textView);
        TextView score_bTV = (TextView) findViewById(R.id.score_b_textView);
        score_bTV.setTextColor(Color.parseColor("#D81B60"));
        score_aTV.setTextColor(Color.parseColor("#536DFE"));
        //To set score text
        score_bTV.setText(""+b);
    }


}
