package com.desafiotj.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafiotj.api.domain.autor.Autor;

public interface AutorRepository extends JpaRepository<Autor,Long>{

}
