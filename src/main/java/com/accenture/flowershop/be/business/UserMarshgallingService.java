package com.accenture.flowershop.be.business;

import java.io.IOException;

public interface UserMarshgallingService {
     void UserToXml(String login) throws IOException;
     Object xmlToUser(String textXml);
}
