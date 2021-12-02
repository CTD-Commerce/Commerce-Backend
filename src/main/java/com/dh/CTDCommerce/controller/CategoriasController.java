package com.dh.CTDCommerce.controller;
import com.dh.CTDCommerce.persistance.model.Categorias;
import com.dh.CTDCommerce.service.CategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @RequestMapping("categorias")
public class CategoriasController {

    @Autowired
    private CategoriasService categoriasService;

    @GetMapping
    public ResponseEntity<List<Categorias>> selecionarDentistas() {
        return ResponseEntity.ok(categoriasService.selecionarCategorias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categorias> selecionarCategoriasId(@PathVariable Integer id) {
        return ResponseEntity.ok(categoriasService.selecionarCategoriasId(id));
    }
}
