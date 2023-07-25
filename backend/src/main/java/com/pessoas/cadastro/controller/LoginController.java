package com.pessoas.cadastro.controller;

import com.pessoas.cadastro.dto.request.LoginRequestDTO;
import com.pessoas.cadastro.dto.request.LoginValidarRequestDTO;
import com.pessoas.cadastro.dto.response.LoginResponseDTO;
import com.pessoas.cadastro.dto.response.LoginValidarResponseDTO;
import com.pessoas.cadastro.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<LoginResponseDTO> findById (@PathVariable(name = "id")Long id) {
        return ResponseEntity.ok().body(loginService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<LoginResponseDTO>> findAll() {
        return ResponseEntity.ok().body(loginService.findAll());
    }

    @PostMapping
    public ResponseEntity<LoginResponseDTO> register(@RequestBody LoginRequestDTO loginRequestDTO, UriComponentsBuilder uriComponentsBuilder) {
        LoginResponseDTO loginResponseDTO = loginService.register(loginRequestDTO);
        URI uri = uriComponentsBuilder.path("/login/id").buildAndExpand(loginResponseDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(loginResponseDTO);
    }

    @PostMapping(value = "/validate-login")
    public ResponseEntity<LoginValidarResponseDTO> validaLogin (@RequestBody LoginValidarRequestDTO loginValidarRequestDTO, UriComponentsBuilder uriComponentsBuilder) {
        LoginValidarResponseDTO loginValidarResponseDTO = loginService.validaLogin(loginValidarRequestDTO);
        URI uri = uriComponentsBuilder.path("/loginvalidado/id").buildAndExpand(loginValidarResponseDTO.getIdPessoa()).toUri();
        return ResponseEntity.created(uri).body(loginValidarResponseDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<LoginResponseDTO> update (@RequestBody LoginRequestDTO loginRequestDTO, @PathVariable (name = "id")Long id){
        return ResponseEntity.ok().body(loginService.update(loginRequestDTO, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete (@PathVariable (name = "id") Long id) {
        return ResponseEntity.ok().body(loginService.delete(id));
    }
}
