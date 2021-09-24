package dev.patika.creditapplication.repository;


import dev.patika.creditapplication.model.TransactionLogger;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionLoggerRepository extends PagingAndSortingRepository<TransactionLogger, Long> {

}
