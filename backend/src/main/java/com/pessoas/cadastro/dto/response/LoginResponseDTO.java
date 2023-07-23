package com.pessoas.cadastro.dto.response;

import com.pessoas.cadastro.entity.Login;
import com.pessoas.cadastro.entity.PerfilUsuario;
import com.pessoas.cadastro.entity.Pessoa;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class LoginResponseDTO {
    private Long id;
    private String usuario;
    private String senha;
    private PerfilUsuario perfil;
    private PessoaResponseDTO pessoa;
}
