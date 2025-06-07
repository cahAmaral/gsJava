package com.gs.preventapi.dto;

import java.time.LocalDateTime;

public class HistoricoRiscoDTO {

    private Integer id;
    private Integer regiaoId;
    private Integer tipoDesastreId;
    private Double riscoAtual;
    private LocalDateTime dataHora;

    public HistoricoRiscoDTO() {
    }

    public HistoricoRiscoDTO(Integer id, Integer regiaoId, Integer tipoDesastreId, Double riscoAtual, LocalDateTime dataHora) {
        this.id = id;
        this.regiaoId = regiaoId;
        this.tipoDesastreId = tipoDesastreId;
        this.riscoAtual = riscoAtual;
        this.dataHora = dataHora;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getRiscoAtual() {
        return riscoAtual;
    }

    public void setRiscoAtual(Double riscoAtual) {
        this.riscoAtual = riscoAtual;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
