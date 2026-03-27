package e.johncarlos.button;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void h(View view){
        CheckBox h = (CheckBox) findViewById(R.id.check4);
        ImageView imgH = (ImageView) findViewById(R.id.imageView);

        boolean checkh = h.isChecked();

        if (checkh){
            imgH.setImageDrawable(getResources().getDrawable(R.drawable.h));
        }
        else{
            imgH.setImageDrawable(null);
        }
    }

    public void a(View view){
        CheckBox a = (CheckBox) findViewById(R.id.check1);
        ImageView imgA = (ImageView) findViewById(R.id.imageView2);
        ImageView imgA2 = (ImageView) findViewById(R.id.imageView8);

        boolean checka = a.isChecked();

        if (checka){
            imgA.setImageDrawable(getResources().getDrawable(R.drawable.a));
            imgA2.setImageDrawable(getResources().getDrawable(R.drawable.a));
        }
        else{
            imgA.setImageDrawable(null);
            imgA2.setImageDrawable(null);
        }
    }

    public void p(View view){
        CheckBox p = (CheckBox) findViewById(R.id.check5);
        ImageView imgP = (ImageView) findViewById(R.id.imageView3);
        ImageView imgP2 = (ImageView) findViewById(R.id.imageView4);

        boolean checkp = p.isChecked();

        if (checkp){
            imgP.setImageDrawable(getResources().getDrawable(R.drawable.p));
            imgP2.setImageDrawable(getResources().getDrawable(R.drawable.p));
        }
        else{
            imgP.setImageDrawable(null);
            imgP2.setImageDrawable(null);
        }
    }

    public void y(View view){
        CheckBox y = (CheckBox) findViewById(R.id.check6);
        ImageView imgY = (ImageView) findViewById(R.id.imageView5);
        ImageView imgY2 = (ImageView) findViewById(R.id.imageView9);

        boolean checkh = y.isChecked();

        if (checkh){
            imgY.setImageDrawable(getResources().getDrawable(R.drawable.y));
            imgY2.setImageDrawable(getResources().getDrawable(R.drawable.y));
        }
        else{
            imgY.setImageDrawable(null);
            imgY2.setImageDrawable(null);
        }
    }

    public void b(View view){
        CheckBox b = (CheckBox) findViewById(R.id.check2);
        ImageView imgB = (ImageView) findViewById(R.id.imageView6);

        boolean checkb = b.isChecked();

        if (checkb){
            imgB.setImageDrawable(getResources().getDrawable(R.drawable.b));
        }
        else{
            imgB.setImageDrawable(null);
        }
    }

    public void d(View view){
        CheckBox d = (CheckBox) findViewById(R.id.check3);
        ImageView imgD = (ImageView) findViewById(R.id.imageView7);

        boolean checkb = d.isChecked();

        if (checkb){
            imgD.setImageDrawable(getResources().getDrawable(R.drawable.d));
        }
        else{
            imgD.setImageDrawable(null);
        }
    }
}
