package com.pessoas.cadastro.dto.response;

import com.pessoas.cadastro.entity.Login;
import com.pessoas.cadastro.entity.Pessoa;
import lombok.Getter;

@Getter
public class LoginResponseDTO {
    private Pessoa pessoa;
    private String usuario;
    private String senha;
    private String email;

    public LoginResponseDTO (Login login) {
        this.pessoa = login.getPessoa();
        this.usuario = login.getUsuario();
        this.senha = login.getSenha();
        this.email = login.getEmail();
    }
}
