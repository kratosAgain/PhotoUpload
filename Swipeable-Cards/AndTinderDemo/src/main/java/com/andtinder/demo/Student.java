package com.andtinder.demo;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.andtinder.model.CardModel;

/**
 * Created by palashg on 15/3/16.
 */

//Stores student name, id and Picture to be displayed
public class Student {
    private String name, id;
    private Drawable picture;

    public Student(String name, String id, Drawable picture) {
        this.name = name;
        this.id = id;
        this.picture = picture;
    }

    public String getId() {
        return id;
    }

    public Drawable getPicture() {
        return picture;
    }

    public String getName() {

        return name;
    }
}
