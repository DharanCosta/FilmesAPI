package br.com.catalogofilmes.filmeapi.domain.dto;

import br.com.catalogofilmes.filmeapi.domain.entity.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCategoria {
    private int idCategoria;
    private String nomeCategoria;

    public ResponseCategoria(Categoria categoria){
            this.idCategoria = categoria.getIdCategoria();
            this.nomeCategoria = categoria.getNomeCategoria();
    }
}
