package com.gs.preventapi.dto;

public class ChecklistDTO {

    private Integer id;
    private String item;
    private Boolean concluido;
    private Integer usuarioId;

    public ChecklistDTO() {
    }

    public ChecklistDTO(Integer id, String item, Boolean concluido, Integer usuarioId) {
        this.id = id;
        this.item = item;
        this.concluido = concluido;
        this.usuarioId = usuarioId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Boolean getConcluido() {
        return concluido;
    }

    public void setConcluido(Boolean concluido) {
        this.concluido = concluido;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
}
