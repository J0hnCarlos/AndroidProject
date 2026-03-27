package e.johncarlos.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    EditText b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendScreen(View v){

        b = (EditText) findViewById(R.id.editText2);

        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        EditText editTexta = (EditText) findViewById(R.id.editText);
        EditText editTextb = (EditText) findViewById(R.id.editText2);

        intent.putExtra("name", editTexta.getText().toString());
        intent.putExtra("email", editTextb.getText().toString());
        startActivity(intent);
    }

    public void sendMessage(View view){
        String[] addresses = {"jc12740@gmail.com"};
        String subject = "";

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
