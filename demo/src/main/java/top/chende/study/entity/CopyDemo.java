package top.chende.study.entity;

public class CopyDemo {
    public static void main(String[] args) {

        //c2 9c 55 5c 4f
        int data=Integer.parseInt("559c",16);


        int y = (data >> 9) & 0x7f ;
        int m = (data >> 5) & 0x0f;
        int d = data & 0x1f;
        System.out.println(y+1980);
        System.out.println(m);
        System.out.println(d);


        Integer l=1644+32;
        System.out.println(Integer.toHexString(l));
        System.out.println(Integer.toHexString(data));
    }


}
