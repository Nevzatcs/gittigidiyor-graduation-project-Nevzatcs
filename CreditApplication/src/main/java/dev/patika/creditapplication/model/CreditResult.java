package dev.patika.creditapplication.model;

import dev.patika.creditapplication.model.enumeration.CreditScoreResult;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
//CreditResult model and its states
public class CreditResult extends AbstractBaseEntity {

    private double creditLimit;

    @Enumerated(EnumType.STRING)
    private CreditScoreResult result;
}
