package br.com.catalogofilmes.filmeapi.domain.dto;

import lombok.*;

@Data
public class PaginatedSearchRequest {
    private Integer PaginaAtual;
    private Integer QtdPorPagina;
}
