package com.desafiotj.api.service.livro;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.desafiotj.api.domain.assunto.Assunto;
import com.desafiotj.api.domain.autor.Autor;
import com.desafiotj.api.domain.livro.Livro;
import com.desafiotj.api.dto.livro.LivroRequestDTO;
import com.desafiotj.api.exception.BusinessException;
import com.desafiotj.api.repositories.AssuntoRepository;
import com.desafiotj.api.repositories.AutorRepository;
import com.desafiotj.api.repositories.LivroRepository;

@Service
public class CadastroLivrosService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private AssuntoRepository assuntoRepository;

    public Livro createLivro( LivroRequestDTO livroDTO ){
        
        Livro newLivro = new Livro();
        newLivro.setTitulo(livroDTO.titulo());
        newLivro.setEdicao(livroDTO.edicao());
        newLivro.setEditora(livroDTO.editora());
        newLivro.setAnopublicacao(livroDTO.anopublicacao());

        // Persistir os autores individualmente se ainda não estiverem no banco
        List<Autor> autores = livroDTO.autores().stream()
        .map(autor -> {
            if (autor.getId() == null) {
                return autorRepository.save(autor);
            } else {
                return autorRepository.findById(autor.getId())
                                      .orElseGet(() -> autorRepository.save(autor));
            }
        })
        .collect(Collectors.toList());
    
        newLivro.setAutores(autores);

        List<Assunto> assuntos = livroDTO.assuntos().stream()
            .map(assunto -> {
                if (assunto.getId() == null) {
                    return assuntoRepository.save(assunto);
                } else {
                    return assuntoRepository.findById(assunto.getId())
                                          .orElseGet(() -> assuntoRepository.save(assunto));
                }
            })
            .collect(Collectors.toList());

        newLivro.setAssuntos(assuntos);
        
        return livroRepository.save(newLivro);  

    }

    public Livro getLivroById(Long id){
        return livroRepository.getReferenceById(id);
    }

    public List<Livro> getAllLivros(){
        return livroRepository.findAll();
    }

    public Livro updateLivro(LivroRequestDTO livroDTO){

        if( livroDTO.id() == null || livroDTO.id() == 0 ) {
            throw new BusinessException("ID informado para atualização do Livro é inválido.");
        }

        Livro livro = livroRepository.findById(livroDTO.id())
            .orElseThrow(() -> new BusinessException("Livro não encontrado para o ID informado."));

        livro.setAnopublicacao(livroDTO.anopublicacao());
        livro.setTitulo(livroDTO.titulo());
        livro.setEditora(livroDTO.editora());
        livro.setEdicao(livroDTO.edicao());
        livro.setAnopublicacao(livroDTO.anopublicacao());
        livro.setAssuntos(livroDTO.assuntos());
        livro.setAutores(livroDTO.autores());

        return livroRepository.save(livro);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    public void deleteLivroById(Long id) {
        Livro livro = livroRepository.findById(id)
            .orElseThrow(() -> new BusinessException("Livro não encontrado para o ID informado."));
        livroRepository.deleteById(id);
    }

}
