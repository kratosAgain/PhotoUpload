package com.app.gaurav.photoupload;

/**
 * Created by gaurav on 14/03/16.
 */
public class SqlEntry {

    private String Name="";
    private String ImageFileName = "";
    private String groupName = "";

    public SqlEntry(String name,String imageFileName,String groupName){
        this.Name = name;
        this.ImageFileName = imageFileName;
        this.groupName = groupName;
    }

    public String getName(){
        return this.Name;
    }
    public String getImage(){
        return this.ImageFileName;
    }
    public String getGroup(){
        return this.groupName;
    }
}
