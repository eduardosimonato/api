package com.desafiotj.api.controller.assunto;

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

import com.desafiotj.api.domain.assunto.Assunto;
import com.desafiotj.api.dto.assunto.AssuntoRequestDTO;
import com.desafiotj.api.service.assunto.CadastroAssuntosService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/assunto")
public class CadastroAssuntoController {

    @Autowired
    private CadastroAssuntosService cadastroAssuntosService;

     @PostMapping
    public ResponseEntity<Assunto> create (@RequestBody AssuntoRequestDTO assuntoRequestDTO) {
        Assunto newAssunto = this.cadastroAssuntosService.CreateAssunto(assuntoRequestDTO);
        return ResponseEntity.ok(newAssunto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assunto> getById(@PathVariable Long id) {
        Assunto assunto = this.cadastroAssuntosService.getAssuntoById(id);
        return ResponseEntity.ok(assunto);
    }

    @GetMapping
    public ResponseEntity<List<Assunto>> getAll() {
        List<Assunto> assuntos = this.cadastroAssuntosService.getAllAssuntos();
        return ResponseEntity.ok(assuntos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Assunto> update(@PathVariable Long id, @Valid @RequestBody AssuntoRequestDTO assuntoRequestDTO) {
        Assunto assunto = this.cadastroAssuntosService.updateAssunto(assuntoRequestDTO);
        return ResponseEntity.ok(assunto);
    }

}
