package com.desafiotj.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafiotj.api.domain.assunto.Assunto;

public interface AssuntoRepository extends JpaRepository<Assunto,Long>{

}
