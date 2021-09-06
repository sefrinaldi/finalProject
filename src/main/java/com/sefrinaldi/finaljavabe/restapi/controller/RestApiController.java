package com.sefrinaldi.finaljavabe.restapi.controller;

import com.google.gson.Gson;
import com.sefrinaldi.finaljavabe.database.model.Customer;
import com.sefrinaldi.finaljavabe.database.model.Prabayar;
import com.sefrinaldi.finaljavabe.database.model.User;
import com.sefrinaldi.finaljavabe.database.service.RestService;
import com.sefrinaldi.finaljavabe.restapi.rabbitmq.RestApiReceive;
import com.sefrinaldi.finaljavabe.restapi.rabbitmq.RestApiSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeoutException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class RestApiController {

    RestApiSend restApiSend = new RestApiSend();
    RestApiReceive restApiReceive = new RestApiReceive();

    @Autowired
    private RestService restService;


    @RequestMapping(value = "/user/register", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> regisUser (@RequestBody User user) throws IOException, TimeoutException {

        String message = "";
        try {
            restApiSend.registerUser(new Gson().toJson(user));
            message = restApiReceive.returnFromDatabase();
            delay();
        }catch (Exception e){
            System.out.println("error = " + e);
        }

        if (message.equals("success")) {
            return new ResponseEntity<>("Registrasi berhasil", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User sudah terdaftar", HttpStatus.CONFLICT);
        }

    }

    @RequestMapping(value = "/user/login", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> loginUser(@RequestBody User user) throws IOException, TimeoutException {

        try {
            restApiSend.loginUser(new Gson().toJson(user));
        } catch (Exception e) {
            System.out.println("error = " + e);
        }

        return new ResponseEntity<>("sending to database", HttpStatus.OK);
    }

    @RequestMapping(value = "/user/forgot", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> viewInvoice(@RequestBody User user) {

        restApiSend.forgotPass(new Gson().toJson(user));

        return new ResponseEntity<>("Send Email", HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/invoice/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Customer>> cekInvoice (@PathVariable Long id) {
//        String url = String.format("localhost:8090/api/customer/invoice/%s", id);
        List<Customer> listInvoice = Arrays.asList(restService.getPostWithUrlParameters(id));

        return new ResponseEntity<>(listInvoice, HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/order", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> makeOrder(@RequestBody Prabayar prabayar) {

        String prabayar1 = restService.createPost(prabayar);

        return new ResponseEntity<>(prabayar1, HttpStatus.OK);
    }

    private static void delay() {
        try {
            Thread.sleep(15000);
        } catch (InterruptedException _ignored) {
            Thread.currentThread().interrupt();
        }
    }

}
