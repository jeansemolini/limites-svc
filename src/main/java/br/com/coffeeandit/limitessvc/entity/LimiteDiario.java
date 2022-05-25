package br.com.coffeeandit.limitessvc.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table
@EqualsAndHashCode(of = "id")
public class LimiteDiario {

    @Id
    private Long id;
    private Long agencia;
    private Long conta;
    private BigDecimal valor;
}
