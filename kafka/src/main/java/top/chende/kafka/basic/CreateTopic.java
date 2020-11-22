package top.chende.kafka.basic;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CreateTopic {
    public static void main(String[] args) {
        Properties config = new Properties();
        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.0.107:9092");

        AdminClient admin = AdminClient.create(config);

        Map<String, String> configs = new HashMap<>();
        int partitions = 1;
        short replication = 1;

        CreateTopicsResult result = admin.createTopics(Arrays.asList(new NewTopic("test2", partitions, replication).configs(configs)));
        admin.close();
        String resultValue=JSON.toJSONString(result.values());
        System.out.println(resultValue);
    }



}
