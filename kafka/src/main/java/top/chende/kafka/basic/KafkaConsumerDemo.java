package top.chende.kafka.basic;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Arrays;
import java.util.Properties;

import static org.apache.kafka.common.requests.DeleteAclsResponse.log;

public class KafkaConsumerDemo {
    String ip="192.168.0.107";
    public static void main(String[] args) {

        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.0.107:9092");
        props.put("group.id", "GROUPID");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("max.poll.records", 1000);
//        props.put("auto.offset.reset", "earliest");
        props.put("key.deserializer", StringDeserializer.class.getName());
        props.put("value.deserializer", StringDeserializer.class.getName());
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Arrays.asList("test"));

        // 100 是超时时间（ms），在该时间内 poll 会等待服务器返回数据
      //  ConsumerReccords<String, String> records = consumer.poll(100);

        // poll 返回一个记录列表。
        // 每条记录都包含了记录所属主题的信息、记录所在分区的信息、记录在分区里的偏移量，以及记录的键值对。
//        for (ConsumerReccord<String, String> record : records) {
//            log.debug("topic=%s, partition=%s, offset=%d, customer=%s, country=%s",
//                    record.topic(), record.partition(), record.offset(),
//                    record.key(), record.value());
//        }
        while(true){
            ConsumerRecords<String, String> records = consumer.poll(10000);
            for (ConsumerRecord<String, String> record : records) {
                log.debug("topic=%s, partition=%s, offset=%d, customer=%s, country=%s",
                        record.topic(), record.partition(), record.offset(),
                        record.key(), record.value());
              //  System.out.println("rec ======"+record.value());
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
            }
          //  System.out.println("ok");
        }


    }
}
