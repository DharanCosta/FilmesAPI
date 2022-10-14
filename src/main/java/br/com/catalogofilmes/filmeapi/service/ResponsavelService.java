package br.com.catalogofilmes.filmeapi.service;

import br.com.catalogofilmes.filmeapi.domain.dto.*;
import br.com.catalogofilmes.filmeapi.domain.entity.*;
import br.com.catalogofilmes.filmeapi.repository.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.server.*;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ResponsavelService {
    private final ResponsavelRepository responsavelRepository;

    public List<Responsavel> listarResponsavel(){
        List<Responsavel> responsavelList =responsavelRepository.findAll();
        if (responsavelList.isEmpty())throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Lista de responsaveis está vazia");
        return responsavelList;
    }

    public Responsavel listarPorId(Integer id){
        Optional<Responsavel> responsavel =responsavelRepository.findById(id);
        if (responsavel.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Responsavel de Id "+id+" não encontrado");
        return responsavel.get();
    }

    public Responsavel cadastrarResponsavel(RequestResponsavel request) {
        Responsavel novoResponsavel = new Responsavel();
        if (request.getNomeResponsavel().length()>50 || request.getNomeResponsavel().isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "É necessário que  nome do Responsavel seja menor que 50 caracteres e não seja nulo");
        novoResponsavel.setNomeResponsavel(request.getNomeResponsavel());
        responsavelRepository.save(novoResponsavel);
        return novoResponsavel;
    }
}
