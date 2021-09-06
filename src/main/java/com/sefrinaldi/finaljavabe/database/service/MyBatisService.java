package com.sefrinaldi.finaljavabe.database.service;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.sefrinaldi.finaljavabe.database.model.User;
import com.sefrinaldi.finaljavabe.database.rabbitmq.Send;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.concurrent.TimeoutException;

public class MyBatisService {

    SqlSession session;
    Send send = new Send();

    public void connectMyBatis() throws IOException {
        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        session = sqlSessionFactory.openSession();
    }

    public void registerUser(String regisUser) {

        User user = new Gson().fromJson(regisUser, User.class);
        User dataUser = null;
        try {
            connectMyBatis();

            dataUser = session.selectOne("User.getByEmail", user);

            if (dataUser == null) {
                session.insert("User.insertUser", user);
                send.sendToRestApi("success");
                session.commit();
                session.close();
            } else  {
                send.sendToRestApi("error");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loginUser(String dataUser) {
        User user = new Gson().fromJson(dataUser, User.class);

//        String email = user.getEmail();
//        String pass = user.getPassword();
        try {
            connectMyBatis();
            User user2 = session.selectOne("User.getByEmailPass", user);
            if (user2 != null) {
                send.sendToRestApi("Selamat Datang " + user2.getFirstName());
            }
            else {
                send.sendToRestApi("Login Gagal");
            }

            session.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void forgotPassword(String dataUser) {
//        System.out.println(dataUser);
        User user = new Gson().fromJson(dataUser, User.class);

        try {
            connectMyBatis();
            User user1 = session.selectOne("User.getByEmail", user);

            if (user1 != null) {
                send.sendToRestApi(new Gson().toJson(user1));
            }
            else {
                send.sendToRestApi("Id not found");
            }

            session.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
