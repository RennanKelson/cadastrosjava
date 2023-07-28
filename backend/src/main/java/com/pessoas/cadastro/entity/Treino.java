package com.pessoas.cadastro.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "tb_treino")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Treino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private Long id;
    @Column (name = "exercicio", nullable = false)
    private String exercicio;
    @Column (name = "serie", nullable = false)
    private String serie;
    @Column (name = "intervalo", nullable = false)
    private String intervalo;
    private String intensidade;
    @ManyToOne
    @JoinColumn(name="pessoa_id")
    private Pessoa pessoa;
    @Builder
    public Treino(String exercicio, String serie, String intervalo, String intensidade) {
        this.exercicio = exercicio;
        this.serie = serie;
        this.intervalo = intervalo;
        this.intensidade = intensidade;
    }
}
