package e.johncarlos.circle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import e.johncarlos.circle.Adapter.WheelImageAdapter;
import e.johncarlos.circle.Adapter.WheelTextAdapter;
import e.johncarlos.circle.Data.ImageData;
import e.johncarlos.circle.Data.MenuItemData;
import github.hellocsl.cursorwheel.CursorWheelLayout;

public class MainActivity extends AppCompatActivity implements CursorWheelLayout.OnMenuSelectedListener{

    CursorWheelLayout wheel_text, wheel_image;
    List<MenuItemData> lstText;
    List<ImageData> lstImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        
        loadData();

        wheel_text.setOnMenuSelectedListener(this);
        wheel_image.setOnMenuSelectedListener(this);
    }

    private void loadData() {
        lstText = new ArrayList<>();
        for (int i = 0; i < 9; i++)
            lstText.add(new MenuItemData(""+1));
            lstText.add(new MenuItemData("OFF"));
        WheelTextAdapter adapter = new WheelTextAdapter(getBaseContext(), lstText);
        wheel_text.setAdapter(adapter);

        lstImage = new ArrayList<>();
        lstImage.add(new ImageData(R.drawable.b, "b"));
        lstImage.add(new ImageData(R.drawable.d, "d"));
        lstImage.add(new ImageData(R.drawable.e, "e"));
        lstImage.add(new ImageData(R.drawable.f, "f"));

        WheelImageAdapter imgAdapter = new WheelImageAdapter(getBaseContext(), lstImage);
        wheel_image.setAdapter(imgAdapter);
    }

    private void initViews(){
        wheel_image = (CursorWheelLayout)findViewById(R.id.wheel_image);
        wheel_text = (CursorWheelLayout)findViewById(R.id.wheel_text);

    }

    @Override
    public void onItemSelected(CursorWheelLayout parent, View view, int pos) {
        if (parent.getId() == R.id.wheel_text)
            Toast.makeText(getBaseContext(), "Selected: "+lstText.get(pos).xTitle, Toast.LENGTH_SHORT).show();
        else if (parent.getId() == R.id.wheel_image)
            Toast.makeText(getBaseContext(), "Selected"+ lstImage.get(pos).imageDescription, Toast.LENGTH_SHORT).show();
    }
}
