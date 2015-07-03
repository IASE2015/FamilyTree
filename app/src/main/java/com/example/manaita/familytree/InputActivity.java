package com.example.manaita.familytree;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;


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
        EditText y = (EditText)findViewById(R.id.year);
        EditText m = (EditText)findViewById(R.id.month);
        EditText d = (EditText)findViewById(R.id.day);
        String fName = fN.getText().toString();
        String name = n.getText().toString();
        String parent = p.getText().toString();
        String year = y.getText().toString();
        String month = m.getText().toString();
        String day = d.getText().toString();
        Data data = new Data(fName,name,parent,Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day));
        intent.putExtra(EXTRA_MESSAGE, data);
        startActivity(intent);
    }
}
