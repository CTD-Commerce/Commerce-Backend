package com.dh.CTDCommerce.service;

import com.dh.CTDCommerce.persistance.model.Categorias;
import com.dh.CTDCommerce.persistance.repository.CategoriasRepository;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriasService {

    private final Logger logger = Logger.getLogger(CategoriasService.class.getName());

    @Autowired
    private CategoriasRepository categoriasRepository;

    public CategoriasService(){
        PropertyConfigurator.configure("log4j.properties");
    }

    public List<Categorias> selecionarCategorias(){
        try{
            return categoriasRepository.findAll();
        }catch(Exception exc){
            logger.error("Erro ao selecionar todas as categorias.");
            return null;
        }
    }

    public Categorias selecionarCategoriasId(Integer id){
        try {
            return categoriasRepository.findById(id).get();
        }catch(Exception exc){
            logger.error("Erro ao buscar a categoria pelo id " + id);
            return null;
        }
    }
}
