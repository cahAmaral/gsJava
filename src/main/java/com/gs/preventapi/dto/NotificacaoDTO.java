package com.gs.preventapi.dto;

public class NotificacaoDTO {

    private Integer id;
    private String mensagem;
    private String tipo;
    private Integer usuarioId;

    public NotificacaoDTO() {
    }

    public NotificacaoDTO(Integer id, String mensagem, String tipo, Integer usuarioId) {
        this.id = id;
        this.mensagem = mensagem;
        this.tipo = tipo;
        this.usuarioId = usuarioId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
}
