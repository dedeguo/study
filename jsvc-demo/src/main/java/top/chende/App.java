package top.chende;

import top.chende.service.JsvcCallService;

import java.util.Date;


public class App 
{


    public void init(String[] arguments){

    }
    public void start(){

        System.out.println("jsvc started");

        while(true){
            try {
                Thread.sleep(2*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(JsvcCallService.sayHello());
        }

    }
    public void stop(){
        System.out.println("jsvc stop");
    }
    public void destroy(){
        System.out.println("jsvc destroy");
    }

}
