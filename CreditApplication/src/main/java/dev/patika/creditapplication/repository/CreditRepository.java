package dev.patika.creditapplication.repository;

import dev.patika.capstone.model.CreditScore;
import dev.patika.creditapplication.model.CreditScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CreditRepository extends JpaRepository<CreditScore, Long> {
    @Query("SELECT c.creditScore FROM CreditScore c WHERE c.lastNumber=:lastNumber")
    double getCreditScoreByLastNumber(Long lastNumber);
}
