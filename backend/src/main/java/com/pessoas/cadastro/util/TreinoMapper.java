package com.pessoas.cadastro.util;

import com.pessoas.cadastro.dto.request.TreinoRequestDTO;
import com.pessoas.cadastro.dto.response.TreinoResponseDTO;
import com.pessoas.cadastro.entity.Treino;
import org.springframework.stereotype.Component;

@Component
public class TreinoMapper {
    private PessoaMapper pessoaMapper;

    public Treino voltaTreinoEntidade(TreinoRequestDTO treinoRequest) {
        Treino treino = new Treino();
        treino.setExercicio(treinoRequest.getExercicio());
        treino.setSerie(treinoRequest.getSerie());
        treino.setIntervalo(treinoRequest.getIntervalo());
        treino.setIntensidade(treinoRequest.getIntensidade());
        return treino;
    }

    public TreinoResponseDTO voltaTreinoDTO (Treino treino) {
        TreinoResponseDTO treinoResponseDTO = new TreinoResponseDTO();
        treinoResponseDTO.setExercicio(treino.getExercicio());
        treinoResponseDTO.setSerie(treino.getSerie());
        treinoResponseDTO.setIntervalo(treino.getIntervalo());
        treinoResponseDTO.setIntensidade(treino.getIntensidade());
        treinoResponseDTO.setIdPessoa(treino.getPessoa().getId());
        return treinoResponseDTO;
    }
}
