package com.desafiotj.api.service.autor;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiotj.api.domain.autor.Autor;
import com.desafiotj.api.dto.autor.AutorRequestDTO;
import com.desafiotj.api.exception.BusinessException;
import com.desafiotj.api.repositories.AutorRepository;

@Service
public class CadastroAutoresService {

    @Autowired
    private AutorRepository autorRepository;

    public Autor CreateAutor( AutorRequestDTO autoroDTO ){
        Autor newAutor = new Autor();
        newAutor.setNome(autoroDTO.nome());
        newAutor.setLivros(null);
        return autorRepository.save(newAutor);
    }

    public Autor getAutorById(Long id){
        return autorRepository.getReferenceById(id);
    }

    public List<Autor> getAllAutores(){
        return autorRepository.findAll();
    }

    public Autor updateAutor(AutorRequestDTO autoroDTO){

        if( autoroDTO.id() == null || autoroDTO.id() == 0 ) {
            throw new BusinessException("ID informado para atualização do Autor é inválido.");
        }

        Autor autor = autorRepository.findById(autoroDTO.id())
            .orElseThrow(() -> new BusinessException("Autor não encontrado para o ID informado."));

        autor.setNome(autoroDTO.nome());
        autor.setLivros(autoroDTO.livros());
        
        return autorRepository.save(autor);

    }

}
