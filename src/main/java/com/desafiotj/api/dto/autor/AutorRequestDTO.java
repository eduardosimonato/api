package com.desafiotj.api.dto.autor;

import java.util.List;
import com.desafiotj.api.domain.livro.Livro;

public record AutorRequestDTO( Long id, String nome, List<Livro> livros ) {

}
