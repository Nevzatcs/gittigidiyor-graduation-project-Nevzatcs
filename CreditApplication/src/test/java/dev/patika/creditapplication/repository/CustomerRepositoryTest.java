package dev.patika.creditapplication.repository;

import dev.patika.creditapplication.model.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CustomerRepositoryTest {
    @Autowired
    CustomerRepository repository;

    @AfterEach
    public void tearDown(){
        repository.deleteAll();
    }

    @Test
    void shouldCheckWhenCustomerIdIsExists() {
        // given
        Customer customer = new Customer("Can","Samur", 6000, "11111111112", "05364778822");
        repository.save(customer);

        // when
        boolean expected = repository.selectExistsId(customer.getId());

        // then
        assertTrue(expected);
    }


    @Test
    void shouldCheckWhenCustomerIdIsNotExists() {
        // given
        Customer customer = new Customer("Can","Samur", 6000, "11111111112", "05364778822");
        //repository.save(employee);

        // when
        boolean expected = repository.selectExistsId(customer.getId());

        // then
        assertFalse(expected);
    }

    @Test
    void shouldCheckWhenCustomerIdentityNumberIsExists() {
        // given
        Customer customer = new Customer("Can","Samur", 6000, "11111111112", "05364778822");
        repository.save(customer);

        // when
        boolean expected = repository.selectExistsIdentityNumber(customer.getIdentityNumber());

        // then
        assertTrue(expected);
    }

    @Test
    void shouldCheckWhenCustomerIdentityIsNotExists() {
        // given
        Customer customer = new Customer("Can","Samur", 6000, "11111111112", "05364778822");
        //repository.save(employee);

        // when
        boolean expected = repository.selectExistsId(customer.getId());

        // then
        assertFalse(expected);
    }

    @Test
    void getCustomerSalaryByIdentityNumber(){
        Customer customer = new Customer("Can","Samur", 6000, "11111111112", "05364778822");
        repository.save(customer);
        //when
        double expected = repository.getCustomerSalaryByIdentityNumber(customer.getIdentityNumber());

        //then
        assertEquals(expected, customer.getMonthlySalary());

    }
    @Test
    void getCustomerSalaryByIdentityNumberIsNotEqual(){
        Customer customer = new Customer("Can","Samur", 6000, "11111111112", "05364778822");
        //repository.save(customer);
        //when
        Double expected = repository.getCustomerSalaryByIdentityNumber(customer.getIdentityNumber());

        //then
        assertNull(expected);

    }
}