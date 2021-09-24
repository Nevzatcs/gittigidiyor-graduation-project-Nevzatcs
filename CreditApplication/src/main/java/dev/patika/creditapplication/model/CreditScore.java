package dev.patika.creditapplication.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class CreditScore extends AbstractBaseEntity {

    private Long lastNumber;
    private int creditScore;
}
