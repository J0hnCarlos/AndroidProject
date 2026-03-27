package e.johncarlos.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void asd(View view){
            EditText number = (EditText) findViewById(R.id.editText);
            ImageView test = (ImageView) findViewById(R.id.imageView);
            TextView math = (TextView) findViewById(R.id.textView3);
            int i = Integer.parseInt(number.getText().toString());
            int result;
            result = i % 6;

        switch (result) {
            case 0:
                test.setImageDrawable(getResources().getDrawable(R.drawable.sistine));
                break;
            case 1:
                test.setImageDrawable(getResources().getDrawable(R.drawable.charlotte));
                break;
            case 2:
                test.setImageDrawable(getResources().getDrawable(R.drawable.anime1));
                break;
            case 3:
                test.setImageDrawable(getResources().getDrawable(R.drawable.anime2));
                break;
            case 4 :
                test.setImageDrawable(getResources().getDrawable(R.drawable.anime3));
                break;
            case 5 :
                test.setImageDrawable(getResources().getDrawable(R.drawable.anime4));
                break;
            default:
                number.setError("");
                break;
        }
        number.getText().clear();
        math.setText(i + " mod " + 6 + " = " + result);
    }
}
