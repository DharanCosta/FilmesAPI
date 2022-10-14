package br.com.catalogofilmes.filmeapi.controller;

import br.com.catalogofilmes.filmeapi.domain.dto.*;
import br.com.catalogofilmes.filmeapi.service.*;
import lombok.*;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/video")
@RequiredArgsConstructor
public class VideoController {

    private final VideoService service;

    @GetMapping("/listar")
    public ResponseEntity<ResponseBase<Page<ResponseVideo>>> getVideos(PaginatedSearchRequest paginatedSearchRequest){
        var responseBase = service.getVideos(paginatedSearchRequest);
        return ResponseEntity.ok(responseBase);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBase<ResponseVideo>> getVideoById(@PathVariable Integer id){
        var responseBase = service.getVideoById(id);
        return ResponseEntity.ok(responseBase) ;
    }

    @PostMapping
    public ResponseEntity<ResponseBase<ResponseVideo>> cadastroVideo(@RequestBody  RequestVideo resquest){
        var response = service.postVideos(resquest);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBase<ResponseVideo>> updateVideoURL(@PathVariable Integer id, String url){
        var response = service.updateVideoURL(id, url);
        return ResponseEntity.ok(response);
    }
}
