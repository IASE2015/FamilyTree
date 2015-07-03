package com.example.manaita.familytree;

import java.io.Serializable;
/**
 * Created by tazio on 2015/07/02.
 */


public class Data implements Serializable{
    private String fName;
    private String name;
    private String parent;

    public Data(String fName, String name, String parent){
        this.fName = fName;
        this.name = name;
        this.parent = parent;
    }

    public String getFName() {
        return fName;
    }
    public String getName(){
        return name;
    }
    public String getParent(){
        return parent;
    }
    public void setFName(String fName){ this.fName = fName;}

}
