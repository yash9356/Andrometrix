package com.example.andrometrixlite.SampleCode;

public class CodeDataModel {

    private String title;
    private int pic;

    public CodeDataModel(String title, int pic) {
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
