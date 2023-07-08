package com.pessoas.cadastro.dto.response;

import com.pessoas.cadastro.entity.Pessoa;
import lombok.Getter;

@Getter
public class PessoaResponseDTO {
    private long id;
    private String nome;
    private String cpf;
    private String idade;
    public PessoaResponseDTO (Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.cpf = pessoa.getCpf();
        this.idade = pessoa.getIdade();
    }
}
