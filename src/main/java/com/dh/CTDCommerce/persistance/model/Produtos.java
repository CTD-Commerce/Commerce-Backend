package com.dh.CTDCommerce.persistance.model;
import javax.persistence.*;

@Table @Entity
public class Produtos {
    @Id
    @SequenceGenerator(name="produtos_sequencia", sequenceName = "produtos_sequencia", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produtos_sequencia")
    private Integer id;
    private String nome;
    private Double valor;
    private String descricao;
    private String imagem;

    public Produtos(String nome, Double valor, String descricao, String imagem) {
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.imagem = imagem;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
