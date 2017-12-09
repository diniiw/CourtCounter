package com.example.android.courtcounter;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreA = 0;
    int scoreB = 0;
    private EditText editTeamA;
    private EditText editTeamB;
    private TextView results1,results2,results3,results4;
    private TextView countdown_txt;
    private CountDownTimer countDownTimer;
    private Button round1, round2, round3, round4;
    private long timeLeftToMilisecond = 720000;
    private boolean timerRunning;
    private String result_type;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

        //Start round 1
        round1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer();
                result_type = "round1";
            }
        });

        //Start round 2
        round2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer();
                result_type = "round2";
            }
        });

        //Start round 3
        round3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer();
                result_type = "round3";
            }
        });

        //Start round 4
        round4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer();
                result_type = "round4";
            }
        });
    }

    protected void initialize(){
        countdown_txt = (TextView) findViewById(R.id.countdown_txt);
        round1 = (Button) findViewById(R.id.b_round1);
        round2 = (Button) findViewById(R.id.b_round2);
        round3 = (Button) findViewById(R.id.b_round3);
        round4 = (Button) findViewById(R.id.b_round4);
        results1 = (TextView) findViewById(R.id.txt_results1);
        results2 = (TextView) findViewById(R.id.txt_results2);
        results3 = (TextView) findViewById(R.id.txt_results3);
        results4 = (TextView) findViewById(R.id.txt_results4);
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

    /**
     * This method used to timer round 1 - round 4
     */

    public void startTimer(){
        countDownTimer = new CountDownTimer(timeLeftToMilisecond, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftToMilisecond = l;
                updateTimer();
            }

            @Override
            public void onFinish() {
                countdown_txt.setText("FINISH");

                if(result_type.equalsIgnoreCase("round1")){
                    results1.setText(scoreA + " : " + scoreB);
                }else if (result_type.equalsIgnoreCase("round2")){
                    results2.setText(scoreA + " : " + scoreB);
                } else if(result_type.equalsIgnoreCase("round3")){
                    results3.setText(scoreA + " : " + scoreB);
                }else{
                    results4.setText(scoreA + " : " + scoreB);
                }

            }
        }.start();
        timerRunning = true;
    }

    public void updateTimer(){
        int minutes = (int) timeLeftToMilisecond / 60000;
        int seconds = (int) timeLeftToMilisecond % 60000 / 1000;

        String timeLeftText;

        timeLeftText = "" + minutes;
        timeLeftText += ":";
        if (seconds < 10) timeLeftText += "0";
        timeLeftText += seconds;
        countdown_txt.setText(timeLeftText);
    }




}
