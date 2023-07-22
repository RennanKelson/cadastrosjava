package com.pessoas.cadastro.service.impl;

import com.pessoas.cadastro.dto.request.PessoaRequestDTO;
import com.pessoas.cadastro.dto.response.PessoaResponseDTO;
import com.pessoas.cadastro.entity.Pessoa;
import com.pessoas.cadastro.repository.PessoaRepository;
import com.pessoas.cadastro.service.PessoaService;
import com.pessoas.cadastro.util.PessoaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;
    private final PessoaMapper pessoaMapper;

    @Override
    public PessoaResponseDTO findById(Long id) {
        Pessoa pessoa = retornaPessoa(id);
        return pessoaMapper.voltaPessoaDTO(pessoa);
    }

    @Override
    public List<PessoaResponseDTO> findAll() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        return pessoaMapper.voltaListaPessoaDTO(pessoas);
    }

    @Override
    public PessoaResponseDTO register(PessoaRequestDTO pessoaRequestDTO) {
        Pessoa pessoa = pessoaMapper.voltaPessoa(pessoaRequestDTO);
        Pessoa salvarPessoa = pessoaRepository.save(pessoa);
        return pessoaMapper.voltaPessoaDTO(salvarPessoa);
    }
    @Override
    public PessoaResponseDTO update(PessoaRequestDTO pessoaRequestDTO, Long id) {
        Pessoa pessoa = retornaPessoa(id);
        pessoaMapper.atualizaPessoaBanco(pessoa, pessoaRequestDTO);
        Pessoa PessoaAtualizada = pessoaRepository.save(pessoa);
        return pessoaMapper.voltaPessoaDTO(PessoaAtualizada);
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