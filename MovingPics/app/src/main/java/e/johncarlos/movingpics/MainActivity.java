package e.johncarlos.movingpics;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Path;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends Activity {

    int speed = 3;
    MediaPlayer ring;

    //WIP
    /*int colorFrom = ContextCompat.getColor(this,R.color.red);
    int colorTo = ContextCompat.getColor(this,R.color.blue);
    ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
    */


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ring = MediaPlayer.create(MainActivity.this, R.raw.ring);


        View view = findViewById(R.id.text7);
        Path path = new Path();
        path.addCircle(0, 0, 400, Path.Direction.CW);

        ViewPathAnimator.animate(view, path, 0, speed);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                View view2 = findViewById(R.id.text6);
                Path path2 = new Path();
                path2.addCircle(0, 0, 400, Path.Direction.CW);

                ViewPathAnimator.animate(view2, path2, 0, speed);

            }
        }, 1600);

        Handler handler2 = new Handler();
        handler2.postDelayed(new Runnable() {
            @Override
            public void run() {
                View view3 = findViewById(R.id.text5);
                Path path3 = new Path();
                path3.addCircle(0, 0, 400, Path.Direction.CW);

                ViewPathAnimator.animate(view3, path3, 0, speed);

            }
        }, 3100);

        Handler handler3 = new Handler();
        handler3.postDelayed(new Runnable() {
            @Override
            public void run() {
                View view4 = findViewById(R.id.text4);
                Path path4 = new Path();
                path4.addCircle(0, 0, 400, Path.Direction.CW);

                ViewPathAnimator.animate(view4, path4, 0, speed);

            }
        }, 4600);

        Handler handler4 = new Handler();
        handler4.postDelayed(new Runnable() {
            @Override
            public void run() {
                View view5 = findViewById(R.id.text3);
                Path path5 = new Path();
                path5.addCircle(0, 0, 400, Path.Direction.CW);

                ViewPathAnimator.animate(view5, path5, 0, speed);

            }
        }, 6100);

        Handler handler5 = new Handler();
        handler5.postDelayed(new Runnable() {
            @Override
            public void run() {
                View view6 = findViewById(R.id.text2);
                Path path6 = new Path();
                path6.addCircle(0, 0, 400, Path.Direction.CW);

                ViewPathAnimator.animate(view6, path6, 0, speed);

            }
        }, 7600);


        Handler handler6 = new Handler();
        handler6.postDelayed(new Runnable() {
            @Override
            public void run() {
                View view7 = findViewById(R.id.text);
                Path path7 = new Path();
                path7.addCircle(0, 0, 400, Path.Direction.CW);

                ViewPathAnimator.animate(view7, path7, 0, speed);

            }
        }, 9100);
    }

    public void green(View g){
        String num = "1";
        Intent greenI = new Intent(MainActivity.this, Main2Activity.class);
        greenI.putExtra("code", num);
        ring.stop();
        startActivity(greenI);
    }

    public void blue(View b){
        String num = "2";
        Intent blueI = new Intent(MainActivity.this, Main2Activity.class);
        blueI.putExtra("code", num);
        ring.stop();
        startActivity(blueI);
    }

    public void darkgreen(View dg){
        String num = "3";
        Intent darkgreenI = new Intent(MainActivity.this, Main2Activity.class);
        darkgreenI.putExtra("code", num);
        ring.stop();
        startActivity(darkgreenI);
    }

    public void red(View dg){
        String num = "4";
        Intent redI = new Intent(MainActivity.this, Main2Activity.class);
        redI.putExtra("code", num);
        ring.stop();
        startActivity(redI);
    }

    public void purple(View dg){
        String num = "5";
        Intent purpleI = new Intent(MainActivity.this, Main2Activity.class);
        purpleI.putExtra("code", num);
        ring.stop();
        startActivity(purpleI);
    }

    public void pink(View dg){
        String num = "6";
        Intent pinkI = new Intent(MainActivity.this, Main2Activity.class);
        pinkI.putExtra("code", num);
        ring.stop();
        startActivity(pinkI);
    }

    public void orange(View dg){
        String num = "7";
        Intent orangeI = new Intent(MainActivity.this, Main2Activity.class);
        orangeI.putExtra("code", num);
        ring.stop();
        startActivity(orangeI);
    }

    public void check(View view){
        EditText look = findViewById(R.id.editText);
        String name = look.getText().toString();
        ImageView black = findViewById(R.id.imageView);

        if (name.equals("JOHN CARLOS")){
            black.setImageDrawable(getResources().getDrawable(R.drawable.black));
            Toast.makeText(MainActivity.this, "CORRECT!", Toast.LENGTH_LONG).show();
        } else {
            black.setImageDrawable(null);
            Toast.makeText(MainActivity.this, "WRONG!", Toast.LENGTH_LONG).show();
        }
    }

    public void onStop() {
        super.onStop();
        ring.stop();
    }

    public void onResume(){
        super.onResume();

        if (ring !=null) {
            ring.start();
        }
    }
}