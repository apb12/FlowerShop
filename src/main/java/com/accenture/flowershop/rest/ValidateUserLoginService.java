package com.accenture.flowershop.rest;

import com.accenture.flowershop.be.business.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/validate_login")
@Service
public class ValidateUserLoginService {

    @Autowired
    private UserService userService;

    @GET
    @Path("/{login}")
    public boolean validate(@PathParam("login") String login) {
        return userService.loginExist(login);
    }
}
