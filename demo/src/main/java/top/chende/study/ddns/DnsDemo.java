package top.chende.study.ddns;

public class DnsDemo {

    public static void main(String[] args) {
        DDNS ddns=new DDNS();
        System.out.println(ddns.getCurrentHostIP());
    }
}
