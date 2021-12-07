package com.dh.CTDCommerce.controller;
import com.dh.CTDCommerce.dto.ProdutosDTO;
import com.dh.CTDCommerce.persistance.model.Produtos;
import com.dh.CTDCommerce.service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("produtos")
public class ProdutosController {

    @Autowired
    private ProdutosService produtosService;

    @GetMapping
    public ResponseEntity<List<ProdutosDTO>> selecionarProdutos(){
        return ResponseEntity.ok(produtosService.selecionarProdutos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutosDTO> selecionarProdutosId(@PathVariable Integer id){
        return ResponseEntity.ok(produtosService.selecionarProdutosId(id));
    }

    @GetMapping("categorias/{id}")
    public ResponseEntity<List<ProdutosDTO>> selectProdCat(@PathVariable Integer id) {
        return ResponseEntity.ok(produtosService.selectCatProd(id));
    }

    @PostMapping
    public ResponseEntity<ProdutosDTO> criarProduto(@RequestBody ProdutosDTO produtosDTO){
        Produtos produtos = produtosService.inserirProd(produtosDTO);
        return ResponseEntity.ok(produtosService.convertendoParaDTO(produtos));
    }

}
