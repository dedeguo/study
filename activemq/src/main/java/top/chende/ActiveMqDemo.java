package top.chende;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ActiveMqDemo {

    public static void main(String[] args) throws Exception {
// 创建一个链接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                "admin",
                "admin",
                "tcp://localhost:61616");
        // 从工厂中创建一个链接
        Connection connection  = connectionFactory.createConnection();
        connection.start();
        // 创建一个事务（这里通过参数可以设置事务的级别）
        Session session = connection.createSession(true, Session.CLIENT_ACKNOWLEDGE);
        // 创建一个消息队列
        Queue queue = session.createQueue("queue1");
        // 创建生产者
        MessageProducer messageProducer = session.createProducer(queue);
        // 设置持久化特性和非持久化特性
        messageProducer.setDeliveryMode(DeliveryMode.PERSISTENT);
        // 创建数据
        TextMessage textMessage = session.createTextMessage("生产者生产2");
        messageProducer.send(textMessage);
        session.commit();
        if(connection != null) {
            connection.close();
        }

        session.close();
        connection.close();

    }
}
