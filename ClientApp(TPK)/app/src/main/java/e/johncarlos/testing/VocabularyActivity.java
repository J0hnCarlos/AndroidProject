package e.johncarlos.testing;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import java.util.Locale;

public class VocabularyActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_vocabulary);
    }

    public void back(View view){
        Intent asd = new Intent(VocabularyActivity.this, MainMenuActivity.class);
        startActivity(asd);
    }

    public void goColor(View view){
        Intent colorsIntent = new Intent(VocabularyActivity.this, LearnActivity.class);
        colorsIntent.putExtra("category","Colors");

        // Start the new activity
        startActivity(colorsIntent);
    }

    public void goNumber(View view){
        Intent numberIntent = new Intent(VocabularyActivity.this, LearnActivity.class);
        numberIntent.putExtra("category", "Numbers");
        // Start the new activity
        startActivity(numberIntent);
    }

    public void goFamily(View view){
        Intent familyIntent = new Intent(VocabularyActivity.this, LearnActivity.class);
        familyIntent.putExtra("category","Family");

        // Start the new activity
        startActivity(familyIntent);
    }

    public void goPhrases(View view){
        Intent phrasesIntent = new Intent(VocabularyActivity.this, LearnActivity.class);
        phrasesIntent.putExtra("category","Phrases");

        // Start the new activity
        startActivity(phrasesIntent);
    }
}
