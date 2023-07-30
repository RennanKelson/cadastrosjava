package com.pessoas.cadastro.service.impl;

import com.pessoas.cadastro.dto.request.TreinoRequestDTO;
import com.pessoas.cadastro.dto.response.TreinoResponseDTO;
import com.pessoas.cadastro.entity.Pessoa;
import com.pessoas.cadastro.entity.Treino;
import com.pessoas.cadastro.exception.MaxTreinosExcedidosException;
import com.pessoas.cadastro.repository.PessoaRepository;
import com.pessoas.cadastro.util.PessoaMapper;
import com.pessoas.cadastro.util.TreinoMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TreinoServiceImpl {
    private static final int MAX_TREINOS_POR_PESSOA = 7;
    private final PessoaRepository pessoaRepository;
    private final TreinoMapper treinoMapper;

    public TreinoResponseDTO adicionarTreinoParaPessoa(Long pessoaId, TreinoRequestDTO treinoRequest) throws MaxTreinosExcedidosException {
        Pessoa pessoa = pessoaRepository.findById(pessoaId).orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada com o ID fornecido"));

        if (pessoa.getTreino().size() >= MAX_TREINOS_POR_PESSOA) {
            throw new MaxTreinosExcedidosException("A pessoa já possui o número máximo de treinos permitidos.");
        }
        Treino treino = treinoMapper.voltaTreinoEntidade(treinoRequest);
        pessoa.getTreino().add(treino);
        pessoaRepository.save(pessoa);
        return treinoMapper.voltaTreinoDTO(treino);
    }
}
