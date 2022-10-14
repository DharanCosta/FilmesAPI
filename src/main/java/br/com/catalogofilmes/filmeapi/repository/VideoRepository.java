package br.com.catalogofilmes.filmeapi.repository;

import br.com.catalogofilmes.filmeapi.domain.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.*;

import java.util.*;

public interface VideoRepository extends JpaRepository<Video,Integer>, PagingAndSortingRepository<Video, Integer> {
    @Query(value = "SELECT V FROM Video V JOIN FETCH V.listCategorias WHERE V IN :listVideo")
    void findAllVideoFetchCategoria(List<Video> listVideo);

}
