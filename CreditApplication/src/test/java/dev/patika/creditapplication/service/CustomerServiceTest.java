package dev.patika.creditapplication.service;

import dev.patika.creditapplication.dto.CustomerDTO;
import dev.patika.creditapplication.exceptions.BadRequestException;
import dev.patika.creditapplication.exceptions.CustomerNotFoundException;
import dev.patika.creditapplication.mappers.CustomerMapper;
import dev.patika.creditapplication.model.Customer;
import dev.patika.creditapplication.repository.CustomerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock  // repoya gitmiş gibi mocklayacaz
    CustomerRepository mockCustomerRepository;

    @InjectMocks
    CustomerService customerService;

    @Mock
    CustomerMapper mockCustomerMapper;

    @Test
    void findAll() {
        //given
        when(mockCustomerRepository.findAll()).thenReturn(Collections.singletonList(
                new Customer("Can","Samur", 6000, "11111111112", "05364778822")
        ));

        //when //servisteki gerçek metodun testi
        List<Customer> expected = customerService.findAll();


        //then
        assertEquals(expected.get(0).getIdentityNumber(),"11111111112");


    }
    @Test
    void findAllNotFound() {
        //given
        when(mockCustomerRepository.findAll()).thenReturn(Collections.EMPTY_LIST);

        //when //servisteki gerçek metodun testi
        List<Customer> expected = customerService.findAll();


        //then
        assertTrue(expected.isEmpty());


    }

    @Test
    void deleteById() {
        //given
        Customer customer = new Customer("Can", "Samur", 6000, "11111111112", "05364778822");


        //when
        this.mockCustomerRepository.deleteById(customer.getId());

        //then
        assertNull(customer.getId());

    }

    @Test
    void findById() {

        //given
        Customer customer = new Customer();
        customer.setId(1L);
        when(mockCustomerRepository.selectExistsId(customer.getId())).thenReturn(Boolean.TRUE);
        when(mockCustomerRepository.findById(customer.getId())).thenReturn(Optional.of(customer));
        //when
        Optional<Customer> expected = customerService.findById(1L);
        //then
        assertEquals(expected, Optional.of(customer));


    }


    @Test
    void shouldThrowCustomerNotFoundException() {
        // given
        CustomerDTO dto = new CustomerDTO();
        dto.setId(1L);
        // when


        Throwable exception = assertThrows(CustomerNotFoundException.class, () -> {
            throw new CustomerNotFoundException("Customer with Id : " + dto.getId() + " is not found!");
        });

        //then
        assertEquals(exception.getMessage(), "Customer with Id : " + 1L +" is not found!");
    }

    @Test
    void shouldThrowBadRequestException(){
        // given
        CustomerDTO dto = new CustomerDTO();
        dto.setIdentityNumber("11111111112");
        // when


        Throwable exception = assertThrows(BadRequestException.class, () -> {
            throw new BadRequestException("Customer with Identity Number : " + dto.getIdentityNumber() + " is already exists!");
        });

        //then
        assertEquals(exception.getMessage(), "Customer with Identity Number : " + "11111111112"+" is already exists!");
    }


}