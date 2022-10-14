package br.com.catalogofilmes.filmeapi.domain.dto;

import lombok.*;

import javax.validation.constraints.*;

@Data
public class RequestCategoria {
    @NotEmpty
    @Size(max = 40)
    private String nomeCategoria;
}
