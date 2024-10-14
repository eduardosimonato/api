package com.desafiotj.api.controller.livro;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafiotj.api.domain.livro.Livro;
import com.desafiotj.api.dto.livro.LivroRequestDTO;
import com.desafiotj.api.service.livro.CadastroLivrosService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/livro")
public class CadastroLivroController {

    @Autowired
    private CadastroLivrosService cadastroLivrosService;

    @PostMapping
    public ResponseEntity<Livro> create (@Valid @RequestBody LivroRequestDTO livroRequestDTO) {
        System.out.println(livroRequestDTO);
        Livro newLivro = this.cadastroLivrosService.createLivro(livroRequestDTO);
        return ResponseEntity.ok(newLivro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> getById(@PathVariable Long id) {
        Livro livro = this.cadastroLivrosService.getLivroById(id);
        return ResponseEntity.ok(livro);
    }

    @GetMapping
    public ResponseEntity<List<Livro>> getAll() {
        List<Livro> livros = this.cadastroLivrosService.getAllLivros();
        return ResponseEntity.ok(livros);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> update( @PathVariable Long id, @Valid @RequestBody LivroRequestDTO livroRequestDTO) {
        Livro livro = this.cadastroLivrosService.updateLivro(livroRequestDTO);
        return ResponseEntity.ok(livro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cadastroLivrosService.deleteLivroById(id);
        return ResponseEntity.noContent().build();  // Retorna 204 No Content após deletar
    }    

}
