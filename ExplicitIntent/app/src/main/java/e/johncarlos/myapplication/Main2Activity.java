package e.johncarlos.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView textView = findViewById(R.id.textView4);
        TextView text_view = findViewById(R.id.textView5);

        Intent i = getIntent();

        String name = i.getStringExtra("name");
        String email = i.getStringExtra("email");

        textView.setText(name);
        text_view.setText(email);
    }

    public void back(View view){
        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
        startActivity(intent);
    }
}
