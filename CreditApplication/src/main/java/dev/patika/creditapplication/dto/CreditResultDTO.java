package dev.patika.creditapplication.dto;

import dev.patika.creditapplication.model.enumeration.CreditScoreResult;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
public class CreditResultDTO {

    private double limit;

    @Enumerated(EnumType.STRING)
    private CreditScoreResult result;

}