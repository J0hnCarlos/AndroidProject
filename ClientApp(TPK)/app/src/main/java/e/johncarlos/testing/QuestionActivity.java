package e.johncarlos.testing;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class QuestionActivity extends AppCompatActivity {

    ImageView blaster1;
    ImageView blaster2;
    ImageView blaster3;
    ImageView blaster4;
    ImageView blaster5;
    ImageView shoot1;
    ImageView shoot2;
    ImageView shoot3;
    ImageView shoot4;
    ImageView shoot5;

    MediaPlayer shootsound;
    MediaPlayer dingding;

    TextView health;
    int health1 = 30;

    public static int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

        setContentView(R.layout.activity_question);

        health = findViewById(R.id.healthNumber);

        if (GameOverActivity.save != 0){
            health1 = GameOverActivity.save;
        }

        health.setText("" + health1);

        if (health1 < 1){
            Intent go = new Intent(QuestionActivity.this, GameOverActivity.class);
            startActivity(go);
            finish();
        }

        blaster1 = findViewById(R.id.blasterLeft);
        blaster2 = findViewById(R.id.blasterTopLeft);
        blaster3 = findViewById(R.id.blasterTop);
        blaster4 = findViewById(R.id.blasterTopRight);
        blaster5 = findViewById(R.id.blasterRight);

        shoot1 = findViewById(R.id.blasterShootLeft);
        shoot2 = findViewById(R.id.blasterShootTopLeft);
        shoot3 = findViewById(R.id.blasterShootTop);
        shoot4 = findViewById(R.id.blasterShootTopRight);
        shoot5 = findViewById(R.id.blasterShootRight);

        DatabaseHelper db = new DatabaseHelper(this);

        /*
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    blaster1.setImageDrawable(getResources().getDrawable(R.drawable.zblaster));
                }
            }, 1000);

            Handler handler2 = new Handler();
            handler2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    blaster2.setImageDrawable(getResources().getDrawable(R.drawable.zblaster));
                }
            }, 2700);

            Handler handler3 = new Handler();
            handler3.postDelayed(new Runnable() {
                @Override
                public void run() {
                    blaster3.setImageDrawable(getResources().getDrawable(R.drawable.zblaster));
                }
            }, 4800);

            Handler handler4 = new Handler();
            handler4.postDelayed(new Runnable() {
                @Override
                public void run() {
                    blaster4.setImageDrawable(getResources().getDrawable(R.drawable.zblaster));
                }
            }, 6500);

            Handler handler5 = new Handler();
            handler5.postDelayed(new Runnable() {
                @Override
                public void run() {
                    blaster5.setImageDrawable(getResources().getDrawable(R.drawable.zblaster));
                }
            }, 8200);

            */

        final Quiz quiz = db.getQuiz();

        final TextView question = findViewById(R.id.question);
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
                    if (selectedOption.equals(quiz.getAnswer())) {
                        Toast.makeText(QuestionActivity.this, "Correct", Toast.LENGTH_SHORT).show();

                        dingding = MediaPlayer.create(QuestionActivity.this, R.raw.zding);

                        score++;

                        dingding.start();

                        dingding.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            public void onCompletion(MediaPlayer mp) {
                                mp.release();

                            };
                        });
                        // Create a new intent to open the {@link LearnActivity}
                        Intent resultIntent = new Intent(QuestionActivity.this, QuestionActivity.class);
                        // Start the new activity
                        startActivity(resultIntent);
                    } else {
                            Toast.makeText(QuestionActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();

                            Random rng = new Random();
                            int check = rng.nextInt(5);

                            switch (check){
                                case 0:
                                    number1();
                                    break;
                                case 1:
                                    number2();
                                    break;
                                case 2:
                                    number3();
                                    break;
                                case 3:
                                    number4();
                                    break;
                                default:
                                    number5();
                                    break;
                            }
                    }
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

    public void backToMainMenu (View view){
        Intent back = new Intent(QuestionActivity.this, MainMenuActivity.class);
        startActivity(back);
    }

    public void number1(){
        shootsound = MediaPlayer.create(QuestionActivity.this, R.raw.zshoot);
        shootsound.start();
        shootsound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();

            };
        });

        Handler wait = new Handler();
        wait.postDelayed(new Runnable() {
            @Override
            public void run() {

                shoot1.setImageDrawable(getResources().getDrawable(R.drawable.zshootbeam));

                blaster1.setImageDrawable(getResources().getDrawable(R.drawable.zblastershoot));
            }
        }, 1000);

        Handler wait2 = new Handler();
        wait2.postDelayed(new Runnable() {
            @Override
            public void run() {
                shoot1.setImageDrawable(null);

                blaster1.setImageDrawable(getResources().getDrawable(R.drawable.zblaster));

                health.setText("" + health1);
                GameOverActivity.save = health1;
            }
        }, 2000);

        health1 = health1 - 1;

        checkHealth();
    }

    public void number2(){
        shootsound = MediaPlayer.create(QuestionActivity.this, R.raw.zshoot);
        shootsound.start();

        shootsound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();

            };
        });

        Handler wait = new Handler();
        wait.postDelayed(new Runnable() {
            @Override
            public void run() {

                shoot1.setImageDrawable(getResources().getDrawable(R.drawable.zshootbeam));
                shoot5.setImageDrawable(getResources().getDrawable(R.drawable.zshootbeam));

                blaster1.setImageDrawable(getResources().getDrawable(R.drawable.zblastershoot));
                blaster5.setImageDrawable(getResources().getDrawable(R.drawable.zblastershoot));
            }
        }, 1000);

        Handler wait2 = new Handler();
        wait2.postDelayed(new Runnable() {
            @Override
            public void run() {
                shoot1.setImageDrawable(null);
                shoot5.setImageDrawable(null);

                blaster1.setImageDrawable(getResources().getDrawable(R.drawable.zblaster));
                blaster5.setImageDrawable(getResources().getDrawable(R.drawable.zblaster));

                health.setText("" + health1);

                GameOverActivity.save = health1;
            }
        }, 2000);

        health1 = health1 - 2;

        checkHealth();
    }

    public void number3(){
        shootsound = MediaPlayer.create(QuestionActivity.this, R.raw.zshoot);
        shootsound.start();

        shootsound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();

            };
        });

        Handler wait = new Handler();
        wait.postDelayed(new Runnable() {
            @Override
            public void run() {

                shoot1.setImageDrawable(getResources().getDrawable(R.drawable.zshootbeam));
                shoot3.setImageDrawable(getResources().getDrawable(R.drawable.zshootbeam));
                shoot5.setImageDrawable(getResources().getDrawable(R.drawable.zshootbeam));

                blaster1.setImageDrawable(getResources().getDrawable(R.drawable.zblastershoot));
                blaster3.setImageDrawable(getResources().getDrawable(R.drawable.zblastershoot));
                blaster5.setImageDrawable(getResources().getDrawable(R.drawable.zblastershoot));
            }
        }, 1000);

        Handler wait2 = new Handler();
        wait2.postDelayed(new Runnable() {
            @Override
            public void run() {
                shoot1.setImageDrawable(null);
                shoot3.setImageDrawable(null);
                shoot5.setImageDrawable(null);

                blaster1.setImageDrawable(getResources().getDrawable(R.drawable.zblaster));
                blaster3.setImageDrawable(getResources().getDrawable(R.drawable.zblaster));
                blaster5.setImageDrawable(getResources().getDrawable(R.drawable.zblaster));

                health.setText("" + health1);

                GameOverActivity.save = health1;
            }
        }, 2000);

        health1 = health1 - 3;

        checkHealth();
    }

    public void number4(){
        shootsound = MediaPlayer.create(QuestionActivity.this, R.raw.zshoot);
        shootsound.start();

        shootsound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();

            };
        });

        Handler wait = new Handler();
        wait.postDelayed(new Runnable() {
            @Override
            public void run() {

                shoot2.setImageDrawable(getResources().getDrawable(R.drawable.zshootbeam));
                shoot3.setImageDrawable(getResources().getDrawable(R.drawable.zshootbeam));
                shoot4.setImageDrawable(getResources().getDrawable(R.drawable.zshootbeam));
                shoot5.setImageDrawable(getResources().getDrawable(R.drawable.zshootbeam));

                blaster2.setImageDrawable(getResources().getDrawable(R.drawable.zblastershoot));
                blaster3.setImageDrawable(getResources().getDrawable(R.drawable.zblastershoot));
                blaster4.setImageDrawable(getResources().getDrawable(R.drawable.zblastershoot));
                blaster5.setImageDrawable(getResources().getDrawable(R.drawable.zblastershoot));

            }
        }, 1000);

        Handler wait2 = new Handler();
        wait2.postDelayed(new Runnable() {
            @Override
            public void run() {
                shoot2.setImageDrawable(null);
                shoot3.setImageDrawable(null);
                shoot4.setImageDrawable(null);
                shoot5.setImageDrawable(null);

                blaster2.setImageDrawable(getResources().getDrawable(R.drawable.zblaster));
                blaster3.setImageDrawable(getResources().getDrawable(R.drawable.zblaster));
                blaster4.setImageDrawable(getResources().getDrawable(R.drawable.zblaster));
                blaster5.setImageDrawable(getResources().getDrawable(R.drawable.zblaster));

                health.setText("" + health1);

                GameOverActivity.save = health1;
            }
        }, 2000);

        health1 = health1 - 4;

       checkHealth();
    }

    public void number5(){
        shootsound = MediaPlayer.create(QuestionActivity.this, R.raw.zshoot);
        shootsound.start();

        shootsound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();

            };
        });

        Handler wait = new Handler();
        wait.postDelayed(new Runnable() {
            @Override
            public void run() {

                shoot1.setImageDrawable(getResources().getDrawable(R.drawable.zshootbeam));
                shoot2.setImageDrawable(getResources().getDrawable(R.drawable.zshootbeam));
                shoot3.setImageDrawable(getResources().getDrawable(R.drawable.zshootbeam));
                shoot4.setImageDrawable(getResources().getDrawable(R.drawable.zshootbeam));
                shoot5.setImageDrawable(getResources().getDrawable(R.drawable.zshootbeam));

                blaster1.setImageDrawable(getResources().getDrawable(R.drawable.zblastershoot));
                blaster2.setImageDrawable(getResources().getDrawable(R.drawable.zblastershoot));
                blaster3.setImageDrawable(getResources().getDrawable(R.drawable.zblastershoot));
                blaster4.setImageDrawable(getResources().getDrawable(R.drawable.zblastershoot));
                blaster5.setImageDrawable(getResources().getDrawable(R.drawable.zblastershoot));

            }
        }, 1000);

        Handler wait2 = new Handler();
        wait2.postDelayed(new Runnable() {
            @Override
            public void run() {
                shoot1.setImageDrawable(null);
                shoot2.setImageDrawable(null);
                shoot3.setImageDrawable(null);
                shoot4.setImageDrawable(null);
                shoot5.setImageDrawable(null);

                blaster1.setImageDrawable(getResources().getDrawable(R.drawable.zblaster));
                blaster2.setImageDrawable(getResources().getDrawable(R.drawable.zblaster));
                blaster3.setImageDrawable(getResources().getDrawable(R.drawable.zblaster));
                blaster4.setImageDrawable(getResources().getDrawable(R.drawable.zblaster));
                blaster5.setImageDrawable(getResources().getDrawable(R.drawable.zblaster));

                health.setText("" + health1);

                GameOverActivity.save = health1;
            }
        }, 2000);

        health1 = health1 - 5;

        checkHealth();
    }

    public void checkHealth(){
        if (health1 < 1){
            Intent gameOver = new Intent(QuestionActivity.this, GameOverActivity.class);
            startActivity(gameOver);
            finish();
        }
    }
}
