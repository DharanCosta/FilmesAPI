package br.com.catalogofilmes.filmeapi.controller;

import br.com.catalogofilmes.filmeapi.domain.dto.*;
import br.com.catalogofilmes.filmeapi.domain.entity.*;
import br.com.catalogofilmes.filmeapi.service.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/categoria")
@RequiredArgsConstructor
public class CategoriaController {
    private final CategoriaService categoriaService;

    @GetMapping("/listar")
    public ResponseEntity<ResponseBase<List<ResponseCategoria>>> listarCategorias(){
        var list =categoriaService.findListaCategoria();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<Categoria> cadastrarCategoria(@RequestBody RequestCategoria request){
        Categoria categoria = categoriaService.cadastrarCategoria(request);
        return ResponseEntity.ok(categoria);
    }

}
