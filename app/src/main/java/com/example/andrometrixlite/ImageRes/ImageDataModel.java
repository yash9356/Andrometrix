package com.example.andrometrixlite.ImageRes;

public class ImageDataModel {

    private String title;
    private int pic;
    private String info;
    private float rating;


    public ImageDataModel(String title, int pic,String info,float rating) {
        this.title = title;
        this.pic =pic;
        this.info=info;
        this.rating=rating;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
