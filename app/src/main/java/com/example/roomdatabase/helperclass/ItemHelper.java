package com.example.roomdatabase.helperclass;

public class ItemHelper {
    private int color;
    private int image;
    private String title;

    public ItemHelper(int color, int image, String title) {
        this.color = color;
        this.image = image;
        this.title = title;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
