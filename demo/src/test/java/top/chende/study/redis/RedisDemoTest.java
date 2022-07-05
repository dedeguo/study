package top.chende.study.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import top.chende.study.entity.People;

import javax.annotation.Resource;
import java.io.Serializable;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisDemoTest {

    @Autowired
    private RedisTemplate<String, String> strRedisTemplate;
//    @Resource
//    private RedisTemplate<String, Serializable> serializableRedisTemplate;

    @Test
    public void testString() {
        strRedisTemplate.opsForValue().set("strKey", "zwqh");
        System.out.println(strRedisTemplate.opsForValue().get("strKey"));
    }
//
//    @Test
//    public void testSerializable() {
//        People user=new People();
//        user.setId("1L");
//        user.setName("朝雾轻寒");
//        user.setAge("男");
//        serializableRedisTemplate.opsForValue().set("user", user);
//        People user2 = (People) serializableRedisTemplate.opsForValue().get("user");
//        System.out.println("user:"+user2.getId()+","+user2.getName()+","+user2.getAge());
//    }


}