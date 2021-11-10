package by.itacademy.javaenterprise.seledtsova;

import by.itacademy.javaenterprise.seledtsova.dao.CustomerDao;
import by.itacademy.javaenterprise.seledtsova.dao.OrderDao;
import by.itacademy.javaenterprise.seledtsova.dao.impl.CustomerDaoImpl;
import by.itacademy.javaenterprise.seledtsova.dao.impl.OrderDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Runner {

    private final static Logger logger = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) throws SQLException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        CustomerDao customerDao = context.getBean("customerService", CustomerDaoImpl.class);
        logger.info("CustomerService bean was created", customerDao.getAll());
        System.out.println(customerDao.getAll());
        OrderDao orderDao = context.getBean("orderService", OrderDaoImpl.class);
        logger.info("OrderService bean was created");
        System.out.println(orderDao.getAll());
        System.out.println(customerDao.findCustomerByCustomerId(9));

        context.close();
    }
}
