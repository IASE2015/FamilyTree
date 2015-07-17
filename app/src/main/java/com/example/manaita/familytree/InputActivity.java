package com.example.manaita.familytree;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;


public class InputActivity extends Activity {
    public final static String P_DATA = "com.example.manaita.familytree.PERSON";
    //public final static String
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
        EditText num = (EditText)findViewById(R.id.order);


        String fName = fN.getText().toString();
        String name = n.getText().toString();
        String parent = p.getText().toString();
        String ord = num.getText().toString();
        Integer order = new Integer(ord);


        DatePicker datePicker = (DatePicker)findViewById(R.id.birth);
        int year = datePicker.getYear();
        int month = datePicker.getMonth();
        int day = datePicker.getDayOfMonth();

        RadioGroup genderGroup = (RadioGroup)findViewById(R.id.gender_select);
        boolean isMale=true;
        if(genderGroup.getCheckedRadioButtonId()==R.id.male){
            isMale=true;
        }

        FamilyDBHelper fam = new FamilyDBHelper(this);
        SQLiteDatabase db = fam.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("family",fName);

        Data data = new Data(fName,name,parent,order,year,month,day,isMale);
        intent.putExtra(P_DATA, data);
        startActivity(intent);
    }
    void saveData(){

    }
}
