package com.example.manaita.familytree;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.view.ViewGroup;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import android.widget.LinearLayout;
import android.util.Log;

public class DisplayActivity extends Activity {
    private final int W = ViewGroup.LayoutParams.WRAP_CONTENT;
    public final static String P_INFO = "com.example.manaita.familytree.P_INFO";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        /*Intent intent = getIntent();
        Data data = (Data)intent.getSerializableExtra(InputActivity.P_DATA);*/
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(W,W);

        LinearLayout pInfo = (LinearLayout)findViewById(R.id.vGroup);
        Intent intent = getIntent();
        Data data = (Data)intent.getSerializableExtra(InputActivity.P_DATA);

        TextView fName = new TextView(this);
        TextView name = new TextView(this);
        TextView pName = new TextView(this);
        TextView number = new TextView(this);
        fName.setTextSize(40);
        fName.setText(data.getFName());
        name.setTextSize(40);
        name.setText(data.getName());
        pName.setTextSize(40);
        pName.setText(data.getParent());
        number.setTextSize(40);
        number.setText(String.valueOf(data.getNumber()));
        TextView bir = new TextView(this);
        bir.setTextSize(40);
        bir.setText(data.getBirth());


        TextView age = new TextView(this);
        age.setTextSize(40);
        Integer bi  = Integer.valueOf(data.getAge());
        age.setText(String.valueOf(bi));



        pInfo.addView(fName, lp);
        pInfo.addView(name,lp);
        pInfo.addView(pName,lp);
        pInfo.addView(number,lp);
        pInfo.addView(bir,lp);
        pInfo.addView(age,lp);

        //fam.addView(pInfo);
        //setContentView(pInfo);

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
    public int getNowMD(){
        SimpleDateFormat sdfD = new SimpleDateFormat("MMdd");
        Calendar cal = Calendar.getInstance();
        String nowMD= sdfD.format(cal.getTime());
        int md = Integer.valueOf(nowMD);
        return md;
    }
    private LinearLayout.LayoutParams createParam(int w,int h){
        return new LinearLayout.LayoutParams(w,h);
    }
    public void toAddActivity(View view){
        Intent intent = getIntent();
        Data data = (Data)intent.getSerializableExtra(InputActivity.P_DATA);
        Intent i = new Intent(this,AddActivity.class);
        i.putExtra(P_INFO, data);
        startActivity(i);

    }
}
