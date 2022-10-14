package br.com.catalogofilmes.filmeapi.domain.dto;

import lombok.*;
import javax.validation.constraints.*;
import java.util.*;

@Data
public class RequestVideo {
    @NotEmpty
    @NotNull
    @Size(max = 255)
    private String titulo;
    @NotEmpty
    @NotNull
    @Size(max = 2083)
    private String url;
    private int idadeMinima;
    @NotNull
    @NotEmpty
    private int idResponsavel;
    @NotNull
    @NotEmpty
    private List<Integer> idsCategoria;
}
