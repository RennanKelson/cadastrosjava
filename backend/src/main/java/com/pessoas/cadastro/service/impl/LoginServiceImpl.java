package com.pessoas.cadastro.service.impl;

import com.pessoas.cadastro.dto.request.LoginRequestDTO;
import com.pessoas.cadastro.dto.response.LoginResponseDTO;
import com.pessoas.cadastro.entity.Login;
import com.pessoas.cadastro.repository.LoginRepository;
import com.pessoas.cadastro.service.LoginService;
import com.pessoas.cadastro.util.LoginMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final LoginRepository loginRepository;
    private final LoginMapper loginMapper;

    @Override
    public LoginResponseDTO findById(Long id) {
        Login login = retornaLogin(id);
        return loginMapper.voltaLoginDTO(login);
    }

    @Override
    public List<LoginResponseDTO> findAll() {
        List<Login> logins = loginRepository.findAll();
        return loginMapper.voltaListaLoginDTO(logins);
    }

    @Override
    public LoginResponseDTO register(LoginRequestDTO loginRequestDTO) {
        Login login = loginMapper.voltaEntidadeLogin(loginRequestDTO);
        Login salvarLogin = loginRepository.save(login);
        return loginMapper.voltaLoginDTO(salvarLogin);
    }

    @Override
    public LoginResponseDTO update(LoginRequestDTO loginRequestDTO, Long id) {
        Login login = retornaLogin(id);
        loginMapper.atualizaLoginBanco(login,loginRequestDTO);
        Login loginAtualizado = loginRepository.save(login);
        return loginMapper.voltaLoginDTO(loginAtualizado);
    }

    @Override
    public String delete(Long id) {
        loginRepository.deleteById(id);
        return "Login: "+id+" foi apagado!";
    }

    private Login retornaLogin (Long id){
        return loginRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Login não encontrado no banco de dados"));
    }
}