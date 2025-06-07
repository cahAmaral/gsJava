package com.gs.preventapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "REGIAO")
public class Regiao {

    @Id
    @Column(name = "id_regiao")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome_regiao", nullable = false, length = 30)
    private String nome;

    @Column(name = "estado_regiao", nullable = false, length = 40)
    private String estado;

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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

