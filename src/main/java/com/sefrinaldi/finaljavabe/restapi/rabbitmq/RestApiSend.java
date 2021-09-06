package com.sefrinaldi.finaljavabe.restapi.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

public class RestApiSend {

    public void registerUser(String userData) {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try(Connection connection = factory.newConnection();
            Channel channel = connection.createChannel()) {
            channel.queueDeclare("registerUser", false, false, false, null);

            channel.basicPublish("", "registerUser", null, userData.getBytes(StandardCharsets.UTF_8));
            System.out.println("Sent : '" + userData + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loginUser(String userlogin) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try(Connection connection = factory.newConnection();
            Channel channel = connection.createChannel()) {
            channel.queueDeclare("loginUser", false, false, false, null);

            channel.basicPublish("", "loginUser", null, userlogin.getBytes(StandardCharsets.UTF_8));
            System.out.println("Sent : '" + userlogin + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cekInvoice(String dataInvoice) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try(Connection connection = factory.newConnection();
            Channel channel = connection.createChannel()) {
            channel.queueDeclare("cekInvoice", false, false, false, null);

            channel.basicPublish("", "cekInvoice", null, dataInvoice.getBytes(StandardCharsets.UTF_8));
            System.out.println("Sent : '" + dataInvoice + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void forgotPass(String dataUser) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try(Connection connection = factory.newConnection();
            Channel channel = connection.createChannel()) {
            channel.queueDeclare("forgotPass", false, false, false, null);

            channel.basicPublish("", "forgotPass", null, dataUser.getBytes(StandardCharsets.UTF_8));
            System.out.println("Sent : '" + dataUser + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
