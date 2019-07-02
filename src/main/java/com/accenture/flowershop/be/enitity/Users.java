package com.accenture.flowershop.be.enitity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Users implements Serializable {

    @Id
    private String login;
    private String password;
    private String username;
    private String email;
    private BigDecimal balance;
    private Integer discount;


    public Users() {
    }

    public Users(String login, String password, String username, String email, BigDecimal balance, Integer discount) {
        this.login = login;
        this.password = password;
        this.username = username;
        this.email = email;
        this.balance = balance;
        this.discount = discount;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }
}
