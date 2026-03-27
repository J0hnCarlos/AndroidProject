package e.johncarlos.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
    }

    public void asd(View view){
        Intent go = new Intent(ResultActivity.this, MainCircleActivity.class);
        startActivity(go);
    }
}
