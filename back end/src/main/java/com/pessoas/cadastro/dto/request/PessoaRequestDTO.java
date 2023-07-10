package com.pessoas.cadastro.dto.request;

import com.pessoas.cadastro.entity.Login;
import lombok.Getter;

@Getter
public class PessoaRequestDTO {
    private String nome;
    private String cpf;
    private String idade;
    private Login login;
}
