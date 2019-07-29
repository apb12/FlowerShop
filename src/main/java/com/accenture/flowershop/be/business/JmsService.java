package com.accenture.flowershop.be.business;

import com.accenture.flowershop.fe.dto.UserDTO;
import com.accenture.flowershop.test.XMLConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jms.*;

@Service
public class JmsService {

    @Autowired
    private ConnectionFactory connectionFactory;
    @Autowired
    private Queue sendNewUsersXmlQueue;
    @Autowired
    private XMLConverter xmlConverter;

    Connection connection;
    Session session;

    public void setSendNewUsers(UserDTO users) throws Exception {
        connection = connectionFactory.createConnection();
        TextMessage message;
        connection.start();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        message = session.createTextMessage(xmlConverter.convertFromObjectToString(users));
        MessageProducer producer = session.createProducer(sendNewUsersXmlQueue);
        producer.send(message);
        producer.close();
    }
}
