package com.desafiotj.api.controller.autor;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafiotj.api.domain.autor.Autor;
import com.desafiotj.api.dto.autor.AutorRequestDTO;
import com.desafiotj.api.service.autor.CadastroAutoresService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/autor")
public class CadastroAutorController {

    @Autowired
    private CadastroAutoresService cadastroAutoresService;

    @PostMapping
    public ResponseEntity<Autor> create (@RequestBody AutorRequestDTO autorRequestDTO) {
        Autor newAutor = this.cadastroAutoresService.CreateAutor(autorRequestDTO);
        return ResponseEntity.ok(newAutor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> getById(@PathVariable Long id) {
        Autor autor = this.cadastroAutoresService.getAutorById(id);
        return ResponseEntity.ok(autor);
    }

    @GetMapping
    public ResponseEntity<List<Autor>> getAll() {
        List<Autor> autores = this.cadastroAutoresService.getAllAutores();
        return ResponseEntity.ok(autores);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> update( @PathVariable Long id, @Valid @RequestBody AutorRequestDTO autoRequestDTO) {
        Autor autor = this.cadastroAutoresService.updateAutor(autoRequestDTO);
        return ResponseEntity.ok(autor);
    }

}
