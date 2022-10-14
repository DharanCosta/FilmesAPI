package br.com.catalogofilmes.filmeapi.domain.dto;

import lombok.*;

import javax.validation.constraints.*;

@Data
public class RequestResponsavel {
    @NotNull
    @NotEmpty
    @Size(max=50)
    private String nomeResponsavel;
}
