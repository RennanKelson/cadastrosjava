package com.pessoas.cadastro.controller;

import com.pessoas.cadastro.dto.request.TreinoRequestDTO;
import com.pessoas.cadastro.dto.response.TreinoResponseDTO;
import com.pessoas.cadastro.exception.MaxTreinosExcedidosException;
import com.pessoas.cadastro.service.impl.TreinoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/treino")
@RequiredArgsConstructor
public class TreinoController {
    private TreinoServiceImpl treinoService;

    @PostMapping("/pessoas/{pessoaId}/treinos")
    public ResponseEntity<TreinoResponseDTO> adicionarTreino(@PathVariable Long pessoaId, @RequestBody TreinoRequestDTO treinoRequest) {
        try {
            TreinoResponseDTO novoTreino = treinoService.adicionarTreinoParaPessoa(pessoaId, treinoRequest);
            return ResponseEntity.ok(novoTreino);
        } catch (MaxTreinosExcedidosException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
