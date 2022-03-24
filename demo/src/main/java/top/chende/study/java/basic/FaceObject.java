package top.chende.study.java.basic;

/**
 * 面向对象
 *
 * 无论是Effective Java，还是阿里巴巴Java规范手册都是要求重写equals，必须重写hashCode。
 * 两个相等的对象必须具有相等的散列码（Java关键约定）
 */
public class FaceObject {

    public static void main(String[] args) {
        final StringBuilder sb = new StringBuilder("abc");
        sb.append("d");
        System.out.println(sb);  //abcd
        //sb=new StringBuilder("211"); 编译不通过
        String a="1234";
        Integer.parseInt(a);
        String c=new String("1234");
        String b=c;
        c=c.intern();
        System.out.println(b==c);
    }

}
