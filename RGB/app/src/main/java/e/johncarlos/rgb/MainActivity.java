package e.johncarlos.rgb;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private int redSeek, greenSeek, blueSeek;
    SeekBar SeekBarR, SeekBarG, SeekBarB;
    LinearLayout mScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScreen = (LinearLayout) findViewById(R.id.mscreen);

        SeekBarR = (SeekBar) findViewById(R.id.seekBarR);
        SeekBarG = (SeekBar) findViewById(R.id.seekBarG);
        SeekBarB = (SeekBar) findViewById(R.id.seekBarB);
        updateBackground();

        SeekBarG.setOnSeekBarChangeListener(seekBarChangeListener);
        SeekBarR.setOnSeekBarChangeListener(seekBarChangeListener);
        SeekBarB.setOnSeekBarChangeListener(seekBarChangeListener);
    }

    private SeekBar.OnSeekBarChangeListener seekBarChangeListener
            = new SeekBar.OnSeekBarChangeListener()
    {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,
                                      boolean fromUser) {
// TODO Auto-generated method stub
            updateBackground();
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
// TODO Auto-generated method stub
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
// TODO Auto-generated method stub
        }
    };

    private void updateBackground()
    {
        redSeek = SeekBarR.getProgress();
        greenSeek = SeekBarG.getProgress();
        blueSeek = SeekBarB.getProgress();
        mScreen.setBackgroundColor(0xff000000+ redSeek * 0x10000 + greenSeek * 0b100000000 + blueSeek);
    }
}
