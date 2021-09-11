package com.sefrinaldi.plp.controller;

import com.sefrinaldi.plp.Repository.CustomerRepository;
import com.sefrinaldi.plp.model.Customer;
import com.sefrinaldi.plp.model.Prabayar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping(value = "/customer/invoice/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Customer>> cekInvoice(@PathVariable Long id) {
        List<Customer> listInvoice = customerRepository.findInvoice(id);

        if (listInvoice != null) {
            return new ResponseEntity<>(listInvoice, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(listInvoice, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/customer/order", method = RequestMethod.POST, produces = "application/json")
    public String makeOrder(@RequestBody Prabayar prabayar) {
        customerRepository.makeOrder(prabayar);
        delay();

        String status = customerRepository.findTransaction(prabayar.getOrderId());

        if (status != null) {
            if (status.equals("complete")) {
                return "Transaksi Sukses";
            }
            else {
                customerRepository.deleteOrder(prabayar.getOrderId());
                return "Transaksi Gagal";
            }
        }
        else {
            return "Id pelanggan tidak ditemukan";
        }

    }

    private static void delay() {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException _ignored) {
            Thread.currentThread().interrupt();
        }
    }
}
