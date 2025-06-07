package com.gs.preventapi.controller;

import com.gs.preventapi.model.HistoricoRisco;
import com.gs.preventapi.service.HistoricoRiscoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;

@RestController
@RequestMapping("/historicos-risco")
@SecurityRequirement(name = "basicAuth")
public class HistoricoRiscoController {

    @Autowired
    private HistoricoRiscoService historicoRiscoService;

    @Operation(summary = "Lista todos os históricos de risco")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @GetMapping
    public List<HistoricoRisco> listarTodos() {
        return historicoRiscoService.listarTodos();
    }

    @Operation(summary = "Busca um histórico de risco pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Histórico encontrado"),
            @ApiResponse(responseCode = "404", description = "Histórico não encontrado"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<HistoricoRisco> buscarPorId(@PathVariable Integer id) {
        return historicoRiscoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Cadastra um novo histórico de risco")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Histórico cadastrado com sucesso"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @PostMapping
    public HistoricoRisco salvar(@RequestBody HistoricoRisco historicoRisco) {
        return historicoRiscoService.salvar(historicoRisco);
    }

    @Operation(summary = "Atualiza um histórico de risco existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Histórico atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Histórico não encontrado"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<HistoricoRisco> atualizar(@PathVariable Integer id, @RequestBody HistoricoRisco historicoRisco) {
        return historicoRiscoService.atualizar(id, historicoRisco)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Remove um histórico de risco pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Histórico removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Histórico não encontrado"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        try {
            historicoRiscoService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (org.springframework.dao.EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
