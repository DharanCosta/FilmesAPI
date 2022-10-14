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
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public ResponseBase<List<ResponseCategoria>> findListaCategoria() {
        var list = categoriaRepository.findAll();
        if (list.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Lista de categorias está vazia");
        List<ResponseCategoria> responseCategorias = new ArrayList<>();
        for (Categoria categoria : list) {
            responseCategorias.add(new ResponseCategoria(categoria));
        }
        return new ResponseBase<>(responseCategorias);
    }

    public Categoria cadastrarCategoria(RequestCategoria request) {
        Categoria novaCategoria = new Categoria();
        if(request.getNomeCategoria() == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoria não pode ser null");
        novaCategoria.setNomeCategoria(request.getNomeCategoria());
        categoriaRepository.save(novaCategoria);
        return novaCategoria;
    }
}
