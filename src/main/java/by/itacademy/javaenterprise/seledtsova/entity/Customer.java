package by.itacademy.javaenterprise.seledtsova.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {

    private Integer customerId;
    private String firstName;
    private String lastName;

    public Customer() {
    }
}
