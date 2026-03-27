package com.tutorialsee.circlemenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.tutorialsee.circlemenu.R;
import com.tutorialsee.circlemenu.CircleMenuLayout.OnMenuItemClickListener;

public class MainCircleActivity extends Activity {

	private CircleMenuLayout mCircleMenuLayout;
	private String[] mItemTexts = new String[] { "A", "B", "C","D", "E", "F","G","H" };
	private int[] mItemImgs = new int[] { R.drawable.a,
			R.drawable.b, R.drawable.c,
			R.drawable.d, R.drawable.e,
			R.drawable.f,R.drawable.g,R.drawable.h};
	private String check;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main02);

		mCircleMenuLayout = (CircleMenuLayout) findViewById(R.id.id_menulayout);
		mCircleMenuLayout.setMenuItemIconsAndTexts(mItemImgs, mItemTexts);

		mCircleMenuLayout.setOnMenuItemClickListener(new OnMenuItemClickListener()
		{

			@Override
			public void itemClick(View view, int pos)
			{
				check = mItemTexts[pos];

				switch (check){
					case "A":
                    case "B":
                    case "C":
                    case "D":
                        Intent asd = new Intent(MainCircleActivity.this, Result2Activity.class);
                        startActivity(asd);
                        break;

					case "E":
					case "F":
					case "G":
					case "H":
                        Intent qwe = new Intent(MainCircleActivity.this, ResultActivity.class);
                        startActivity(qwe);
                        break;
				}
				}

			@Override
			public void itemCenterClick(View view)
			{
				Toast.makeText(MainCircleActivity.this,"you can do something just like ccb  ",Toast.LENGTH_SHORT).show();
			}
		});
	}
}