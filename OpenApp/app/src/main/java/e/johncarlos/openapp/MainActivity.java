package e.johncarlos.openapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void composeEmail(View x) {
        String[] addresses = {"jc12740@gmail.com","s3701835@student.rmit.edu.au"};
        String subject = "Something";

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void open_map(View w){
        Uri geoLocation = Uri.parse("https://www.google.com/maps/place/Crown+Melbourne/@-37.8235301,144.9559066,17z/data=!3m1!4b1!4m7!3m6!1s0x6ad65d52d5a34589:0xedd795a14e4e9758!5m1!1s2018-08-30!8m2!3d-37.8235301!4d144.9580953");
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }

    public void openwebpage(View v){
        String url = "https://www.rmit.edu.au/";
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }
}
