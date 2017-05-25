package a67yjh00.com.example.lg.contextmenutest;

import android.graphics.Color;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout linear;
    Button but2;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button but1=(Button) findViewById(R.id.but1);
        but2=(Button)findViewById(R.id.but2);
        linear=(LinearLayout)findViewById(R.id.linear);
        img=(ImageView)findViewById(R.id.img1);
        registerForContextMenu(but1);
        registerForContextMenu(but2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater=getMenuInflater();
        if(v.getId()==R.id.but1){
            menu.setHeaderTitle("배경색 변경");
            //menu.setHeaderIcon(R.drawable.icon1);
            menuInflater.inflate(R.menu.menu1,menu);
        }
        if(v.getId()==R.id.but2)
            menuInflater.inflate(R.menu.menu2,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
       super.onContextItemSelected(item);
        switch(item.getItemId()){
            case R.id.menu1_item_blue:
                linear.setBackgroundColor(Color.rgb(30,50,180));
                return true;
            case R.id.menu1_item_pink:
                linear.setBackgroundColor(Color.rgb(255,180,180));
                return true;
            case R.id.menu1_item_yellow:
                linear.setBackgroundColor(Color.rgb(250,180,45));
                return true;
            case R.id.menu2_item_rotation:
                img.setRotation(img.getRotation()+90);
                return true;
            case R.id.menu2_item_size:
                img.setScaleX(img.getScaleX()*1.5f);
                img.setScaleY(img.getScaleY()*1.5f);
                return true;
        }
        return false;
    }
}
