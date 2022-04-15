package top.chende.study.java.io;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class IoDemo {
    public static void main(String[] args) {

        Integer i=9;
        ArrayList a;
        i.intValue();
        String filePath="/Users/chende/IdeaProjects/tech-study/demo/src/main/resources/hello.txt";

        try {
            InputStream in=new FileInputStream(new File(filePath));
            byte[] buf=new byte[1024];
            while (in.read(buf)>0){
                System.out.println(new String(buf));
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
