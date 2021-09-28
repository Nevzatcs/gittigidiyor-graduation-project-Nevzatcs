package dev.patika.creditapplication.dto;

import dev.patika.creditapplication.model.enumeration.CreditScoreResult;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
//Implementation of models as a DTO
public class CreditResultDTO {

    private double limit;

    @Enumerated(EnumType.STRING)
    private CreditScoreResult result;

}