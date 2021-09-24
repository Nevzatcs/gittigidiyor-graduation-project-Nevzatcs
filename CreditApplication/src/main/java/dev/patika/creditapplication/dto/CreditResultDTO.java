package dev.patika.creditapplication.dto;

import dev.patika.capstone.model.enumeration.CreditScoreResult;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
public class CreditResultDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double limit;

    @Enumerated(EnumType.STRING)
    private CreditScoreResult result;

}