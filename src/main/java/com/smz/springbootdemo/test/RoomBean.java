package com.smz.springbootdemo.test;

public class RoomBean extends  Demo1{

    private Integer area;
    private String name;
    public final static int nums = 12;
    private static boolean flag;
    private final String fStr = "ffStr";


    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getNums() {
        return nums;
    }

    public static boolean isFlag() {
        return flag;
    }

    public static void setFlag(boolean flag) {
        RoomBean.flag = flag;
    }

    public String getfStr() {
        return fStr;
    }
}
