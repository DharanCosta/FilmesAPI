package br.com.catalogofilmes.filmeapi.repository;

import br.com.catalogofilmes.filmeapi.domain.entity.*;
import org.springframework.data.jpa.repository.*;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
