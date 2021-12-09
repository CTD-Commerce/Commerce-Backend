package com.dh.CTDCommerce.controller;
import com.dh.CTDCommerce.persistance.model.Categorias;
import com.dh.CTDCommerce.service.CategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("categorias")
public class CategoriasController {

    @Autowired
    private CategoriasService categoriasService;

    @GetMapping
    public ResponseEntity<List<String>> selecionarCategorias() {
        return ResponseEntity.ok(categoriasService.selecionarCategorias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categorias> selecionarCategoriasId(@PathVariable Integer id) {
        return ResponseEntity.ok(categoriasService.selecionarCategoriasId(id));
    }

    @PostMapping
    public ResponseEntity<Categorias> criarCategoria(@RequestBody Categorias cat){
        return ResponseEntity.ok(categoriasService.inserirCat(cat));
    }
}
