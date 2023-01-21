package br.com.coffeeandit.limitessvc.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BeneficiarioDto {

    private Long CPF;
    private Long codigoBanco;
    private String agencia;
    private String conta;
    private String nomeFavorecido;
}
