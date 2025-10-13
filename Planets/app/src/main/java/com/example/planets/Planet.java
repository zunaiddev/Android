package com.example.planets;

public class Planet {
    private int src;
    private String label;
    private String desc;

    public Planet(int src, String label, String desc) {
        this.src = src;
        this.label = label;
        this.desc = desc;
    }

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
