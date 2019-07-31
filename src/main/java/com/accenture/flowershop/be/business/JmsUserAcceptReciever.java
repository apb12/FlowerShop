package com.accenture.flowershop.be.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.jms.*;

@Service
public class JmsUserAcceptReciever {


    private static final Logger log = LoggerFactory.getLogger("resources/logback.xml");

    @Autowired
    private ConnectionFactory connectionFactory;
    @Autowired
    private Queue userQueue;

    Connection connection;
    Session session;

    @PostConstruct
    public void init() throws JMSException {
        connection = connectionFactory.createConnection();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        MessageConsumer consumer = session.createConsumer(userQueue);
        connection.start();
        consumer.setMessageListener(
                new MessageListener() {
                    public void onMessage(Message message) {

                        try {
                            String text = message.getStringProperty("login");
                            boolean b = message.getBooleanProperty("accepted");
                            log.info("Получено сообщение от jms provider Login =:{}", text);
                            log.info("Получено сообщение от jms provider Accepted =:{}", b);
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }
                    }
                });

    }
}