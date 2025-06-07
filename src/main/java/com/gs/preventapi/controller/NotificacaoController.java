package com.gs.preventapi.controller;

import com.gs.preventapi.model.Notificacao;
import com.gs.preventapi.service.NotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;

@RestController
@RequestMapping("/notificacoes")
@SecurityRequirement(name = "basicAuth")
public class NotificacaoController {

    @Autowired
    private NotificacaoService notificacaoService;

    @Operation(summary = "Lista todas as notificações")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de notificações retornada com sucesso"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @GetMapping
    public List<Notificacao> listarTodos() {
        return notificacaoService.listarTodos();
    }

    @Operation(summary = "Busca uma notificação pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Notificação encontrada"),
            @ApiResponse(responseCode = "404", description = "Notificação não encontrada"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Notificacao> buscarPorId(@PathVariable Integer id) {
        return notificacaoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Cadastra uma nova notificação")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Notificação cadastrada com sucesso"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @PostMapping
    public Notificacao salvar(@RequestBody Notificacao notificacao) {
        return notificacaoService.salvar(notificacao);
    }

    @Operation(summary = "Atualiza uma notificação existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Notificação atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Notificação não encontrada"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Notificacao> atualizar(@PathVariable Integer id, @RequestBody Notificacao notificacao) {
        return notificacaoService.atualizar(id, notificacao)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Remove uma notificação pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Notificação removida com sucesso"),
            @ApiResponse(responseCode = "404", description = "Notificação não encontrada"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        try {
            notificacaoService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (org.springframework.dao.EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
