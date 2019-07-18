package com.accenture.flowershop.test;

import com.accenture.flowershop.ws.FlowerStockWebService;
import com.accenture.flowershop.ws.FlowerStockWebServiceImpl;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class FlowerStockWebServiceClient {
    public static void main(String[] args) throws MalformedURLException {
        URL url=new URL("http://localhost:8083/flowershop/ws/FlowerStockWebService?wsdl");
        QName qName=new QName("http://ws.flowershop.accenture.com/","FlowerStockWebServiceImplService");
        Service service =Service.create(url,qName);
        FlowerStockWebService fs=service.getPort(FlowerStockWebService.class);
        fs.increaseFlowerStockSize(100);
    }
}
