package com.accenture.flowershop.be.business;

import com.accenture.flowershop.fe.dto.UserDTO;
import com.accenture.flowershop.test.XMLConverter;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserMarshgallingServiceImpl implements UserMarshgallingService {

    @Value("${filepath}")
    private String XML_FILE_NAME;
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    Mapper mapper;
    @Autowired
    UserService userService;

    @Override
    public void UserToXml(String login) throws IOException {
        XMLConverter converter = (XMLConverter) applicationContext.getBean("XMLConverter");
        converter.convertFromObjectToXML(mapper.map(userService.getUserByLogin(login), UserDTO.class), XML_FILE_NAME);
    }

    @Override
    public Object xmlToUser(String textXml) {
        XMLConverter converter = (XMLConverter) applicationContext.getBean("XMLConverter");
        try {
            return converter.convertFromXMLToObject(textXml);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
