package com.sefrinaldi.plp.Repository;

import com.sefrinaldi.plp.model.Customer;
import com.sefrinaldi.plp.model.Prabayar;

import java.util.List;

public interface CustomerRepository {

    Customer findById(int id);
    List<Customer> findInvoice(Long id);
    void makeOrder(Prabayar prabayar);
    String findTransaction(int id);
    void deleteOrder(int id);
}
