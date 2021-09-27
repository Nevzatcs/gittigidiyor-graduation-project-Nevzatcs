package dev.patika.creditapplication.controller;

import dev.patika.creditapplication.dto.CreditResultDTO;
import dev.patika.creditapplication.service.CreditService;
import dev.patika.creditapplication.dto.CustomerDTO;
import dev.patika.creditapplication.model.Customer;
import dev.patika.creditapplication.model.enumeration.CreditScoreResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreditControllerTest {

    @Mock
    CreditService mockCreditService;

    @InjectMocks
    CreditController creditController;

    @Test
    void findCustomerIncomeBySsid() {
        //given
        Customer customer = new Customer();
        CreditResultDTO creditResultDTO = new CreditResultDTO();
        creditResultDTO.setResult(CreditScoreResult.ACCEPTED);
        when(mockCreditService.getCreditRequest(customer.getIdentityNumber())).thenReturn(creditResultDTO);

        //when
        CustomerDTO customerDTO = new CustomerDTO();
        ResponseEntity<?> actual;
        actual = this.creditController.customerCreditRequest(customerDTO.getIdentityNumber());

        //then
        assertEquals(creditResultDTO, actual.getBody());
    }

    @Test
    void notFindCustomerIncomeBySsid(){
        //given
        Customer customer = new Customer();

        when(mockCreditService.getCreditRequest(customer.getIdentityNumber())).thenReturn(null);

        //when
        CustomerDTO customerDTO = new CustomerDTO();
        ResponseEntity<?> actual;
        actual = this.creditController.customerCreditRequest(customerDTO.getIdentityNumber());

        //then
        assertNull( actual.getBody());

    }

}