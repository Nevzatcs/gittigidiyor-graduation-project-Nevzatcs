package dev.patika.creditapplication.model;

import dev.patika.creditapplication.model.enumeration.CreditScoreResult;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class CreditResult extends AbstractBaseEntity {

    private double creditLimit;

    @Enumerated(EnumType.STRING)
    private CreditScoreResult result;
}
