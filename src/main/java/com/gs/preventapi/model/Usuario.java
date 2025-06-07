package com.gs.preventapi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "nome_usuario", length = 30, nullable = false)
    private String nomeUsuario;

    @Column(name = "email_usuario", length = 30, nullable = false)
    private String emailUsuario;

    @Column(name = "senha_usuario", length = 100, nullable = false)
    private String senhaUsuario;

    @Column(name = "tipo_usuario", length = 20, nullable = false)
    private String tipoUsuario;

    @Column(name = "usuario_criado", nullable = false)
    private LocalDateTime usuarioCriado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_regiao", nullable = false)
    private Regiao regiao;

    // Getters e Setters

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public LocalDateTime getUsuarioCriado() {
        return usuarioCriado;
    }

    public void setUsuarioCriado(LocalDateTime usuarioCriado) {
        this.usuarioCriado = usuarioCriado;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }
}
