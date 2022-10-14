package br.com.catalogofilmes.filmeapi.controller;

import br.com.catalogofilmes.filmeapi.domain.dto.*;
import br.com.catalogofilmes.filmeapi.domain.entity.*;
import br.com.catalogofilmes.filmeapi.service.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/responsavel")
@RequiredArgsConstructor
public class ResponsavelController {

    private final ResponsavelService responsavelService;

    @GetMapping("/listar")
    public ResponseEntity<List<Responsavel>> listarResponsaveis(){
        return ResponseEntity.ok( responsavelService.listarResponsavel());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Responsavel> encontrarPorId(@PathVariable Integer id){
        Responsavel responsavelEncontrado = responsavelService.listarPorId(id);
        return ResponseEntity.ok(responsavelEncontrado);
    }

    @PostMapping
    public ResponseEntity<Responsavel> cadastrarResponsavel(RequestResponsavel request){
        Responsavel novoResponsavel = responsavelService.cadastrarResponsavel(request);
        return ResponseEntity.ok(novoResponsavel);
    }
}
