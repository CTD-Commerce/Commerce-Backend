package com.dh.CTDCommerce.persistance.repository;
import com.dh.CTDCommerce.persistance.model.Categorias;
import com.dh.CTDCommerce.persistance.model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Integer> {

    @Query("SELECT p FROM Produtos p WHERE p.categorias = ?1")
    List<Produtos> listarProdutos(Categorias categorias);

}
