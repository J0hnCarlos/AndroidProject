package au.com.codycodes.tpk.tamizhpallikoodam;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinalScore extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);

        Intent i = getIntent();
        String total = i.getStringExtra(ResultSplashActivity.TOTAL);

        TextView score = findViewById(R.id.ress);
        score.setText(total);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent buttonIntent = new Intent(FinalScore.this, HomeActivity.class);
                startActivity(buttonIntent); // startActivity allow you to move
            }
        });

    }
}
