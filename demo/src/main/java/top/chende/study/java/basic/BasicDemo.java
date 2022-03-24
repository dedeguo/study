package top.chende.study.java.basic;

import java.util.Optional;

public class BasicDemo {

    public static void main(String[] args) {

        Integer a= new Integer(1); Integer b= new Integer(1);
        System.out.println(a==b);
        String tes="1231";
        Optional<String> optional = Optional.of(tes);
    }
}
