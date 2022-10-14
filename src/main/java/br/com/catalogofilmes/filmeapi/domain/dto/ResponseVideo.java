package br.com.catalogofilmes.filmeapi.domain.dto;

import br.com.catalogofilmes.filmeapi.domain.entity.*;
import lombok.*;
import java.util.*;

@Data
public class ResponseVideo {
    private int id;
    private String titulo;
    private String url;
    private int idadeMinima;
    private int idResponsavel;
    private String nomeResponsavel;
    private List<ResponseCategoria> categoriasList;

    public ResponseVideo(Video video) {
        this.id = video.getIdVideo();
        this.titulo =video.getTituloVideo();
        this.url = video.getUrl();
        this.idadeMinima =video.getIdadeMinima();
        this.idResponsavel= video.getResponsavel().getIdResponsavel();
        this.nomeResponsavel = video.getResponsavel().getNomeResponsavel();
        this.categoriasList = video.getListCategorias().stream().map(ResponseCategoria::new).toList();
    }
}

