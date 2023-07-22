package com.pessoas.cadastro.dto.request;

import com.pessoas.cadastro.entity.PerfilUsuario;
import com.pessoas.cadastro.entity.Pessoa;
import lombok.Getter;

@Getter
public class LoginRequestDTO {
    private String usuario;
    private String senha;
}
