package com.gs.preventapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TIPO_DESASTRE")
public class TipoDesastre {

    @Id
    private Integer id;

    private String nome;

    private String descricao;

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
