package com.dh.CTDCommerce.controller;
import com.dh.CTDCommerce.persistance.model.Produtos;
import com.dh.CTDCommerce.service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController @RequestMapping("produtos")
public class ProdutosController {

    @Autowired
    private ProdutosService produtosService;

    @GetMapping
    public ResponseEntity<List<Produtos>> selecionarProdutos(){
        return ResponseEntity.ok(produtosService.selecionarProdutos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produtos> selecionarProdutosId(@PathVariable Integer id){
        return ResponseEntity.ok(produtosService.selecionarProdutosId(id));
    }

}
