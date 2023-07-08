package com.pessoas.cadastro.util;

import com.pessoas.cadastro.dto.request.PessoaRequestDTO;
import com.pessoas.cadastro.dto.response.PessoaResponseDTO;
import com.pessoas.cadastro.entity.Pessoa;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class PessoaMapper {
    public Pessoa voltaPessoa (PessoaRequestDTO pessoaDTO) {
        return Pessoa.builder()
                .nome(pessoaDTO.getNome())
                .cpf (pessoaDTO.getCpf())
                .idade (pessoaDTO.getIdade())
                .build();
    }

    public PessoaResponseDTO voltaPessoaDTO(Pessoa pessoa){
        return new PessoaResponseDTO (pessoa);
    }

    public List<PessoaResponseDTO> voltaListaPessoaDTO(List<Pessoa> listaPessoas) {
        return listaPessoas.stream().map(PessoaResponseDTO::new).collect(Collectors.toList());
    }

    public void atualizaPessoaBanco(Pessoa pessoa, PessoaRequestDTO pessoaRequestDTO) {
        pessoa.setNome(pessoaRequestDTO.getNome());
        pessoa.setCpf(pessoaRequestDTO.getCpf());
        pessoa.setIdade(pessoaRequestDTO.getIdade());
    }
}
