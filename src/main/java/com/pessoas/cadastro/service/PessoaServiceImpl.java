package com.pessoas.cadastro.service;

import com.pessoas.cadastro.dto.request.PessoaRequestDTO;
import com.pessoas.cadastro.dto.response.PessoaResponseDTO;
import com.pessoas.cadastro.repository.PessoaRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class PessoaServiceImpl implements PessoaService {

    private PessoaRepository pessoaRepository;

    @Override
    public PessoaResponseDTO findById(Long id) {
        return null;
    }

    @Override
    public List<PessoaResponseDTO> findAll() {
        return null;
    }

    @Override
    public PessoaResponseDTO register(PessoaRequestDTO pessoaRequestDTO) {
        return null;
    }

    @Override
    public PessoaResponseDTO update(PessoaRequestDTO pessoaRequestDTO) {
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }
}
