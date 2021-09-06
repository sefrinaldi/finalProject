package com.sefrinaldi.finaljavabe.database.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import com.sefrinaldi.finaljavabe.database.service.MyBatisService;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class Receive {

    private ConnectionFactory factory;
    private Connection connection;
    private Channel channel;
    MyBatisService myBatisService = new MyBatisService();

    public void connectRabbitMQ() throws IOException, TimeoutException {
        factory = new ConnectionFactory();
        factory.setHost("localhost");
        connection = factory.newConnection();
    }

    public void registerUser() {
        try {
            connectRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("registerUser", false, false, false, null);
            //System.out.println(" [*] Waiting for messages..");
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String regisData = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + regisData + "'");
                myBatisService.registerUser(regisData);
            };
            channel.basicConsume("registerUser", true, deliverCallback, consumerTag -> { });
        } catch (Exception e) {
            e.printStackTrace();
        }
        delay();
    }

    public void loginUser() {

        try {
            connectRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("loginUser", false, false, false, null);
            //System.out.println(" [*] Waiting for messages..");
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String loginData = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + loginData + "'");
                myBatisService.loginUser(loginData);
            };
            channel.basicConsume("loginUser", true, deliverCallback, consumerTag -> { });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public void cekDataInvoice() {
//
//        try {
//            connectRabbitMQ();
//            channel = connection.createChannel();
//            channel.queueDeclare("cekInvoice", false, false, false, null);
//            //System.out.println(" [*] Waiting for messages..");
//            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
//                String dataInvoice = new String(delivery.getBody(), StandardCharsets.UTF_8);
//                System.out.println(" [x] Received '" + dataInvoice + "'");
//                myBatisService.cekInvoice(dataInvoice);
//            };
//            channel.basicConsume("cekInvoice", true, deliverCallback, consumerTag -> { });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public void forgotPassword() {
        try {
            connectRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("forgotPass", false, false, false, null);
            //System.out.println(" [*] Waiting for messages..");
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String dataUser = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + dataUser + "'");
                myBatisService.forgotPassword(dataUser);
            };
            channel.basicConsume("forgotPass", true, deliverCallback, consumerTag -> { });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void delay() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException _ignored) {
            Thread.currentThread().interrupt();
        }
    }
}
