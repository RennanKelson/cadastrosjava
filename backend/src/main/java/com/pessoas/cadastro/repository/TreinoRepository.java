package com.pessoas.cadastro.repository;

import com.pessoas.cadastro.entity.Treino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreinoRepository extends JpaRepository <Treino, Long> {
}
