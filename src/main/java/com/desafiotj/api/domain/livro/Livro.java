package com.desafiotj.api.domain.livro;

import java.util.List;

import org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor;

import com.desafiotj.api.domain.assunto.Assunto;
import com.desafiotj.api.domain.autor.Autor;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String editora;
    private Integer edicao;
    private String anopublicacao;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "livro_autor", 
        joinColumns = @JoinColumn(name = "livro_id"), 
        inverseJoinColumns = @JoinColumn(name = "autor_id"))
    private List<Autor> autores;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "livro_assunto", 
        joinColumns = @JoinColumn(name = "livro_id"), 
        inverseJoinColumns = @JoinColumn(name = "assunto_id"))
    private List<Assunto> assuntos;

    @JsonIgnore
    private transient ByteBuddyInterceptor hibernateLazyInitializer;

}
