package dev.patika.creditapplication.repository;

import dev.patika.creditapplication.model.TransactionLogger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionLoggerRepository extends PagingAndSortingRepository<TransactionLogger, Long> {

    //To find all Transactions by date
    @Query("SELECT w FROM TransactionLogger w WHERE w.transactionDateTime= ?1")
    Page<List<TransactionLogger>> findAllTransactionByTransactionDate(LocalDate transactionDate, Pageable pageable);

}
