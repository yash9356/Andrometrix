package com.example.andrometrixlite.Courses;

public class DataModel {

    private String title;
    private int pic;

    public DataModel(String title,int pic) {
        this.title = title;
        this.pic =pic;
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
}
