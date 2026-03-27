package e.johncarlos.testing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Locale;

public class MainMenuActivity extends AppCompatActivity {

    private CircleMenuLayout mCircleMenuLayout;
    public String[] mItemText;
    private String check;

    int languageNumber = LanguageActivity.codenumber;

    ImageView middle;

    MediaPlayer beep;

    Context context;
    Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

        setContentView(R.layout.activity_main02);

        Intent codenumber = getIntent();
        String a;
        a = codenumber.getStringExtra("code");

        String infoText = getResources().getString(R.string.info_translation).toString();
        String helpText = getResources().getString(R.string.help_translation).toString();
        String otherText = getResources().getString(R.string.other_translation).toString();
        String vocabText = getResources().getString(R.string.vocabulary_translation).toString();
        String gameText = getResources().getString(R.string.gaming_translation).toString();
        String surpriseText = getResources().getString(R.string.surprise_translation).toString();

        mItemText = new String[]{infoText, helpText, otherText, vocabText, gameText, surpriseText};
        int[] mItemImgs = new int[] { R.drawable.a,
                R.drawable.b, R.drawable.share,
                R.drawable.d, R.drawable.e,
                R.drawable.f
        };

        mCircleMenuLayout = findViewById(R.id.id_menulayout);
        mCircleMenuLayout.setMenuItemIconsAndTexts(mItemImgs, mItemText);

        mCircleMenuLayout.setOnMenuItemClickListener(new CircleMenuLayout.OnMenuItemClickListener() {
            @Override
            public void itemClick(View view, int pos) {
                check = mItemText[pos];

                switch (check){
                    case "Info":
                    case "Informasi":
                        Intent info = new Intent(MainMenuActivity.this, InfoActivity.class);
                        startActivity(info);
                        break;
                    case "Help":
                    case "Bantuan":
                        composeEmail();
                        break;
                    case "Other":
                    case "Lain-Lain":
                        Intent other = new Intent(MainMenuActivity.this, LinksActivity.class);
                        startActivity(other);
                        break;
                    case "Vocabulary":
                    case "Bahasa":
                        Intent vocab = new Intent(MainMenuActivity.this, VocabularyActivity.class);
                        startActivity(vocab);
                        break;

                    case "Game":
                    case "Permainan":
                        Intent game = new Intent(MainMenuActivity.this, QuestionActivity.class);
                        startActivity(game);
                        finish();
                        break;
                    case "Surprise":
                    case "Kejutan":
                        Intent surprise = new Intent(MainMenuActivity.this, DummyActivity.class);
                        startActivity(surprise);
                        break;
                }
            }

            @Override
            public void itemCenterClick(View view) {

                beep = MediaPlayer.create(MainMenuActivity.this, R.raw.zbeepbeep);

                String language = getBaseContext().getResources().getConfiguration().locale.getLanguage();
                middle = findViewById(R.id.image_center);

                if (language.equals("en")) {

                    language = "in";

                    Locale changeLanguage = new Locale(language);

                    Resources res = getResources();
                    DisplayMetrics dm = res.getDisplayMetrics();
                    Configuration conf = res.getConfiguration();
                    conf.locale = changeLanguage;
                    res.updateConfiguration(conf, dm);

                    middle.setImageDrawable(getResources().getDrawable(R.drawable.zturn_plate_unlogin_center_in));
                    //beep.start();
                }else {
                    language = "en";
                    Locale changeLanguage = new Locale(language);

                    Resources res = getResources();
                    DisplayMetrics dm = res.getDisplayMetrics();
                    Configuration conf = res.getConfiguration();
                    conf.locale = changeLanguage;
                    res.updateConfiguration(conf, dm);

                    middle.setImageDrawable(getResources().getDrawable(R.drawable.turnplate_center_unlogin));
                    //beep.start();
                }
                Intent restart = new Intent(MainMenuActivity.this, MainMenuActivity.class);
                startActivity(restart);
            }
        });
    }

    public void composeEmail() {
        String[] addresses = {"jc12740@gmail.com","s3701835@student.rmit.edu.au"};

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
