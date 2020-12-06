package top.chende.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsvcCallService {

    public static  String sayHello(){
        String s=null;
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        s=simpleDateFormat.format(date);
        return s;
    }
}
