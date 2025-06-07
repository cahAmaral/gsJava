package com.gs.preventapi.dto;

public class AlertaDTO {

    private Integer id;
    private String titulo;
    private String descricao;
    private String nivel;
    private Integer regiaoId;
    private Integer tipoDesastreId;

    public AlertaDTO() {
    }

    public AlertaDTO(Integer id, String titulo, String descricao, String nivel, Integer regiaoId, Integer tipoDesastreId) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.nivel = nivel;
        this.regiaoId = regiaoId;
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

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Integer getRegiaoId() {
        return regiaoId;
    }

    public void setRegiaoId(Integer regiaoId) {
        this.regiaoId = regiaoId;
    }

    public Integer getTipoDesastreId() {
        return tipoDesastreId;
    }

    public void setTipoDesastreId(Integer tipoDesastreId) {
        this.tipoDesastreId = tipoDesastreId;
    }
}
