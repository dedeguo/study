package top.chende.collection;

import java.io.IOException;
import java.util.ArrayList;

public class CollectionDemo {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list=new ArrayList<String>();

        for(int i=0;i<10;i++){
            list.add(""+i);
        }
        for (int i=0;i<list.size();i++){
            if (list.get(i).equals("5")){
                list.remove(i);
            }
        }
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

    }

}
