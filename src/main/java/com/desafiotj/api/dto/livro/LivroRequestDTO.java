package com.desafiotj.api.dto.livro;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import com.desafiotj.api.domain.assunto.Assunto;
import com.desafiotj.api.domain.autor.Autor;

public record LivroRequestDTO( 
    Long id,

    @NotBlank(message = "O título é obrigatório.")
    @Size(max = 255, message = "O título deve ter no máximo 255 caracteres.")
    String titulo, 
    
    @NotNull(message = "A editora é obrigatória.")
    String editora, 
    
    @NotNull(message = "O número da edição é obrigatória.")
    Integer edicao,

    @NotNull(message = "O ano da publição é obrigatório.")
    @Pattern(regexp = "^[0-9]{4}$", message = "O ano de publicação deve ter 4 dígitos.")
    String anopublicacao, 
    
    List<Autor> autores, List<Assunto> assuntos ) {

}
