package com.pessoas.cadastro.controller;

import com.pessoas.cadastro.dto.request.PessoaRequestDTO;
import com.pessoas.cadastro.dto.response.PessoaResponseDTO;
import com.pessoas.cadastro.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping (value = "/pessoa")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaResponseDTO> findById (@PathVariable(name = "id")Long id) {
        return ResponseEntity.ok().body(pessoaService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<PessoaResponseDTO>> findAll() {
        return ResponseEntity.ok().body(pessoaService.findAll());
    }

    @PostMapping
    public ResponseEntity<PessoaResponseDTO> register(@RequestBody PessoaRequestDTO pessoaRequestDTO, UriComponentsBuilder uriComponentsBuilder) {
        PessoaResponseDTO pessoaResponseDTO = pessoaService.register(pessoaRequestDTO);
        URI uri = uriComponentsBuilder.path("/pessoa/id").buildAndExpand(pessoaResponseDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(pessoaResponseDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PessoaResponseDTO> update (@RequestBody PessoaRequestDTO pessoaRequestDTO, @PathVariable (name = "id")Long id){
        return ResponseEntity.ok().body(pessoaService.update(pessoaRequestDTO, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete (@PathVariable (name = "id") Long id) {
        return ResponseEntity.ok().body(pessoaService.delete(id));
    }
}
