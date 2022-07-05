package top.chende.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.chende.study.entity.People;

import javax.annotation.Resource;
import java.util.*;

@SpringBootApplication
@RestController
public class App 
{

    @Resource
    private RedisTemplate<String, People> redisTemplate;
    /**
     * main interface.
     *
     * @param args args
     */
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


    /**
     * @param user user param
     * @return user
     */
    @PostMapping("add")
    public ResponseEntity<People> add(@RequestBody People user) {
        redisTemplate.opsForValue().set(String.valueOf(user.getId()), user);
        Map<String,String> map=new HashMap<>();
        map.put("hl","asa");
        redisTemplate.opsForHash().putAll("testHash",map);
        return new ResponseEntity(redisTemplate.opsForValue().get(String.valueOf(user.getId())),HttpStatus.OK);
    }

    /**
     * @return user list
     */
    @GetMapping("find/{userId}")
    public ResponseEntity<People> edit(@PathVariable("userId") String userId) {
        return new ResponseEntity(redisTemplate.opsForValue().get(userId),HttpStatus.OK);
    }


    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("hello world", HttpStatus.OK);
    }


    public void baseTest(){

        redisTemplate.opsForValue(); // 操作字符串
        redisTemplate.opsForHash(); // 操作hash
        redisTemplate.opsForList(); // 操作list
        redisTemplate.opsForSet(); // 操作set
        redisTemplate.opsForZSet(); // 操作zset
        redisTemplate.opsForHyperLogLog();
        redisTemplate.opsForGeo();



    }
}
