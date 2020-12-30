package com.example.advancetopics.Json_parsing;

public class Pixabay_model {
    String imageurl,creator;
    int likes;

    public String getImageurl() {
        return imageurl;
    }

    public String getCreator() {
        return creator;
    }

    public int getLikes() {
        return likes;
    }

    public Pixabay_model(String imageurl, String creator, int likes) {
        this.imageurl = imageurl;
        this.creator = creator;
        this.likes = likes;
    }
}
