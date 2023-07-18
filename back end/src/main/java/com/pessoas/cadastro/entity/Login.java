package com.pessoas.cadastro.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_login")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of="id")
public class Login {
    @Id
    private Long id;
    @Column (name = "usuario", nullable = false, unique = true)
    private String usuario;
    @Column (name = "senha", nullable = false)
    private String senha;
    @Enumerated(EnumType.STRING)
    private PerfilUsuario perfil;
    @OneToOne(mappedBy = "login")
    @MapsId
    private Pessoa pessoa;

    @Builder
    public Login(String usuario, String senha, PerfilUsuario perfil, Pessoa pessoa) {
        this.usuario = usuario;
        this.senha = senha;
        this.perfil = perfil;
        this.pessoa = pessoa;
    }
}
