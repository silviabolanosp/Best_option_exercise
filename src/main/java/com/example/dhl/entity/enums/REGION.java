package com.example.dhl.entity.enums;

public enum REGION {
    NEY_YORK("New York"), INDIA("India"), CHINA("China");
    public final String name;
    private REGION(String name){
        this.name = name;
    }
}
