package com.pessoas.cadastro.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_pessoa")
@NoArgsConstructor
@Getter
@Setter
public class Pessoa {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private long id;
    @Column (name = "nome", nullable = false)
    private String nome;
    @Column (name = "cpf", nullable = false, unique = true)
    private String cpf;
    @Column (name = "idade", nullable = false)
    private String idade;

    @Builder
    public Pessoa(String nome, String cpf, String idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }
}
