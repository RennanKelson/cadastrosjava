package com.pessoas.cadastro.util;

import com.pessoas.cadastro.dto.request.LoginRequestDTO;
import com.pessoas.cadastro.dto.response.LoginResponseDTO;
import com.pessoas.cadastro.entity.Login;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class LoginMapper {
    public Login voltaLogin (LoginRequestDTO loginDTO) {
        return Login.builder()
                .usuario(loginDTO.getUsuario())
                .senha(loginDTO.getSenha())
                .build();
    }
    public LoginResponseDTO voltaLoginDTO (Login login) {
        return new LoginResponseDTO(login);
    }
    public List<LoginResponseDTO> voltaListaLoginDTO (List<Login> listaLogins) {
        return listaLogins.stream().map(LoginResponseDTO::new).collect(Collectors.toList());
    }

    public void atualizaLoginBanco (Login login, LoginRequestDTO loginRequestDTO){
        login.setUsuario(loginRequestDTO.getUsuario());
        login.setSenha(loginRequestDTO.getSenha());
    }
}
