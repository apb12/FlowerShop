package com.accenture.flowershop.be.business;

import com.accenture.flowershop.fe.dto.UserDTO;
import com.accenture.flowershop.test.XMLConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.jms.*;
import java.io.IOException;

@Service
public class JmsReciever {

    @Autowired
    private ConnectionFactory connectionFactory;
    @Autowired
    private Queue receiveUserDiscountXmlQueue;
    @Autowired
    private XMLConverter xmlConverter;
    @Autowired
    private UserService userService;

    Connection connection;
    Session session;

    @PostConstruct
    public void init() throws JMSException {
        connection = connectionFactory.createConnection();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        MessageConsumer consumer = session.createConsumer(receiveUserDiscountXmlQueue);
        connection.start();
        consumer.setMessageListener(
                new MessageListener() {
                    public void onMessage(Message message) {

                        try {
                            String text = ((TextMessage) message).getText();
                            UserDTO user = (UserDTO) xmlConverter.convertFromXMLToObject(text);
                            userService.userDiscountUpdate(user.getLogin(), user.getDiscount());
                        } catch (JMSException | IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

    }
}
