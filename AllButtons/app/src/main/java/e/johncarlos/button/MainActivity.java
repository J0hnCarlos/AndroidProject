package e.johncarlos.button;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void blackchange(View view){
        LinearLayout change = findViewById(R.id.background);

        change.setBackgroundColor(getResources().getColor(R.color.black));
    }

    public void redchange(View view){
        LinearLayout change = findViewById(R.id.background);

        change.setBackgroundColor(getResources().getColor(R.color.red));
    }

    public void orangechange(View view){
        LinearLayout change = findViewById(R.id.background);

        change.setBackgroundColor(getResources().getColor(R.color.orange));
    }

    public void yellowchange(View view){
        LinearLayout change = findViewById(R.id.background);

        change.setBackgroundColor(getResources().getColor(R.color.yellow));
    }

    public void greenchange(View view){
        LinearLayout change = findViewById(R.id.background);

        change.setBackgroundColor(getResources().getColor(R.color.green));
    }

    public void bluechange(View view){
        LinearLayout change = findViewById(R.id.background);

        change.setBackgroundColor(getResources().getColor(R.color.blue));
    }

    public void purplechange(View view){
        LinearLayout change = findViewById(R.id.background);

        change.setBackgroundColor(getResources().getColor(R.color.purple));
    }

    public void screen(View view){
        Intent act2 = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(act2);
    }
}
