package com.dh.CTDCommerce.persistance.repository;
import com.dh.CTDCommerce.persistance.model.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Integer> {
}
