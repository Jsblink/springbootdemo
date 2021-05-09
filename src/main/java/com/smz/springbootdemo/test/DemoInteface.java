package com.smz.springbootdemo.test;

public interface DemoInteface {
    void test1();
    default void test2(){};
}
