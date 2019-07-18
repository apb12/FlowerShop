package com.accenture.flowershop.ws;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface FlowerStockWebService {
    @WebMethod
    void increaseFlowerStockSize(@WebParam(name = "count") long count);
}
