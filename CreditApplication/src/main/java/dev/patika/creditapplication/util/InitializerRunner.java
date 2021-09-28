package dev.patika.creditapplication.util;

import dev.patika.creditapplication.dto.CustomerDTO;
import dev.patika.creditapplication.model.CreditScore;
import dev.patika.creditapplication.model.Customer;
import dev.patika.creditapplication.repository.CreditRepository;
import dev.patika.creditapplication.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
//Intitalizer Runner Class
public class InitializerRunner implements CommandLineRunner {


    private final CreditRepository creditRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        //To delete all infos in db
        creditRepository.deleteAll();
        // To add credit scores when app is starting to run
        creditRepository.save(CreditScore.builder().lastNumber(2L).creditScore(550).build());
        creditRepository.save(CreditScore.builder().lastNumber(4L).creditScore(1000).build());
        creditRepository.save(CreditScore.builder().lastNumber(6L).creditScore(400).build());
        creditRepository.save(CreditScore.builder().lastNumber(8L).creditScore(900).build());
        creditRepository.save(CreditScore.builder().lastNumber(0L).creditScore(2000).build());

        // To add customer as default
        customerRepository.save(Customer.builder().firstName("Ali").lastName("Can").monthlySalary(4800.0).identityNumber("11111111114").phoneNumber("05341234567").build());
        customerRepository.save(Customer.builder().firstName("Ahmet").lastName("Cem").monthlySalary(6000.0).identityNumber("11111111116").phoneNumber("05341234568").build());
        customerRepository.save(Customer.builder().firstName("Ayşe").lastName("Telli").monthlySalary(12000.0).identityNumber("11111111110").phoneNumber("05341234566").build());
        customerRepository.save(Customer.builder().firstName("Cemre").lastName("Gül").monthlySalary(4000.0).identityNumber("11111111118").phoneNumber("05341234569").build());
        customerRepository.save(Customer.builder().firstName("Mehmet").lastName("Yekta").monthlySalary(2500.0).identityNumber("11111111112").phoneNumber("05341234562").build());


    }
}