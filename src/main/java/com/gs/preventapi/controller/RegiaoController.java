package com.gs.preventapi.controller;

import com.gs.preventapi.model.Regiao;
import com.gs.preventapi.service.RegiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;

@RestController
@RequestMapping("/regioes")
@SecurityRequirement(name = "basicAuth")
public class RegiaoController {

    @Autowired
    private RegiaoService regiaoService;

    @Operation(summary = "Lista todas as regiões")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de regiões retornada com sucesso"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @GetMapping
    public List<Regiao> listarTodos() {
        return regiaoService.listarTodos();
    }

    @Operation(summary = "Busca uma região pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Região encontrada"),
            @ApiResponse(responseCode = "404", description = "Região não encontrada"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Regiao> buscarPorId(@PathVariable Integer id) {
        return regiaoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Cadastra uma nova região")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Região cadastrada com sucesso"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @PostMapping
    public Regiao salvar(@RequestBody Regiao regiao) {
        return regiaoService.salvar(regiao);
    }

    @Operation(summary = "Atualiza uma região existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Região atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Região não encontrada"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Regiao> atualizar(@PathVariable Integer id, @RequestBody Regiao regiao) {
        return regiaoService.atualizar(id, regiao)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Remove uma região pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Região removida com sucesso"),
            @ApiResponse(responseCode = "404", description = "Região não encontrada"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        try {
            regiaoService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (org.springframework.dao.EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
