package com.sefrinaldi.finaljavabe.restapi.rabbitmq;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import com.sefrinaldi.finaljavabe.database.model.User;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RestApiReceive {

    User user = null;
    public String msg = "";

    public void receiveFromDatabase() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare("messageFromDatabase", false, false, false, null);
        System.out.println(" [*] Waiting for messages from database");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
        };
        channel.basicConsume("messageFromDatabase", true, deliverCallback, consumerTag -> { });
    }

    public String returnFromDatabase() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();


        channel.queueDeclare("messageFromDatabase", false, false, false, null);
        System.out.println(" [*] Waiting for messages from database");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
            try{
                if(message.equals("success")){
                    msg = "success";
                }else{
                    msg = "error";
                }
            }catch (Exception e){
                e.printStackTrace();
            } finally {
                System.out.println("[x] Done");
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
            }

        };

        channel.basicConsume("messageFromDatabase", true, deliverCallback, consumerTag -> { });
        delay();
        return msg;
    }

    private static void delay() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException _ignored) {
            Thread.currentThread().interrupt();
        }
    }
}
