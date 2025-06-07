package com.gs.preventapi.dto;

public class DicaDTO {

    private Integer id;
    private String titulo;
    private String descricao;
    private Integer tipoDesastreId;

    public DicaDTO() {
    }

    public DicaDTO(Integer id, String titulo, String descricao, Integer tipoDesastreId) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipoDesastreId = tipoDesastreId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getTipoDesastreId() {
        return tipoDesastreId;
    }

    public void setTipoDesastreId(Integer tipoDesastreId) {
        this.tipoDesastreId = tipoDesastreId;
    }
}
