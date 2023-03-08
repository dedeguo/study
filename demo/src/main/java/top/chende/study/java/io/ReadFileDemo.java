package top.chende.study.java.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


public class ReadFileDemo {

    public static void main(String[] args) {
        String userPostFile = "/Users/chende/IdeaProjects/tech-study/demo/src/main/resources/hello.txt";
        basicChannel(userPostFile);
    }

    public static void basicChannel(String filePath){
        try {
            FileInputStream fileInputStream=new FileInputStream(new File(filePath));
            FileChannel fileChannel = fileInputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int k = fileChannel.read(byteBuffer);
            byte[] data= byteBuffer.array();
            System.out.println(new String(data,0,k));
            fileChannel.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void basicInputStreamBytes(String filePath){
        List<Byte> byteList =new ArrayList<>();
        byte[] buf=new byte[1024];
        StringBuilder sb = new StringBuilder();
        try {
            InputStream inputStream=new FileInputStream(filePath);
            int size =inputStream.read(buf);
            System.out.println(new String(buf,0,size,"gbk"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void basicInputStream(String filePath){
        try {
            InputStream inputStream=new FileInputStream(filePath);
            StringBuilder sb = new StringBuilder();
            while (inputStream.available()>0){
                char ch = (char) inputStream.read();
                sb.append(ch);
            }

            System.out.println(sb.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void basicReadWithCharset(String filePath){
        try {
            InputStreamReader inputStreamReader =
                new InputStreamReader(new FileInputStream(new File(filePath)),"utf-8");

            StringBuilder sb = new StringBuilder();
            while (inputStreamReader.ready()){
               char ch = (char) inputStreamReader.read();
               sb.append(ch);
            }
            System.out.println(sb.toString());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static  void basicRead(String filePath){
        File file = new File(filePath);
        try {
            FileReader fileReader=new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();
            while (bufferedReader.ready()){
                String   postInfo=  bufferedReader.readLine();
                System.out.println(postInfo);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
        return   ;
    }
}
