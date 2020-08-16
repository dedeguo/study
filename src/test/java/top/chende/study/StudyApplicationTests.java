package top.chende.study;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.chende.study.entity.UserDO;
import top.chende.study.repository.UserRepository;

@SpringBootTest
class StudyApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testUser(){
        UserDO user=new UserDO();
        user.setId(22);
        user.setUserName("chende");
        user.setPwd("pwd");

        userRepository.save(user);
        userRepository.flush();
    }
}
