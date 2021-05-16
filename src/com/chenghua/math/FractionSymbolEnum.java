package com.chenghua.math;

public enum FractionSymbolEnum {

    POSITIVE((byte) 1, "正数"),
    NEGATIVE((byte) -1, "负数");

    private byte code;
    private String desc;

    public byte getCode() {
        return code;
    }

    public void setCode(byte code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    FractionSymbolEnum(byte code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
