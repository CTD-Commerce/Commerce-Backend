package com.dh.CTDCommerce.service;
import com.dh.CTDCommerce.persistance.model.Produtos;
import com.dh.CTDCommerce.persistance.repository.ProdutosRepository;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutosService {
    private final Logger logger = Logger.getLogger(ProdutosService.class.getName());

    @Autowired
    private ProdutosRepository produtosRepository;

    public ProdutosService(){
        PropertyConfigurator.configure("log4j.properties");
    }

    public List<Produtos> selecionarProdutos(){
        try{
            return produtosRepository.findAll();
        }catch(Exception exc){
            logger.error("Erro ao selecionar todas os produtos.");
            return null;
        }
    }

    public Produtos selecionarProdutosId(Integer id){
        try {
            return produtosRepository.findById(id).get();
        }catch(Exception exc){
            logger.error("Erro ao buscar o produto pelo id " + id);
            return null;
        }
    }

}
