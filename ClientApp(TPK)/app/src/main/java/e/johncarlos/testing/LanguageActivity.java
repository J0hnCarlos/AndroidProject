package e.johncarlos.testing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class LanguageActivity extends Activity {

    public static int codenumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        Spinner mLanguage = (Spinner) findViewById(R.id.spLanguage);
        final TextView mTextView = (TextView) findViewById(R.id.textView);

        ArrayAdapter mAdapter = new ArrayAdapter<String>(LanguageActivity.this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.language_option));
        mLanguage.setAdapter(mAdapter);

        mLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Context context;
                Resources resources;

                switch (i) {
                    case 1:
                        context = LocalHelper.setLocale(LanguageActivity.this, "en");
                        resources = context.getResources();
                        mTextView.setText(resources.getString(R.string.text_translation));
                        codenumber = 1;
                        break;
                    case 2:
                        context = LocalHelper.setLocale(LanguageActivity.this, "in");
                        resources = context.getResources();
                        mTextView.setText(resources.getString(R.string.text_translation));
                        codenumber = 2;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocalHelper.onAttach(newBase));
    }

    public void backMainmenu(View view){
        Intent back = new Intent(LanguageActivity.this, MainMenuActivity.class);
        startActivity(back);
    }
}

