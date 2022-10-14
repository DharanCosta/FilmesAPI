package br.com.catalogofilmes.filmeapi.service;

import br.com.catalogofilmes.filmeapi.domain.dto.*;
import br.com.catalogofilmes.filmeapi.domain.entity.*;
import br.com.catalogofilmes.filmeapi.repository.*;
import lombok.*;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.*;

import java.util.*;

@Service
@RequiredArgsConstructor
public class VideoService {
    private final VideoRepository videoRepository;

    private final CategoriaRepository categoriaRepository;

    private final ResponsavelRepository responsavelRepository;

    public ResponseBase<Page<ResponseVideo>> getVideos(PaginatedSearchRequest request){
        if (request.getPaginaAtual() < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O indice da página atual deve começar em 0");
        }
        if (request.getQtdPorPagina() < 1 || request.getQtdPorPagina() > 50) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Quantidade de itens por página deve ser entre 1 e 50 itens");
        }
        PageRequest pageRequest = PageRequest.of(request.getPaginaAtual(), request.getQtdPorPagina());
        Page<Video> page = videoRepository.findAll(pageRequest);
        videoRepository.findAllVideoFetchCategoria(page.stream().toList());

        return new ResponseBase<>(page.map(ResponseVideo::new));
    }

    public ResponseBase<ResponseVideo> getVideoById(Integer id){
      Optional<Video> video= videoRepository.findById(id);
        if (video.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Video não encontrado com esse ID");
        }
        Video videoFound = video.get();
        ResponseVideo responseVideo = new ResponseVideo(videoFound);
        return new ResponseBase<>(responseVideo);
    }

    public ResponseBase<ResponseVideo> postVideos(RequestVideo resquest) {
        Video novoVideo = new Video();
        novoVideo.setTituloVideo(resquest.getTitulo());
        novoVideo.setUrl(resquest.getUrl());
        novoVideo.setIdadeMinima(resquest.getIdadeMinima());

        Optional<Responsavel> responsavel = responsavelRepository.findById(resquest.getIdResponsavel());
        if (responsavel.isEmpty()) throw new IllegalArgumentException("Responsável não encontrado");
        novoVideo.setResponsavel(responsavel.get());

        List<Categoria> categorias = new ArrayList<>();
        for(int i =0;i<resquest.getIdsCategoria().size(); i++){
           var categoriaId =  resquest.getIdsCategoria().get(i);
            Optional<Categoria> categoria =categoriaRepository.findById(categoriaId);
           if(categoria.isEmpty())throw new IllegalArgumentException("Categoria de ID: "+categoriaId+" ,não foi encontrada");
           categorias.add(categoria.get());
        }
        novoVideo.setListCategorias(categorias);

        videoRepository.save(novoVideo);       
        ResponseVideo responseVideo = new ResponseVideo(novoVideo);
        return new ResponseBase<>(responseVideo);
    }

    public ResponseBase<ResponseVideo> updateVideoURL(Integer id, String newURL) {
      Optional<Video> videoOptional = videoRepository.findById(id);
        if (videoOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Video não encontrado com esse Id");
        }
        Video foundVideo = videoOptional.get();
        foundVideo.setUrl(newURL);
        videoRepository.save(foundVideo);
        ResponseVideo responseVideo = new ResponseVideo(videoOptional.get());
        return new ResponseBase<>(responseVideo);
    }
}
