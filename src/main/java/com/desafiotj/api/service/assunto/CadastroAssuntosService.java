package com.desafiotj.api.service.assunto;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiotj.api.domain.assunto.Assunto;
import com.desafiotj.api.dto.assunto.AssuntoRequestDTO;
import com.desafiotj.api.exception.BusinessException;
import com.desafiotj.api.repositories.AssuntoRepository;

@Service
public class CadastroAssuntosService {

    @Autowired
    private AssuntoRepository assuntoRepository;

    public Assunto CreateAssunto( AssuntoRequestDTO assuntoDTO ){
        Assunto newAssunto = new Assunto();
        newAssunto.setDescricao(assuntoDTO.descricao());
        newAssunto.setLivros(null);
        return assuntoRepository.save(newAssunto);
    }

    public Assunto getAssuntoById(Long id){
        return assuntoRepository.getReferenceById(id);
    }

    public List<Assunto> getAllAssuntos(){
        return assuntoRepository.findAll();
    }

    public Assunto updateAssunto(AssuntoRequestDTO assuntoDTO){

        if( assuntoDTO.id() == null || assuntoDTO.id() == 0 ) {
            throw new BusinessException("ID informado para atualização do Assunto é inválido.");
        }

        Assunto assunto = assuntoRepository.findById(assuntoDTO.id())
            .orElseThrow(() -> new BusinessException("Assunto não encontrado para o ID informado."));

        assunto.setDescricao(assuntoDTO.descricao());
        assunto.setLivros(assuntoDTO.livros());
        
        return assuntoRepository.save(assunto);

    }

}
