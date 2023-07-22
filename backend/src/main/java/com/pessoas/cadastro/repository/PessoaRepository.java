package com.pessoas.cadastro.repository;

import com.pessoas.cadastro.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository <Pessoa,Long> {


}
