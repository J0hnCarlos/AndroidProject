package e.johncarlos.customerdata;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void send(View view){
        Intent go = new Intent(MainActivity.this, Main2Activity.class);

        EditText name = (EditText) findViewById(R.id.editText);
        EditText postcode = findViewById(R.id.editText2);

        go.putExtra("name", name.getText().toString());
        go.putExtra("code", postcode.getText().toString());
        startActivity(go);
    }

    public void openwebpage(View v){
        String url = "https://www.amazon.com/";
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }
}
