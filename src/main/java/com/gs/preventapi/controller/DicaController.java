package com.gs.preventapi.controller;

import com.gs.preventapi.model.Dica;
import com.gs.preventapi.service.DicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;

@RestController
@RequestMapping("/dicas")
@SecurityRequirement(name = "basicAuth")
public class DicaController {

    @Autowired
    private DicaService dicaService;

    @Operation(summary = "Lista todas as dicas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de dicas retornada com sucesso"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @GetMapping
    public List<Dica> listarTodos() {
        return dicaService.listarTodos();
    }

    @Operation(summary = "Busca uma dica pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dica encontrada"),
            @ApiResponse(responseCode = "404", description = "Dica não encontrada"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Dica> buscarPorId(@PathVariable Integer id) {
        return dicaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Salva uma nova dica")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dica salva com sucesso"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @PostMapping
    public Dica salvar(@RequestBody Dica dica) {
        return dicaService.salvar(dica);
    }

    @Operation(summary = "Atualiza uma dica existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Dica atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Dica não encontrada"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Dica> atualizar(@PathVariable Integer id, @RequestBody Dica dica) {
        return dicaService.atualizar(id, dica)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Deleta uma dica pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Dica deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Dica não encontrada"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        try {
            dicaService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (org.springframework.dao.EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
