package com.example.manaita.familytree;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import android.util.Log;

/**
 * Created by tazio on 2015/07/02.
 */


public class Data implements Serializable {
    private String fName;
    private String name;
    private String parent;
    private int order;
    private int year;
    private int month;
    private int day;
    private boolean gender;
    private boolean isAdopted;



    public Data(String fName, String name, String parent,int order,int year,int month,int day){
        this.fName = fName;
        this.name = name;
        this.parent = parent;
        this.order = order;
        this.year = year;
        this.month = month;
        this.day = day;
        this.gender = gender;
    }

    public String getFName() { return fName; }
    public String getName(){ return name; }
    public String getParent(){ return parent; }
    public int getNumber(){ return order; }
    public int getYear(){ return year; }
    public int getMonth(){ return month; }
    public int getDay(){ return day; }
    public boolean male(){ return gender; }
    public boolean isAdopted(){ return isAdopted; }


    public void setFName(String fName){ this.fName = fName; }
    public void setName(String name){ this.name = name; }
    public void setParent(String parent){ this.parent = parent; }
    public void setNumber(int order){ this.order = order; }
    public void setYear(int year){ this.year = year; }
    public void setMonth(int month){ this.month = month; }
    public void setDay(int day){ this.day = day; }
    public void setMale(boolean male){ this.gender = male; }
    public void setAdopted(boolean isAdopted){ this.isAdopted = isAdopted; }
    /*public String setBirthday(){

    }
    public String getBirthday(){

    }*/
    public int getNowYear(){
        SimpleDateFormat sdfY = new SimpleDateFormat("yyyy");
        Calendar cal = Calendar.getInstance();
        String nowYear = sdfY.format(cal.getTime());
        int y = Integer.valueOf(nowYear);
        return y;
    }
    public int getAge(){
        Calendar cal = Calendar.getInstance();
        Calendar c = Calendar.getInstance();
        cal.set(year,month,day);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        int now = Integer.parseInt(sdf.format(c.getTime()));
        int b = Integer.parseInt(sdf.format(cal.getTime()));
        int age = (now-b)/10000;
        return age;
    }
    public String getBirth(){
        String birth = ""+year+month+day;
        return birth;
    }
}
