package com.pessoas.cadastro.service.impl;

import com.pessoas.cadastro.dto.request.PessoaRequestDTO;
import com.pessoas.cadastro.dto.response.PessoaResponseDTO;
import com.pessoas.cadastro.entity.Pessoa;
import com.pessoas.cadastro.repository.PessoaRepository;
import com.pessoas.cadastro.service.PessoaService;
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
        return pessoaMapper.voltaPessoaDTO(retornaPessoa(id));
    }

    @Override
    public List<PessoaResponseDTO> findAll() {
        return pessoaMapper.voltaListaPessoaDTO(pessoaRepository.findAll());
    }

    @Override
    public PessoaResponseDTO register(PessoaRequestDTO pessoaRequestDTO) {
        Pessoa pessoa = pessoaMapper.voltaPessoa(pessoaRequestDTO);
        return pessoaMapper.voltaPessoaDTO(pessoaRepository.save(pessoa));
    }

    @Override
    public PessoaResponseDTO update(PessoaRequestDTO pessoaRequestDTO, Long id) {
        Pessoa pessoa = retornaPessoa (id);
        pessoaMapper.atualizaPessoaBanco(pessoa, pessoaRequestDTO);
        return pessoaMapper.voltaPessoaDTO(pessoaRepository.save(pessoa));
    }

    @Override
    public String delete(Long id) {
        pessoaRepository.deleteById(id);
        return "Pessoa id: "+id+" foi apagada";
    }

    private Pessoa retornaPessoa (Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Pessoa não encontrada no banco de dados"));
    }
}