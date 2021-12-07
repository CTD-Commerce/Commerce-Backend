package com.dh.CTDCommerce.service;
import com.dh.CTDCommerce.dto.ProdutosDTO;
import com.dh.CTDCommerce.persistance.model.Categorias;
import com.dh.CTDCommerce.persistance.model.Produtos;
import com.dh.CTDCommerce.persistance.repository.CategoriasRepository;
import com.dh.CTDCommerce.persistance.repository.ProdutosRepository;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutosService {
    private final Logger logger = Logger.getLogger(ProdutosService.class.getName());

    @Autowired
    private ProdutosRepository produtosRepository;
    @Autowired
    private CategoriasRepository categoriasRepository;

    public Produtos inserirProd(ProdutosDTO produtosDTO){
        Categorias cat = categoriasRepository.getById(produtosDTO.getCategoriasId());
        Produtos prod = new Produtos();
        prod.setNome(produtosDTO.getNome());
        prod.setImagem(produtosDTO.getImagem());
        prod.setPreco(produtosDTO.getPreco());
        prod.setCategorias(cat);
        prod.setDescricao(produtosDTO.getDescricao());
        return  produtosRepository.save(prod);
    }

    public ProdutosDTO convertendoParaDTO(Produtos produtos){
        ProdutosDTO produtosDTO = new ProdutosDTO();
        produtosDTO.setId(produtos.getId());
        produtosDTO.setNome(produtos.getNome());
        produtosDTO.setImagem(produtos.getImagem());
        produtosDTO.setPreco(produtos.getPreco());
        produtosDTO.setCategoriasId(produtos.getCategorias().getId());
        produtosDTO.setDescricao(produtos.getDescricao());
        return produtosDTO;
    }

    public ProdutosService(){
        PropertyConfigurator.configure("log4j.properties");
    }

    public List<ProdutosDTO> selecionarProdutos(){
        try{
            List <Produtos> listaProdutos = produtosRepository.findAll();
            List <ProdutosDTO> listaProdutosDTO = new ArrayList<>();
            for (int i = 0; i < listaProdutos.size(); i++){
                ProdutosDTO produtosDTO = new ProdutosDTO();
                produtosDTO.setId(listaProdutos.get(i).getId());
                produtosDTO.setNome(listaProdutos.get(i).getNome());
                produtosDTO.setImagem(listaProdutos.get(i).getImagem());
                produtosDTO.setPreco(listaProdutos.get(i).getPreco());
                produtosDTO.setCategoriasId(listaProdutos.get(i).getCategorias().getId());
                produtosDTO.setDescricao(listaProdutos.get(i).getDescricao());

                listaProdutosDTO.add(produtosDTO);
            }
            return listaProdutosDTO;
        }catch(Exception exc){
            logger.error("Erro ao selecionar todas os produtos.");
            return null;
        }
    }

    public ProdutosDTO selecionarProdutosId(Integer id){
        try {
            Produtos produto = produtosRepository.getById(id);
            return this.convertendoParaDTO(produto);
        }catch(Exception exc){
            logger.error("Erro ao buscar o produto pelo id " + id);
            return null;
        }
    }
// mostrar os produtos que tem o categoria_id
    public List<ProdutosDTO> selectCatProd(Integer id) {
        try{
            Categorias cat = categoriasRepository.getById(id);
            List<Produtos> listaProdutos = produtosRepository.listarProdutos(cat);
            List <ProdutosDTO> listaProdutosDTO = new ArrayList<>();

            if (id == cat.getId()){
                for (int i = 0; i < listaProdutos.size(); i++) {
                    ProdutosDTO produtosDTO = new ProdutosDTO();
                    produtosDTO.setId(listaProdutos.get(i).getId());
                    produtosDTO.setNome(listaProdutos.get(i).getNome());
                    produtosDTO.setImagem(listaProdutos.get(i).getImagem());
                    produtosDTO.setPreco(listaProdutos.get(i).getPreco());
                    produtosDTO.setDescricao(listaProdutos.get(i).getDescricao());
                    produtosDTO.setCategoriasId(listaProdutos.get(i).getCategorias().getId());

                    listaProdutosDTO.add(produtosDTO);
                }
            }

            return listaProdutosDTO;
        }catch(Exception exc){
            logger.error("Erro ao buscar os produtos pela categoria");
            return null;
        }
    }
}
