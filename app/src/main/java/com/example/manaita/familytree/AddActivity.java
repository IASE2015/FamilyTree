package com.example.manaita.familytree;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;




public class AddActivity extends Activity /*implements onTouchListener*/{
    private GestureDetector gestDetect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        gestDetect = new GestureDetector(this,new MySimpleOnGestureListener());

        RelativeLayout fam = new RelativeLayout(this);
        Intent intent = getIntent();
        Data data = (Data)intent.getSerializableExtra(DisplayActivity.P_INFO);
        TextView main = new TextView(this);
        main.setText(data.getFName()+" "+data.getName());
        fam.addView(main);
        setContentView(fam);

        ViewGroup famtree = (ViewGroup)findViewById(R.id.family_tree);

        

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add, menu);
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
    private class MySimpleOnGestureListener extends GestureDetector.SimpleOnGestureListener {

    }
}
