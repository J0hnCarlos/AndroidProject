package e.johncarlos.movingpics;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        TextView text = findViewById(R.id.textView);
        Intent coderecieve = getIntent();
        String check = coderecieve.getStringExtra("code");

        switch (check){
            case "1":
                text.setText("First Letter: J");
                mp = MediaPlayer.create(Main2Activity.this, R.raw.island);
                mp.start();
                break;
            case "2":
                text.setText("Second Letter: O");
                mp = MediaPlayer.create(Main2Activity.this, R.raw.sans);
                mp.start();
                break;
            case "3":
                text.setText("Third Letter: H");
                mp = MediaPlayer.create(Main2Activity.this, R.raw.his);
                mp.start();
                break;
            case "4":
                text.setText("Forth Letter: N");
                mp = MediaPlayer.create(Main2Activity.this, R.raw.mariodie);
                mp.start();
                break;
            case "5":
                text.setText("Fifth Letters: CA");
                break;
            case "6":
                text.setText("Sixth Letters: RL");
                break;
            case "7":
                text.setText("Seventh Letter: OS");
        }
    }

    public void back(View view){
        Intent asd = new Intent(Main2Activity.this, MainActivity.class);
        startActivity(asd);
        mp.stop();
    }

    public void onStop(){
        super.onStop();
        mp.stop();
    }
}
