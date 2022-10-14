package br.com.catalogofilmes.filmeapi.domain.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Responsavel")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Responsavel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdResponsavel")
    private int idResponsavel;
    @Column(name = "NomeResponsavel")
    private String nomeResponsavel;
    @JsonBackReference
    @OneToMany(mappedBy = "responsavel")
    private List<Video> video;
}
