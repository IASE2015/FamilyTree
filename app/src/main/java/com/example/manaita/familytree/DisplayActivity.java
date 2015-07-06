package com.example.manaita.familytree;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.view.ViewGroup;
import java.text.SimpleDateFormat;
//import java.time.LocalDate;

public class DisplayActivity extends Activity {
    int y,m,d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Intent intent = getIntent();
        Data data = (Data)intent.getSerializableExtra(InputActivity.EXTRA_MESSAGE);
        // ViewGroup p = new ViewGroup();



        TextView fName = new TextView(this);
        TextView name = new TextView(this);
        fName.setTextSize(40);
        fName.setText(data.getFName());
        name.setTextSize(20);
        name.setText(data.getName());


        TextView b = new TextView(this);
        b.setTextSize(20);
        int age=0;
        if(data.getMonth()<=data.getNowMonth() && data.getDay()<=data.getNowDay()){
            age=data.getAge()+1;
        }
        Integer bi  = new Integer(age);
        String bit = bi.toString();
        b.setText(bit);


        //setContentView(R.id.container);

        setContentView(b);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
