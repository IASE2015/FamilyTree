package com.example.manaita.familytree;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.DatePicker;

public class InputActivity extends Activity {
    public final static String EXTRA_MESSAGE = "com.example.manaita.familytree.PERSON";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_input, menu);
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
    public void sendInfo(View view){
        Intent intent  = new Intent(this,DisplayActivity.class);
        EditText fN = (EditText)findViewById(R.id.fName);
        EditText n = (EditText)findViewById(R.id.name);
        EditText p = (EditText)findViewById(R.id.parent);

        String fName = fN.getText().toString();
        String name = n.getText().toString();
        String parent = p.getText().toString();

        DatePicker datePicker = (DatePicker)findViewById(R.id.birth);
        int year = datePicker.getYear();
        int month = datePicker.getMonth();
        int day = datePicker.getDayOfMonth();


        Data data = new Data(fName,name,parent,year,month,day);
        intent.putExtra(EXTRA_MESSAGE, data);
        startActivity(intent);
    }
}
