package com.pessoas.cadastro.util;

import com.pessoas.cadastro.dto.request.PessoaRequestDTO;
import com.pessoas.cadastro.dto.response.PessoaResponseDTO;
import com.pessoas.cadastro.entity.Pessoa;

public class PessoaMapper {
    public Pessoa retornaPessoa (PessoaRequestDTO pessoaDTO) {
        return Pessoa.builder()
                .nome(pessoaDTO.getNome())
                .cpf (pessoaDTO.getCpf())
                .idade (pessoaDTO.getIdade())
                .build();
    }

    public PessoaResponseDTO retornaPessoaDTO (Pessoa pessoa){
        return new PessoaResponseDTO (pessoa);
    }
}
