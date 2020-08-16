package top.chende.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class StudyApplication {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }

    public static void main(String[] args) {
        SpringApplication.run(StudyApplication.class, args);
    }

}
