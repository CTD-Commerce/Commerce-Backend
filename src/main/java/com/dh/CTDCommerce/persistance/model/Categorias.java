package com.dh.CTDCommerce.persistance.model;
import javax.persistence.*;

@Table @Entity
public class Categorias {

    @Id
    @SequenceGenerator(name="categorias_sequencia", sequenceName = "categorias_sequencia", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categorias_sequencia")
    private Integer id;
    private String nome;

    public Categorias(String nome) {
        this.nome = nome;
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
}
