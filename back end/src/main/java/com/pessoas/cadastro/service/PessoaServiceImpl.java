package com.pessoas.cadastro.service;

import com.pessoas.cadastro.dto.request.PessoaRequestDTO;
import com.pessoas.cadastro.dto.response.PessoaResponseDTO;
import com.pessoas.cadastro.entity.Pessoa;
import com.pessoas.cadastro.repository.PessoaRepository;
import com.pessoas.cadastro.util.PessoaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;
    private final PessoaMapper pessoaMapper;

    @Override
    public PessoaResponseDTO findById(Long id) {
        Pessoa pessoa = retornaPessoa (id);
        return pessoaMapper.voltaPessoaDTO(pessoa);
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
    public PessoaResponseDTO update(PessoaRequestDTO pessoaRequestDTO, Long id) {
        Pessoa pessoa = returnaPessoa (id);
    }

    @Override
    public String delete(Long id) {
        return null;
    }

    private Pessoa retornaPessoa (Long id) {
        return pessoaRepository.findById(id).orElseThrow(()-> new RuntimeException("Pessoa não encontrada no banco de dados"));
    }
}
