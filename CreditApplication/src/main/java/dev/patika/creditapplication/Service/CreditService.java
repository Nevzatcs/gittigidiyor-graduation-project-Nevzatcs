package dev.patika.creditapplication.Service;

import dev.patika.capstone.model.enumeration.CreditScoreResult;
import dev.patika.capstone.repository.CreditRepository;
import dev.patika.capstone.repository.CustomerRepository;
import dev.patika.creditapplication.model.enumeration.CreditScoreResult;
import dev.patika.creditapplication.repository.CreditRepository;
import dev.patika.creditapplication.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
@Slf4j
public class CreditService {

    private final CreditRepository creditRepository;
    private final CustomerRepository customerRepository;



    public CreditScoreResult creditRequest(String identityNumber){
        double income = customerRepository.getCustomerIncomeByIdentityNumber(identityNumber);
        Long lastDigit = Math.abs(Long.parseLong(identityNumber)%10);
        log.info(String.valueOf(lastDigit));
        double credit = creditRepository.getCreditScoreByLastNumber(lastDigit);
        if (credit<500){
            return CreditScoreResult.REJECTED;
        }
        else if(credit>500 && credit<1000 && income<5000){
            return CreditScoreResult.ACCEPTED;
        }
        else if(credit>500 && credit<1000 && income>5000){
            return CreditScoreResult.ACCEPTED;
        }
        else if(credit==1000 && income>5000){
            return CreditScoreResult.ACCEPTED;
        }
        return null;
    }
}


