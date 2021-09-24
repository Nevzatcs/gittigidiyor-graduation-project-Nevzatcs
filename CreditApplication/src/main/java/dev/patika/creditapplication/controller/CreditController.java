package dev.patika.creditapplication.controller;

import dev.patika.creditapplication.Service.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/credits")
public class CreditController {

    private final CreditService creditService;

//    @GetMapping
//    public ResponseEntity<?> findCustomerBySsid(String Ssid) {
//        return new ResponseEntity<>(creditScoreService.findCustomerBySsid(Ssid), HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity<?> findCustomerIncomeBySsid(String identityNumber) {
        return new ResponseEntity<>(creditService.creditRequest(identityNumber), HttpStatus.OK);
    }

}