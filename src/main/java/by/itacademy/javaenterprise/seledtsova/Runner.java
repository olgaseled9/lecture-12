package by.itacademy.javaenterprise.seledtsova;

import by.itacademy.javaenterprise.seledtsova.dao.CustomerDao;
import by.itacademy.javaenterprise.seledtsova.dao.OrderDao;
import by.itacademy.javaenterprise.seledtsova.dao.impl.CustomerDaoImpl;
import by.itacademy.javaenterprise.seledtsova.dao.impl.OrderDaoImpl;
import by.itacademy.javaenterprise.seledtsova.entity.Customer;
import by.itacademy.javaenterprise.seledtsova.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {

    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        CustomerDao customerDao = context.getBean("customerService", CustomerDaoImpl.class);
        logger.info("CustomerService bean was created");
        customerDao.getAll();
        OrderDao orderDao = context.getBean("orderService", OrderDaoImpl.class);
        logger.info("OrderService bean was created");
        orderDao.getAll();
        customerDao.saveCustomer(new Customer(25L, "Vasia", "Petrov"));
        logger.info("Customer are added successfully");
        orderDao.saveOrder(new Order(25L, 25L, 100));
        logger.info("Order are added successfully");
        orderDao.deleteOrderById(25L);
        logger.info("Order delete successful");
        customerDao.deleteCustomerById(25L);
        logger.info("Customer delete successful");
        customerDao.findCustomerByCustomerId(9L);
        customerDao.getAll();

        context.close();
    }
}
