package dev.patika.creditapplication.util;

import dev.patika.creditapplication.model.CreditScore;
import dev.patika.creditapplication.model.Customer;
import dev.patika.creditapplication.repository.CreditRepository;
import dev.patika.creditapplication.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitializerRunner implements CommandLineRunner {
//    private static final Logger logger = LoggerFactory.getLogger(InitializerRunner.class);

    private final CreditRepository creditRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        creditRepository.deleteAll();
        creditRepository.save(CreditScore.builder().lastNumber(2L).creditScore(550).build());
        creditRepository.save(CreditScore.builder().lastNumber(4L).creditScore(1000).build());
        creditRepository.save(CreditScore.builder().lastNumber(6L).creditScore(400).build());
        creditRepository.save(CreditScore.builder().lastNumber(8L).creditScore(900).build());
        creditRepository.save(CreditScore.builder().lastNumber(0L).creditScore(2000).build());

        Customer customer1 = new Customer("Ali","Can",4800, "11111111114","05341234569");
        Customer customer2 = new Customer("Ahmet","Cem",6000, "11111111116","05341234568");
        Customer customer3 = new Customer("Ayşe","Telli",12000, "11111111110","05341234469");
        Customer customer4 = new Customer("Cemre","Gül",4000, "11111111118","05341234589");
        Customer customer5 = new Customer("Mehmet","Yekta",2500, "11111111112","05341234569");

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customer4);
        customerRepository.save(customer5);



    }
}