package com.pessoas.cadastro.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TreinoResponseDTO {
    private String exercicio;
    private String serie;
    private String intervalo;
    private String intensidade;
    private Long idPessoa;
}
