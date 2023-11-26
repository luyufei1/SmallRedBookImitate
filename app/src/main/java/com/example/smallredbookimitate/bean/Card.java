package com.example.smallredbookimitate.bean;

public class Card {
    private int imageId;
    private int headId;
    private String name;

    private String title;
    private int likes;

    public Card(int imageId, int headId, String name, String title, int likes) {
        this.imageId = imageId;
        this.headId = headId;
        this.name = name;
        this.title = title;
        this.likes = likes;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public int getLikes() {
        return likes;
    }

    public int getHeadId() {
        return headId;
    }

    public String getTitle() {
        return title;
    }
}
