package br.com.catalogofilmes.filmeapi.domain.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.*;

@Entity
@Table(name = "Video")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdVideo")
    private int idVideo;
    @Column(name="TituloVideo", columnDefinition = "nvarchar(255)")
    private String tituloVideo;
    @Column(name="URL", columnDefinition = "nvarchar(2083)")
    private String url;
    @Column(name="IdadeMinima", columnDefinition = "tinyint")
    private int idadeMinima;
    @ManyToOne
    @JoinColumn(name = "idResponsavel")
    private Responsavel responsavel;

    @JsonManagedReference
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "VideoCategoria",
            joinColumns = @JoinColumn(name="idVideo", referencedColumnName = "IdVideo"),
            inverseJoinColumns = @JoinColumn(name="idCategoria", referencedColumnName = "IdCategoria")
    )
    private List<Categoria> listCategorias;
}
