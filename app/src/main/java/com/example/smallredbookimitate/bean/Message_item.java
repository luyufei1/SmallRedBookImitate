package com.example.smallredbookimitate.bean;

public class Message_item {

    private int imageId;
    private String title;
    private String content;
    private String time;

    public Message_item(int imageId, String title, String content, String time) {
        this.imageId = imageId;
        this.title = title;
        this.content = content;
        this.time = time;
    }

    public int getImageId() {
        return imageId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getTime() {
        return time;
    }
}
