package dev.patika.creditapplication.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="customer")
@Builder
//Customer model and its states
public class Customer extends AbstractBaseEntity {

    private String firstName;
    private String lastName;
    private double monthlySalary;
    private String identityNumber;
    private String phoneNumber;

}
