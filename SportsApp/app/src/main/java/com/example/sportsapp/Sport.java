package com.example.sportsapp;

public class Sport {
    private int imageId;
    private String text;

    public Sport(int imageId, String text) {
        this.imageId = imageId;
        this.text = text;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImageId() {
        return imageId;
    }

    public String getText() {
        return text;
    }
}
