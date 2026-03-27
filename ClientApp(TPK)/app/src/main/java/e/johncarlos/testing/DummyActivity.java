package e.johncarlos.testing;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Path;
import android.media.MediaPlayer;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DummyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        MediaPlayer player;
        ImageView pic = findViewById(R.id.imageView2);

        pic.setImageDrawable(getResources().getDrawable(R.drawable.js));
        player = MediaPlayer.create(DummyActivity.this, R.raw.js);
        player.start();
    }

    public void asd(View view){
        Intent move = new Intent(DummyActivity.this, MainMenuActivity.class);
        startActivity(move);
    }
}
