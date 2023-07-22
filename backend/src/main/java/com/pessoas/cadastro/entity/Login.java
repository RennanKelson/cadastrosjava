package com.pessoas.cadastro.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private Long id;
    @Column (name = "usuario", nullable = false, unique = true)
    private String usuario;
    @Column (name = "senha", nullable = false)
    private String senha;
    @Enumerated(EnumType.STRING)
    private PerfilUsuario perfil;
    @OneToOne
    @JoinColumn (name = "pessoa_id")
    private Pessoa pessoa;

    @Builder
    public Login(String usuario, String senha, PerfilUsuario perfil, Pessoa pessoa) {
        this.usuario = usuario;
        this.senha = senha;
        this.perfil = perfil;
        this.pessoa = pessoa;
    }
}
