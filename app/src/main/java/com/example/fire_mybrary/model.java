package com.example.fire_mybrary;

public class model {
    String genre,des,title,image;
    model(){

    }

    public model(String genre, String des, String title, String image) {
        this.genre = genre;
        this.des = des;
        this.title = title;
        this.image = image;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
