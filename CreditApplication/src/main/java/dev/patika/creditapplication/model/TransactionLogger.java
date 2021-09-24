package dev.patika.creditapplication.model;

import dev.patika.creditapplication.model.enumeration.TransactionLogType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TransactionLogger extends AbstractBaseEntity{

    private String identityNumber;
    private LocalDate transactionDateTime;
    private String clientIpAddress;
    private String clientUrl;
    private String sessionActivityId;
    @Enumerated(EnumType.STRING)
    private TransactionLogType transactionLogType;
}