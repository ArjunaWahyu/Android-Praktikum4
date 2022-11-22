package com.example.praktikum4;

public class Movie {
    private String title;
    private String description;
    private int posterImage;


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPosterImage() {
        return posterImage;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPosterImage(int posterImage) {
        this.posterImage = posterImage;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", posterImage=" + posterImage +
                '}';
    }
}