package dev.patika.creditapplication.model;

import dev.patika.creditapplication.model.enumeration.CreditScoreResult;
import dev.patika.creditapplication.model.enumeration.TransactionLogType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TransactionLogger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identityNumber;
    private LocalDate transactionDateTime;
    private String clientIpAddress;
    private String clientUrl;
    private String sessionActivityId;
    @Enumerated(EnumType.STRING)
    private TransactionLogType transactionLogType;
    @Enumerated(EnumType.STRING)
    private CreditScoreResult creditScoreResult;


}