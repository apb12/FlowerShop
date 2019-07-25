package com.accenture.flowershop.be.business;

import com.accenture.flowershop.fe.dto.UserDTO;
import com.accenture.flowershop.test.XMLConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;

@Service
public class UserMarshgallingServiceImpl implements UserMarshgallingService {

    @Value("${filepath}")
    private String XML_FILE_NAME;
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void UserToXml(String login, String password, String username, String email) throws IOException {
        XMLConverter converter = (XMLConverter) applicationContext.getBean("XMLConverter");
        UserDTO userDTO = new UserDTO();
        userDTO.setLogin(login);
        userDTO.setPassword(password);
        userDTO.setUsername(username);
        userDTO.setEmail(email);
        userDTO.setBalance(new BigDecimal(2000));
        userDTO.setDiscount(10);
        converter.convertFromObjectToXML(userDTO, XML_FILE_NAME);
    }
}
