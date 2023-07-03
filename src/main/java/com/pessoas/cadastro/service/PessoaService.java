package com.pessoas.cadastro.service;

import com.pessoas.cadastro.dto.request.PessoaRequestDTO;
import com.pessoas.cadastro.dto.response.PessoaResponseDTO;

import java.util.List;

public interface PessoaService {

    PessoaResponseDTO findById (Long id);
    List<PessoaResponseDTO> findAll();
    PessoaResponseDTO register (PessoaRequestDTO pessoaRequestDTO);
    PessoaResponseDTO update (PessoaRequestDTO pessoaRequestDTO, Long id);
    String delete (Long id);
}
