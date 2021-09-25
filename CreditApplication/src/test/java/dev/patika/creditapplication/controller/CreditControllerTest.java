package dev.patika.creditapplication.controller;

import dev.patika.creditapplication.Service.CreditService;
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
        CreditScoreResult creditScoreresult = CreditScoreResult.ACCEPTED;
        when(mockCreditService.creditRequest(customer.getIdentityNumber())).thenReturn(creditScoreresult);

        //when
        CustomerDTO customerDTO = new CustomerDTO();
        ResponseEntity<?> actual;
        actual = this.creditController.customerCreditRequest(customerDTO.getIdentityNumber());

        //then
        assertEquals(creditScoreresult, actual.getBody());
    }

    @Test
    void notFindCustomerIncomeBySsid(){
        //given
        Customer customer = new Customer();

        when(mockCreditService.creditRequest(customer.getIdentityNumber())).thenReturn(null);

        //when
        CustomerDTO customerDTO = new CustomerDTO();
        ResponseEntity<?> actual;
        actual = this.creditController.customerCreditRequest(customerDTO.getIdentityNumber());

        //then
        assertNull( actual.getBody());

    }

}