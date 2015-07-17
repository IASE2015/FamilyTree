package com.example.manaita.familytree;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.ViewGroup;




public class AddActivity extends Activity implements View.OnClickListener {
    private GestureDetector gestDetect;
    public final static String P_ISFATHER = "com.example.manaita.familytree.ISFATHER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        //gestDetect = new GestureDetector(this,new MySimpleOnGestureListener());

        RelativeLayout fam = new RelativeLayout(this);
        Intent intent = getIntent();
        Data data = (Data)intent.getSerializableExtra(DisplayActivity.P_INFO);
        TextView main = new TextView(this);
        main.setText(data.getFName()+" "+data.getName());
        fam.addView(main);
        //setContentView(fam);

        ViewGroup famtree = (ViewGroup)findViewById(R.id.family_tree);

        int f = 0;

        Button add = (Button)findViewById(R.id.add);
        add.setOnClickListener(this);
        Button mAdd = (Button)findViewById(R.id.mother);
        mAdd.setOnClickListener(this);
        Button fAdd = (Button)findViewById(R.id.father);
        fAdd.setOnClickListener(this);

        Button info = (Button)findViewById(R.id.hero);
        //add.setOnClickListener(this);

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

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this,InputActivity.class);
        int f=0;
        int k = view.getId();
        if(k==R.id.father)
            intent.putExtra(P_ISFATHER, 0);
        if(k==R.id.mother)
            intent.putExtra(P_ISFATHER, 1);
        startActivity(intent);
    }
    public void createFather(View view) {
        Intent intent = new Intent(this,AnotherFamilyActivity.class);
        intent.putExtra(P_ISFATHER,0);
        startActivity(intent);
    }
    public void createMother(View view) {
        Intent intent = new Intent(this,AnotherFamilyActivity.class);
        intent.putExtra(P_ISFATHER,1);
        startActivity(intent);
    }
    public void infoPerson(View view){
        Intent intent = new Intent(this,DisplayActivity.class);
        startActivity(intent);
    }
}
