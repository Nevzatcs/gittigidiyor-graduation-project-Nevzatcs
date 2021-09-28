package dev.patika.creditapplication.controller;

import dev.patika.creditapplication.service.CustomerService;
import dev.patika.creditapplication.dto.CustomerDTO;
import dev.patika.creditapplication.model.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
//Test class
@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

    @Mock
    CustomerService mockCustomerService;

    @InjectMocks
    CustomerController customerController;


    @Test
    void saveCustomer() {
        //given
        Customer customer = new Customer();
        customer.setIdentityNumber("11111");
        Optional<Customer> expected = Optional.of(customer);
        when(mockCustomerService.saveCustomer(any())).thenReturn(expected);  // çağırdığımda ne dönmeli

        //when
        CustomerDTO customerDTO = new CustomerDTO();

        Customer actual =  this.customerController.saveCustomer(customerDTO).getBody();

        //then
        assertAll(
                ()-> assertNotNull(actual),
                ()-> assertEquals(expected.get(), actual),
                ()-> assertEquals(customer.getIdentityNumber(), actual.getIdentityNumber())
        );

    }

    @Test
    void findCustomerById(){
        //given
        Customer customer = new Customer();
        customer.setId(1L);
        Optional<Customer> expected = Optional.of(customer);
        when(mockCustomerService.findCustomerById(any())).thenReturn(expected);  // çağırdığımda ne dönmeli

        //when

        Customer actual =  this.customerController.findCustomerById(1L).getBody();

        //then
        assertAll(
                ()-> assertEquals(expected.get(), actual),
                ()-> assertEquals(customer.getId(),actual.getId())
        );

    }

    @Test
    void notFindCustomerById(){
        // given
        when(mockCustomerService.findCustomerById(any())).thenReturn(Optional.empty());

        // when
        CustomerDTO customerDTO = new CustomerDTO();

        ResponseEntity<Customer> actual = this.customerController.findCustomerById(customerDTO.getId());

        // then
        assertEquals(HttpStatus.BAD_REQUEST, actual.getStatusCode());

    }

    @Test
    void findAll() {
        //given
        Customer customer = new Customer();
        when(mockCustomerService.findAll()).thenReturn(Collections.singletonList(customer));

        //when
        CustomerDTO customerDTO = new CustomerDTO();
        ResponseEntity<List<Customer>> actual =  this.customerController.findAll();

        //then
        assertEquals(customer, actual.getBody().get(0));
    }



    @Test
    void deleteCustomerById() {
        //given
        Customer customer = new Customer();
        customer.setId(1L);
        String expected = "Customer with id: " + customer.getId() + " is deleted...";

        //when
        String actual = this.customerController.deleteCustomerById(1L);

        //then
        assertEquals(expected, actual);


    }

    @Test
    void updateCustomer() {
        //given
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(1l);
        BindingResult result = new BeanPropertyBindingResult(customerDTO, "customerDTO");
        String expected = "Customer updated.";

        //when
        String actual = this.customerController.updateCustomer(1L, customerDTO, result);

        //then
        assertEquals(expected, actual);
    }



    @Test
    void saveNotCustomer() {
        //given
        when(mockCustomerService.saveCustomer(any())).thenReturn(Optional.empty());  // çağırdığımda ne dönmeli

        //when
        CustomerDTO customerDTO = new CustomerDTO();
        ResponseEntity<Customer> actual = this.customerController.saveCustomer(customerDTO);

        //then
        assertEquals(HttpStatus.BAD_REQUEST, actual.getStatusCode());
    }

}