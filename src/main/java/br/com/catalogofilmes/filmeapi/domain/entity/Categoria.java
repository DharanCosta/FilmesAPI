package br.com.catalogofilmes.filmeapi.domain.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="Categoria")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler", "listVideo"})
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCategoria")
    private int idCategoria;
    @Column(name = "NomeCategoria")
    private String nomeCategoria;

    @JsonBackReference
    @ManyToMany(mappedBy = "listCategorias", fetch = FetchType.LAZY)
    private List<Video> listVideo;

}
