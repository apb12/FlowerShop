package com.accenture.flowershop.be.business;

import com.accenture.flowershop.fe.dto.User;
import com.accenture.flowershop.test.XMLConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;

@Service
public class UserMarshgallingServiceImpl implements UserMarshgallingService{

    @Value("${filepath}")
    private  String XML_FILE_NAME ;
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void UserToXml(String login, String password, String username, String email) throws IOException {
        XMLConverter converter=(XMLConverter)applicationContext.getBean("XMLConverter");
        User user=new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setUsername(username);
        user.setEmail(email);
        user.setBalance(new BigDecimal(2000));
        user.setDiscount(10);
        converter.convertFromObjectToXML(user,XML_FILE_NAME);
    }
}
