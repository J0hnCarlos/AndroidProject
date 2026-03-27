package au.com.codycodes.tpk.tamizhpallikoodam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.media.MediaPlayer;

public class QuestionActivity extends AppCompatActivity {

    /**
     * This creates the layout for the quiz page
     * It takes in the Quiz object to set questions, options and a result
     */
    // String correct should be renamed to result, as we want it to return correct or incorrect
    public static String result = "";
    //public static String answer = ;
    //public static String guess = "";
    public static final String RESULT = "au.com.codycodes.tpk.tamizhpallikoodam.RESULT";
    public static final String ANSWER = "au.com.codycodes.tpk.tamizhpallikoodam.ANSWER";
    public static final String GUESS = "au.com.codycodes.tpk.tamizhpallikoodam.GUESS";
    public static final String QUESTION = "au.com.codycodes.tpk.tamizhpallikoodam.QUESTION";
    private static int count = 0;
    private static int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        DatabaseHelper db = new DatabaseHelper(this);
        final Quiz quiz = db.getQuiz();

        TextView category = findViewById(R.id.category);
        category.setText(quiz.getCategory());
        TextView question = findViewById(R.id.question_text);
        question.setText(quiz.getTamilTranslation());
        TextView option1 = findViewById(R.id.option1);
        option1.setText(quiz.getOption1());
        TextView option2 = findViewById(R.id.option2);
        option2.setText(quiz.getOption2());
        TextView option3 = findViewById(R.id.option3);
        option3.setText(quiz.getOption3());
        TextView option4 = findViewById(R.id.option4);
        option4.setText(quiz.getOption4());

        final Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                RadioGroup rg = findViewById(R.id.options);

                if(rg.getCheckedRadioButtonId() != -1) {
                    String selectedOption = ((RadioButton)findViewById(rg.getCheckedRadioButtonId())).getText().toString();
                    count++;
                    if (selectedOption.equals(quiz.getAnswer())) {
                        result = "CORRECT";
                        score++;
                    } else {
                        result = "INCORRECT";
                    }
                    // result is correct or incorrect, passed to the ResultSplashActivity
                    Intent resultIntent = new Intent(QuestionActivity.this, ResultSplashActivity.class);
                    resultIntent.putExtra(RESULT, result);
                    // answer refers to the correct answer, passed to the ResultSplashActivity
                    resultIntent.putExtra(ANSWER, quiz.getAnswer());
                    // guess is the guess made by the user
                    resultIntent.putExtra(GUESS, selectedOption);
                    resultIntent.putExtra(QUESTION, quiz.getTamilTranslation());
                    // Start the new activity
                    startActivity(resultIntent);
                }else{
                    Toast.makeText(getApplicationContext(), "Please make a selection", Toast.LENGTH_LONG).show();
                }
            }
        });

        final ImageView play =  findViewById(R.id.play);
        final MediaPlayer mp = MediaPlayer.create(this, quiz.getAudioResourceId());

        play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mp.start();
            }
        });

    }

    public int getCount() {
        return count;
    }

    public int getScore() {
        return score;
    }

}
