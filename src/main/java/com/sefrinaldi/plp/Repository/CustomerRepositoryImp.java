package com.sefrinaldi.plp.Repository;

import com.sefrinaldi.plp.model.Customer;
import com.sefrinaldi.plp.model.Prabayar;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import java.io.Reader;
import java.util.List;

@Repository
public class CustomerRepositoryImp implements CustomerRepository{

    public static Reader reader;
    public static SqlSessionFactory sqlSessionFactory;
    public static SqlSession sqlSession;
    Customer customer = new Customer();

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public List<Customer> findInvoice(Long id) {

        List<Customer> listCustomer = null;

        try {
            connectMybatis();
            listCustomer = sqlSession.selectList("Customer.getInvoice", id);

            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listCustomer;
    }

    @Override
    public void makeOrder(Prabayar prabayar) {

        try {
            connectMybatis();
            Customer customer1 = sqlSession.selectOne("Customer.getById", prabayar);

            if (customer1 != null) {
                int id = customer1.getId();
                int orderId = prabayar.getOrderId();
                String name = customer1.getName();
                String alamat = customer1.getAlamat();
                int daya = customer1.getDaya();
                int token = prabayar.getToken();
                String status = "waiting";

                Prabayar order = new Prabayar(id, orderId, name, alamat, daya, token, status);

                sqlSession.insert("Prabayar.insert", order);
                sqlSession.commit();
                sqlSession.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String findTransaction(int id) {

        String status = null;

        try {
            connectMybatis();
            Prabayar prabayar1 = sqlSession.selectOne("Prabayar.getByOrderId", id);

            if (prabayar1 != null) {
                status = prabayar1.getStatus();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public void deleteOrder(int id) {

        try {
            connectMybatis();
            sqlSession.delete("Prabayar.deleteOrder", id);
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void connectMybatis() {
        try {
            reader = Resources.getResourceAsReader("SqlMapConfig.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlSessionFactory.openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
