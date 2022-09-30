package com.oro.taxi.chofer.model;

import android.graphics.drawable.Drawable;

/**
 * Created by Woumtana on 01/12/2016.
 */

public class LanguagePojo {
    private int id;
    private String name;
    private Drawable image;
    private String status;

    public LanguagePojo(int id, String name, Drawable image, String status) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}