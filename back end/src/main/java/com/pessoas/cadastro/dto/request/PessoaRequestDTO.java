package com.pessoas.cadastro.dto.request;

import com.pessoas.cadastro.entity.Login;
import com.pessoas.cadastro.entity.PerfilUsuario;
import lombok.Getter;

@Getter
public class PessoaRequestDTO {
    private String nome;
    private String cpf;
    private Integer idade;
    private PerfilUsuario perfil;
    private Login login;
}
