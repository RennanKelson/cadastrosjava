package com.pessoas.cadastro.service.impl;

import com.pessoas.cadastro.dto.request.LoginRequestDTO;
import com.pessoas.cadastro.dto.request.LoginValidarRequestDTO;
import com.pessoas.cadastro.dto.response.LoginResponseDTO;
import com.pessoas.cadastro.dto.response.LoginValidarResponseDTO;
import com.pessoas.cadastro.dto.response.PessoaResponseDTO;
import com.pessoas.cadastro.entity.Login;
import com.pessoas.cadastro.repository.LoginRepository;
import com.pessoas.cadastro.repository.PessoaRepository;
import com.pessoas.cadastro.service.LoginService;
import com.pessoas.cadastro.service.PessoaService;
import com.pessoas.cadastro.util.LoginMapper;
import com.pessoas.cadastro.util.PessoaMapper;
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

    @Override
    public LoginValidarResponseDTO validaLogin (LoginValidarRequestDTO loginValidarRequestDTO) {
        Login login = this.loginRepository.findByUsuarioAndSenha(loginValidarRequestDTO.getUsuario(), loginValidarRequestDTO.getSenha());
        if (login == null){
            throw new RuntimeException("Login ou senha não autorizado, campos inválidos");
        }
        return this.loginMapper.voltaLoginValidadoDTO(login);
    }

    private Login retornaLogin (Long id){
        return loginRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Login não encontrado no banco de dados"));
    }
}