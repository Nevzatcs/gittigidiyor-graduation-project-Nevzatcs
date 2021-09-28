package dev.patika.creditapplication.service;

import dev.patika.creditapplication.dto.CreditResultDTO;
import dev.patika.creditapplication.dto.CustomerDTO;
import dev.patika.creditapplication.exceptions.IdentityNumberNotFoundException;
import dev.patika.creditapplication.mappers.CustomerMapper;
import dev.patika.creditapplication.model.CreditResult;
import dev.patika.creditapplication.model.Customer;
import dev.patika.creditapplication.model.TransactionLogger;
import dev.patika.creditapplication.model.enumeration.CreditScoreResult;
import dev.patika.creditapplication.model.enumeration.TransactionLogType;
import dev.patika.creditapplication.repository.CreditRepository;
import dev.patika.creditapplication.repository.CustomerRepository;
import dev.patika.creditapplication.repository.TransactionLoggerRepository;
import dev.patika.creditapplication.util.ClientRequestInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
//Credit Service Class
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
@Slf4j
public class CreditService {

    private final CreditRepository creditRepository;
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final int creditLimitMultiplier = 4;
    @Autowired
    private ClientRequestInfo clientRequestInfo;
    @Autowired
    private TransactionLoggerRepository transactionLoggerRepository;

    //Method to get credit application result
    public CreditResultDTO getCreditRequest(String identityNumber){
        CreditResultDTO creditResult = new CreditResultDTO();

        Double salary = customerRepository.getCustomerSalaryByIdentityNumber(identityNumber);
        if(salary == null){
            throw  new IdentityNumberNotFoundException("Identity Number is not found !, Check your Identity Number !");
        }
        Long lastDigit = Math.abs(Long.valueOf(identityNumber)%10);
        double credit = creditRepository.getCreditScoreByLastNumber(lastDigit);

        if (credit<500){
            creditResult.setResult(CreditScoreResult.REJECTED);
            creditResult.setLimit(0);
            sendMessage(identityNumber);
            this.saveTransactionToDatabase(identityNumber, creditResult.getResult());
            return creditResult;
        }
        else if(credit>500 && credit<1000 && salary<5000){

            creditResult.setLimit(10000);
            creditResult.setResult(CreditScoreResult.ACCEPTED);
            sendMessage(identityNumber);
            this.saveTransactionToDatabase(identityNumber, creditResult.getResult());

            return creditResult;
        }
        else if(credit>500 && credit<1000 && salary>5000){
            creditResult.setResult(CreditScoreResult.ACCEPTED);
            creditResult.setLimit(20000);
            sendMessage(identityNumber);
            this.saveTransactionToDatabase(identityNumber, creditResult.getResult());
            return creditResult;
        }
        else if(credit>=1000 ){
            creditResult.setResult(CreditScoreResult.ACCEPTED);
            double limit = salary * creditLimitMultiplier;
            creditResult.setLimit(limit);
            sendMessage(identityNumber);
            this.saveTransactionToDatabase(identityNumber, creditResult.getResult());
            return creditResult;
        }
        throw  new IdentityNumberNotFoundException("Identity Number is not found !, Check your Identity Number !");
    }

    //Method to send message to Phone Number
    private void sendMessage(String identityNumber){
        Customer customer = customerRepository.getCustomerByIdentityNumber(identityNumber);
        CustomerDTO customerDTO = customerMapper.mapFromCustomertoCustomerDTO(customer);
        System.out.println("Your credit result send to your phoneNumber: " + customerDTO.getPhoneNumber());

    }

    //To save logs to database
    private void saveTransactionToDatabase(String identityNumber, CreditScoreResult creditScoreResult) {
        TransactionLogger transactionLogger = new TransactionLogger();
        transactionLogger.setIdentityNumber(identityNumber);
        transactionLogger.setTransactionDateTime(LocalDate.now());
        transactionLogger.setTransactionLogType(TransactionLogType.CREDIT_REQUEST);
        transactionLogger.setClientUrl(clientRequestInfo.getClientUrl());
        transactionLogger.setClientIpAddress(clientRequestInfo.getClientIpAddress());
        transactionLogger.setSessionActivityId(clientRequestInfo.getSessionActivityId());
        transactionLogger.setCreditScoreResult(creditScoreResult);

        transactionLoggerRepository.save(transactionLogger);
    }

}


