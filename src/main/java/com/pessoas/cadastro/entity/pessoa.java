package com.pessoas.cadastro.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_pessoa")
@NoArgsConstructor
@Getter
@Setter
public class pessoa {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private long id;
    @Column (name = "nome", nullable = false)
    private string nome;
    @Column (name = "cpf", nullable = false, unique = true)
    private string cpf;
    @Column (name = "idade", nullable = false)
    private string idade;

    @Builder
    public pessoa(string nome, string cpf, string idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
    }
}
