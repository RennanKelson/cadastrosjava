package com.pessoas.cadastro.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginValidarResponseDTO {
    private String usuario;
    private String senha;
    private Long idPessoa;
}
