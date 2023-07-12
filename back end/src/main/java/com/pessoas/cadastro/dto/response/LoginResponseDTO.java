package com.pessoas.cadastro.dto.response;

import com.pessoas.cadastro.entity.Login;
import com.pessoas.cadastro.entity.PerfilUsuario;
import com.pessoas.cadastro.entity.Pessoa;
import lombok.Getter;

@Getter
public class LoginResponseDTO {
    private Long id;
    private String usuario;
    private String senha;
    private PerfilUsuario perfil;
    private Pessoa pessoa;

    public LoginResponseDTO (Login login) {
        this.id = login.getId();
        this.usuario = login.getUsuario();
        this.senha = login.getSenha();
        this.perfil = login.getPerfil();
        this.pessoa = login.getPessoa();
    }
}
