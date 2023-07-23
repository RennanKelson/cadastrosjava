package com.pessoas.cadastro.dto.response;

import lombok.Setter;

@Setter
public class LoginValidarResponseDTO {
    private String usuario;
    private String senha;
    private Long idPessoa;
}
