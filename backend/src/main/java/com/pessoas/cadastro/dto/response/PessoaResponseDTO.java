package com.pessoas.cadastro.dto.response;

import com.pessoas.cadastro.entity.Login;
import com.pessoas.cadastro.entity.PerfilUsuario;
import com.pessoas.cadastro.entity.Pessoa;
import lombok.Getter;

@Getter
public class PessoaResponseDTO {
    private Long id;
    private String nome;
    private String cpf;
    private Integer idade;
    private String email;

    public PessoaResponseDTO (Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.cpf = pessoa.getCpf();
        this.idade = pessoa.getIdade();
        this.email = pessoa.getEmail();
    }
}
