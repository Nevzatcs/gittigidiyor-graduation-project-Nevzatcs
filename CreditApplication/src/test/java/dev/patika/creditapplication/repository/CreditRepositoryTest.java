package dev.patika.creditapplication.repository;

import dev.patika.creditapplication.model.CreditScore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;


import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CreditRepositoryTest {
    @Autowired
    CreditRepository repository;
    @Test
    void getCreditScoreByLastNumber() {
        // given
        CreditScore creditScore = new CreditScore(2L, 550);
        repository.save(creditScore);

        // when
        Double expected = repository.getCreditScoreByLastNumber(creditScore.getLastNumber());

        // then
        assertEquals(expected, creditScore.getCreditScore());
    }

    @Test
    void getCreditScoreByLastNumberIsNot() {
        // given
        CreditScore creditScore = new CreditScore(2L, 550);
        //repository.save(creditScore);

        // when
        Double expected = repository.getCreditScoreByLastNumber(creditScore.getLastNumber());

        // then
        assertEquals(expected, null);
    }
}