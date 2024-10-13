package com.desafiotj.api.dto.assunto;

import java.util.List;
import com.desafiotj.api.domain.livro.Livro;

public record AssuntoRequestDTO( Long id, String descricao, List<Livro> livros ) {

}
