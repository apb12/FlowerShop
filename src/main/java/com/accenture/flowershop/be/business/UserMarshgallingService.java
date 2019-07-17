package com.accenture.flowershop.be.business;

import java.io.IOException;
import java.math.BigDecimal;

public interface UserMarshgallingService {
     void UserToXml(String login, String password, String username, String email) throws IOException;
}
