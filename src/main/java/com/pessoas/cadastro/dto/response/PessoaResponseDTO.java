package com.pessoas.cadastro.dto.response;

import com.pessoas.cadastro.entity.Pessoa;

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
