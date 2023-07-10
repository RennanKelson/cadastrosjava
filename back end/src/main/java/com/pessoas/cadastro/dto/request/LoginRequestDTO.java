package com.pessoas.cadastro.dto.request;

import com.pessoas.cadastro.entity.Pessoa;
import jakarta.persistence.Column;
import lombok.Getter;

@Getter
public class LoginRequestDTO {
    private Pessoa pessoa;
    private String usuario;
    private String senha;
    private String email;
}
