package e.johncarlos.circle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import e.johncarlos.circle.Adapter.WheelImageAdapter;
import e.johncarlos.circle.Data.ImageData;
import github.hellocsl.cursorwheel.CursorWheelLayout;

public class MainActivity extends AppCompatActivity implements CursorWheelLayout.OnMenuSelectedListener {

    CursorWheelLayout wheel_image;
    List<ImageData> lstImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        loadData();

        wheel_image.setOnMenuSelectedListener(this); //If error, alt + enter (Make Activity)
    }

    private void loadData(){
        lstImage = new ArrayList<>();
        lstImage.add(new ImageData(R.drawable.b, "B"));
        lstImage.add(new ImageData(R.drawable.d, "D"));
        lstImage.add(new ImageData(R.drawable.e, "E"));
        lstImage.add(new ImageData(R.drawable.f, "F"));

        WheelImageAdapter imgAdapter = new WheelImageAdapter(getBaseContext(), lstImage);
        wheel_image.setAdapter(imgAdapter);
    }

    private void initViews(){
        wheel_image = findViewById(R.id.wheel_image);
    }

    @Override
    public void onItemSelected(CursorWheelLayout parent, View view, int pos) {
        if (parent.getId() == R.id.wheel_image)
            Toast.makeText(getBaseContext(), "Selected"+ lstImage.get(pos).imageDescription, Toast.LENGTH_SHORT).show();
    }
}
