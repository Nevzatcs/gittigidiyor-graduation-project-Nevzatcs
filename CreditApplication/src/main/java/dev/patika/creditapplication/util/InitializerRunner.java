package dev.patika.creditapplication.util;

import dev.patika.creditapplication.model.CreditScore;
import dev.patika.creditapplication.repository.CreditRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitializerRunner implements CommandLineRunner {
//    private static final Logger logger = LoggerFactory.getLogger(InitializerRunner.class);

    private final CreditRepository creditRepository;

    @Override
    public void run(String... args) throws Exception {
        creditRepository.deleteAll();
        creditRepository.save(CreditScore.builder().lastNumber(2L).creditScore(550).build());
        creditRepository.save(CreditScore.builder().lastNumber(4L).creditScore(1000).build());
        creditRepository.save(CreditScore.builder().lastNumber(6L).creditScore(400).build());
        creditRepository.save(CreditScore.builder().lastNumber(8L).creditScore(900).build());
        creditRepository.save(CreditScore.builder().lastNumber(0L).creditScore(2000).build());

        /*
        CreditScore creditScore1 = CreditScore.builder().lastNumber(2L).creditScore(550).build();
        CreditScore creditScore2 = CreditScore.builder().lastNumber(4L).creditScore(1000).build();
        CreditScore creditScore3 = CreditScore.builder().lastNumber(6L).creditScore(400).build();
        CreditScore creditScore4 = CreditScore.builder().lastNumber(8L).creditScore(900).build();
        CreditScore creditScore5 = CreditScore.builder().lastNumber(0L).creditScore(2000).build();

        creditRepository.save(creditScore1);
        creditRepository.save(creditScore2);
        creditRepository.save(creditScore3);
        creditRepository.save(creditScore4);
        creditRepository.save(creditScore5);

         */


    }
}