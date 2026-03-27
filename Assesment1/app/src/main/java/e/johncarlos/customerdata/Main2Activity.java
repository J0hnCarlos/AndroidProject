package e.johncarlos.customerdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private int check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView textViewName = findViewById(R.id.custname);
        TextView textViewCode = findViewById(R.id.postcode);
        TextView message = findViewById(R.id.details);

        Intent i = getIntent();

        String name = i.getStringExtra("name");
        String code = i.getStringExtra("code");

        textViewName.setText(name);
        textViewCode.setText(code);

        check = Integer.parseInt(code);

        if (check > 2999 && check < 4000 ){
            message.setText(name + " lives in VICTORIA");
        }
        else{
            message.setText(name + " does NOT live in VICTORIA");
        }
    }

    public void back(View view){
        Intent return_ = new Intent(Main2Activity.this, MainActivity.class);
        startActivity(return_);
    }
}
