package e.johncarlos.testing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity {

    Intent asd = getIntent();

    public static int save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

        setContentView(R.layout.activity_game_over);

        String stuff = String.valueOf(QuestionActivity.score);

        TextView number = findViewById(R.id.result);
        number.setText(stuff);

        QuestionActivity.score = 0;
    }

    public void back(View view){
        Intent asd  = new Intent(GameOverActivity.this, MainMenuActivity.class);
        startActivity(asd);

        save = 0;

        finish();
    }

    public void onStop() {
        super.onStop();
        save = 0;
    }
}
