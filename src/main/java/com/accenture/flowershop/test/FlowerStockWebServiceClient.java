package com.accenture.flowershop.test;

import com.accenture.flowershop.ws.FlowerStockWebService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class FlowerStockWebServiceClient {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        URL url = new URL("http://localhost:8083/flowershop/ws/FlowerStockWebService?wsdl");
        QName qName = new QName("http://ws.flowershop.accenture.com/", "FlowerStockWebServiceImplService");
        Service service = Service.create(url, qName);
        FlowerStockWebService fs = service.getPort(FlowerStockWebService.class);
        while (true) {
            long count = (long) (Math.random() * 20 + 10);
            fs.increaseFlowerStockSize(count);
            Thread.sleep(600000);
            System.out.println(count);
        }
    }
}
