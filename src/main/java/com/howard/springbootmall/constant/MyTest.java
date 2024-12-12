package com.howard.springbootmall.constant;

public class MyTest {
    public static void main(String[] args) {
        ProductCategory productCategory = ProductCategory.FOOD;
        String s = productCategory.name();
        System.out.println(s);

        String s1 = "CAR";
        ProductCategory productCategory1 = ProductCategory.valueOf(s1);
    }
}
