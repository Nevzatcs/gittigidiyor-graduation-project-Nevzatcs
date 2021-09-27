package dev.patika.creditapplication.controller;

import dev.patika.creditapplication.service.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/credits")
public class CreditController {

    private final CreditService creditService;

//    @GetMapping
//    public ResponseEntity<?> findCustomerBySsid(String Ssid) {
//        return new ResponseEntity<>(creditScoreService.findCustomerBySsid(Ssid), HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity<?> customerCreditRequest(String identityNumber) {
        return new ResponseEntity<>(creditService.getCreditRequest(identityNumber), HttpStatus.OK);
    }

    @GetMapping("credit-result")
    public ResponseEntity<?> CreditRequestQuery(String identityNumber) {
        return new ResponseEntity<>(creditService.getCreditRequest(identityNumber), HttpStatus.OK);
    }

}