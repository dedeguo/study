package cn.dedeguo.util;

import java.util.Arrays;

public class StringDemo {
    public static void main(String[] args) {
        final int x=0;
        //x=123;
        final int[] intArr=new int[]{1,2,3};
        intArr[2]=5;
        Arrays.stream(intArr).forEach(System.out::println);

        String a1="1111";
        System.out.println(a1.hashCode());

        a1="23242";
        System.out.println(a1.hashCode());
    }
}
