package dev.patika.creditapplication.repository;

import dev.patika.creditapplication.model.CreditScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
//CreditRepository for Credit Service
public interface CreditRepository extends JpaRepository<CreditScore, Long> {
    //To get credit score for identity number last digit
    @Query("SELECT c.creditScore FROM CreditScore c WHERE c.lastNumber=:lastNumber")
    Double getCreditScoreByLastNumber(Long lastNumber);


}
