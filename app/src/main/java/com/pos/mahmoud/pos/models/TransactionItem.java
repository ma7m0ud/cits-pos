package com.pos.mahmoud.pos.models;

public class TransactionItem{
    private int name;
    private int color;
    private int type;
    private String path;
    private int printName;
    public TransactionItem(int name, int color,int type,String path) {
        this.name = name;
        this.color = color;
        this.type=type;
        this.path=path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
