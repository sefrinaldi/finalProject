package com.sefrinaldi.finaljavabe.database;

import com.sefrinaldi.finaljavabe.database.rabbitmq.Receive;

public class DatabaseMain {

    public static Receive receive = new Receive();

    public static void main(String[] args) {
        try{
            System.out.println(" [*] Waiting for messages..");
            receive.registerUser();
            receive.loginUser();
            receive.forgotPassword();
//            receive.insertSiswa();
//            receive.deleteSiswaById();
//            receive.updateSiswaById();
        }catch (Exception e){
            System.out.println("Error DatabaseMain = " + e);
        }
    }
}
