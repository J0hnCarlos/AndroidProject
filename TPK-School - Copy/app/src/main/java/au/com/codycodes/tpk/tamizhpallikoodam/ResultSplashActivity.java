package au.com.codycodes.tpk.tamizhpallikoodam;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This creates the result screen to display with either
 * 'answer: correct' or 'answer: incorrect' depending on the result that is passed in
 * It displays in a toast message for three seconds and then goes back to the QuestionActivity
 */
public class ResultSplashActivity extends AppCompatActivity {

    //private final int SPLASH_DISPLAY_LENGTH = 3000;
    //public TextView result_text;
    public int finalresultcount = 0;
    public static final String TOTAL = "au.com.codycodes.tpk.tamizhpallikoodam.TOTAL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_splash);

        Button button_next = findViewById(R.id.button_next);
        QuestionActivity ques = new QuestionActivity();

        if (ques.getCount() < 10) {
            button_next.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    Intent buttonIntent = new Intent(ResultSplashActivity.this, QuestionActivity.class);
                    startActivity(buttonIntent); // startActivity allow you to move
                }
            });
        } else {
            Intent buttonIntent = new Intent(ResultSplashActivity.this,FinalScore.class);
            buttonIntent.putExtra(TOTAL, ques.getScore() + "/10");

            startActivity(buttonIntent); // startActivity allow you to move
        }
        TextView result_text = findViewById(R.id.result_text);
        TextView result_text1 = findViewById(R.id.result_text1);
        TextView result_text2 = findViewById(R.id.result_text2);
        TextView result_text3 = findViewById(R.id.result_text3);
        TextView result_text4 = findViewById(R.id.result_text4);
        TextView question_text = findViewById(R.id.question_text);

        Intent i = getIntent();
        String result = i.getStringExtra(QuestionActivity.RESULT);
        String answer = i.getStringExtra(QuestionActivity.ANSWER);
        String guess = i.getStringExtra(QuestionActivity.GUESS);
        String question = i.getStringExtra(QuestionActivity.QUESTION);

        TextView quNum = findViewById(R.id.question_number);
        quNum.setText(ques.getCount() + "/10");
        if (result.equals("CORRECT")){
            result_text.setText("Congratulations!");
            result_text1.setText("You answered: ");
            result_text2.setText(guess);
            question_text.setText(question);
            finalresultcount++;
        } else {
            result_text.setText("Sorry, that answer is incorrect!");
            result_text1.setText("You answered: ");
            result_text2.setText(guess);
            question_text.setText(question);
        }

        result_text3.setText("The correct answer is: ");
        result_text4.setText(answer);

        //Toast.makeText(getApplicationContext(), "Answer: " + result, Toast.LENGTH_LONG).show();

        /*new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                // Create an Intent that will start the Menu-Activity.
                Intent mainIntent = new Intent(ResultSplashActivity.this, QuestionActivity.class);
                ResultSplashActivity.this.startActivity(mainIntent);
                ResultSplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);*/
    }
}
