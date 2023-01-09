package com.template.entity;

public class TUser {
    private int uId;
    private String uName;
    private int uAge;
    private int uSex;

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public int getuAge() {
        return uAge;
    }

    public void setuAge(int uAge) {
        this.uAge = uAge;
    }

    public int getuSex() {
        return uSex;
    }

    public void setuSex(int uSex) {
        this.uSex = uSex;
    }

    @Override
    public String toString() {
        return "TUser{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uAge=" + uAge +
                ", uSex=" + uSex +
                '}';
    }
}
