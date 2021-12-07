package com.dh.CTDCommerce.persistance.repository;
import com.dh.CTDCommerce.persistance.model.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Integer> {
    @Query("SELECT c.nome FROM Categorias c")
    List<String> nomesCategorias();
}
