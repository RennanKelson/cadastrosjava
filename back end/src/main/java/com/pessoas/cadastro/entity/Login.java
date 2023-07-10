package com.pessoas.cadastro.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_login")
@NoArgsConstructor
@Getter
@Setter
public class Login {
    @Id
    private Long id;
    @Column (name = "usuario", nullable = false, unique = true)
    private String usuario;
    @Column (name = "senha", nullable = false)
    private String senha;
    @Column (name = "email", nullable = false)
    private String email;
    @MapsId
    @OneToOne
    private Pessoa pessoa;

    @Builder
    public Login(String usuario, String senha, String email, Pessoa pessoa) {
        this.usuario = usuario;
        this.senha = senha;
        this.email = email;
        this.pessoa = pessoa;
    }
}
