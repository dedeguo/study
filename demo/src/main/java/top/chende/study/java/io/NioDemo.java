package top.chende.study.java.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class NioDemo {

    public static void main(String[] args) {

        writeNio();
       // readNio();
    }

    static void writeNio(){
        String filePath="/Users/chende/IdeaProjects/tech-study/demo/src/main/resources/hello.txt";

        FileOutputStream fou=null;
        try {
            fou=new FileOutputStream(new File(filePath));
            FileChannel channel = fou.getChannel();
            ByteBuffer src = Charset.forName("utf8").encode("你好你好你好你好你好");
            int len=0;
            while ((len=channel.write(src))!=0){
                System.out.println("write len "+len);
            }
            fou.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    static void readNio(){
        String filePath="/Users/chende/IdeaProjects/tech-study/demo/src/main/resources/hello.txt";

        FileInputStream fin = null;
        try {
            fin=new FileInputStream(new File(filePath));
            FileChannel channel=fin.getChannel();
            int capacity=100;
            ByteBuffer bf=ByteBuffer.allocate(capacity);
            int len=-1;
            while ( (len=channel.read(bf)) !=-1){
                bf.clear();
                System.out.write(  bf.array(),0,len);
                System.out.println();
            }
            channel.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                fin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
