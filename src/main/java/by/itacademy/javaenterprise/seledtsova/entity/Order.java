package by.itacademy.javaenterprise.seledtsova.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Order {

    private Integer orderId;
    private Integer customerId;
    private String dateOrder;
    private List<Customer> customers;

    public Order() {
    }
}
