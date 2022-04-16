package com.example.andrometrixlite.Learning;

public class InstructionDataModel {

    private String title;
    private Boolean check;

    public InstructionDataModel(String title, boolean check) {
        this.title = title;
        this.check =check;
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }

    public String getInstruction() {
        return title;
    }

    public void setInstruction(String title) {
        this.title = title;
    }
}
