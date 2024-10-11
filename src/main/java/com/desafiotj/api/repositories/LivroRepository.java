package com.desafiotj.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafiotj.api.domain.livro.Livro;

public interface LivroRepository extends JpaRepository<Livro,Long>{

}
