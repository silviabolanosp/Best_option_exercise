package com.example.dhl.entity.enums;

public enum CAPACITY {
    LARGE(10),X_LARGE(20), X2_LARGE(40), X4_LARGE(80), X8_LARGE(160), X10_LARGE(320);
    public final int units;
    private CAPACITY(int units){
        this.units = units;
    }
}
