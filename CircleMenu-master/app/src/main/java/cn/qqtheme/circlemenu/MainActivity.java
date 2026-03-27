package cn.qqtheme.circlemenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.qqtheme.framework.widget.CircleMenu;

public class MainActivity extends Activity {

    private String[] itemTexts = new String[]{
            "John ",
            "George",
            "Kirill",
            "Peter",
            "Kynan",
            "Karl",
            "Boby"
    };
    private int[] itemIcons = new int[]{
            R.drawable.ic_skin_create,
            R.drawable.ic_skin_import,
            R.drawable.ic_skin_manage,
            R.drawable.ic_skin_material,
            R.drawable.ic_about,
            R.drawable.ic_product,
            R.drawable.ic_upgrade
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CircleMenu circleMenu = (CircleMenu) findViewById(R.id.circle_menu_items);
        circleMenu.setRotating(true);//是否启用旋转
        circleMenu.setItems(itemTexts, itemIcons);//显示文字及图标
        //circleMenu.setItems(itemIcons);//只显示图标
        circleMenu.setIconSize(60);//图标大小，单位为dp
        circleMenu.setOnItemClickListener(new CircleMenu.OnItemClickListener() {
            @Override
            public void onItemClick(CircleMenu.ItemView view) {
                Toast.makeText(MainActivity.this, itemTexts[view.getPosition()], Toast.LENGTH_SHORT).show();

                stuff();
            }
        });
    }

    public void whatToDo(View view){
        Toast.makeText(MainActivity.this, "Hello there", Toast.LENGTH_SHORT).show();
    }

    public void stuff(){
        String[] asd;

        asd = itemTexts;

        switch (asd[0]){

        }
    }
}
