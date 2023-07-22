package com.pessoas.cadastro.service;

import com.pessoas.cadastro.dto.request.LoginRequestDTO;
import com.pessoas.cadastro.dto.response.LoginResponseDTO;

import java.util.List;

public interface LoginService {
    LoginResponseDTO findById (Long id);
    List<LoginResponseDTO> findAll ();
    LoginResponseDTO register (LoginRequestDTO loginRequestDTO);
    LoginResponseDTO update (LoginRequestDTO loginRequestDTO, Long id);
    String delete (Long id);
}
