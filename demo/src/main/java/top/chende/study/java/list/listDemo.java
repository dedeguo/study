package top.chende.study.java.list;

import java.util.ArrayList;
import java.util.List;

public class listDemo {

    public static void main(String[] args) {
        List<String> list=new ArrayList<>(0);
//DEFAULTCAPACITY_EMPTY_ELEMENTDATA
        list.add("1");
        list.add("1");
        Object[] a = {};
        Object[] b = {};
        System.out.println(a==b);
    }
}
