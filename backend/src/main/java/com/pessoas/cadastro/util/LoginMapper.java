package com.pessoas.cadastro.util;

import com.pessoas.cadastro.dto.request.LoginRequestDTO;
import com.pessoas.cadastro.dto.response.LoginResponseDTO;
import com.pessoas.cadastro.dto.response.LoginValidarResponseDTO;
import com.pessoas.cadastro.entity.Login;
import com.pessoas.cadastro.entity.Pessoa;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class LoginMapper {
    private final PessoaMapper pessoaMapper;

    public LoginMapper(PessoaMapper pessoaMapper) {
        this.pessoaMapper = pessoaMapper;
    }

    public Login voltaEntidadeLogin(LoginRequestDTO loginDTO) {
        //Pessoa pessoa = pessoaMapper.voltaPessoa(loginDTO.getPessoa());
        return Login.builder()
                .usuario(loginDTO.getUsuario())
                .senha(loginDTO.getSenha())
                .pessoa(pessoaMapper.voltaPessoa(loginDTO.getPessoa()))
                .build();
    }
    public LoginResponseDTO voltaLoginDTO (Login login) {
        return LoginResponseDTO.builder()
                .id(login.getId())
                .usuario(login.getUsuario())
                .senha(login.getSenha())
                .pessoa(pessoaMapper.voltaPessoaDTO(login.getPessoa()))
                .build();
    }
    public List<LoginResponseDTO> voltaListaLoginDTO (List<Login> listaLogins) {
        List<LoginResponseDTO> listaRetorno = new ArrayList<>();
        listaLogins.stream().forEach(login -> {
            LoginResponseDTO loginResponseDTO = this.voltaLoginDTO(login);
            listaRetorno.add(loginResponseDTO);
        });
        return listaRetorno;
    }

    public void atualizaLoginBanco (Login login, LoginRequestDTO loginRequestDTO){
        login.setUsuario(loginRequestDTO.getUsuario());
        login.setSenha(loginRequestDTO.getSenha());
    }

    public LoginValidarResponseDTO voltaLoginValidadoDTO (Login login) {
        LoginValidarResponseDTO retornaLogin = new LoginValidarResponseDTO();
        retornaLogin.setUsuario(login.getUsuario());
        retornaLogin.setSenha(login.getSenha());
        retornaLogin.setIdPessoa(login.getPessoa().getId());
        return retornaLogin;
    }
}
