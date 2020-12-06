package top.chende.springboot;


import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTempTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;

@RestController
public class ProducerController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @RequestMapping(value = "/order")
    public void pubMsg(String msg){
        Destination destination=new ActiveMQQueue("order.queue");
        jmsMessagingTemplate.convertAndSend(destination,msg);
    }
}
