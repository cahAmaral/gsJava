package com.gs.preventapi.controller;

import com.gs.preventapi.model.TipoDesastre;
import com.gs.preventapi.service.TipoDesastreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;

@RestController
@RequestMapping("/tipos-desastre")
@SecurityRequirement(name = "basicAuth")
public class TipoDesastreController {

    @Autowired
    private TipoDesastreService tipoDesastreService;

    @Operation(summary = "Lista todos os tipos de desastre")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @GetMapping
    public List<TipoDesastre> listarTodos() {
        return tipoDesastreService.listarTodos();
    }

    @Operation(summary = "Busca tipo de desastre por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tipo de desastre encontrado"),
            @ApiResponse(responseCode = "404", description = "Tipo de desastre não encontrado"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<TipoDesastre> buscarPorId(@PathVariable Integer id) {
        return tipoDesastreService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Cadastra um novo tipo de desastre")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tipo de desastre criado com sucesso"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @PostMapping
    public TipoDesastre salvar(@RequestBody TipoDesastre tipoDesastre) {
        return tipoDesastreService.salvar(tipoDesastre);
    }

    @Operation(summary = "Atualiza um tipo de desastre existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tipo de desastre atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Tipo de desastre não encontrado"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<TipoDesastre> atualizar(@PathVariable Integer id, @RequestBody TipoDesastre tipoDesastre) {
        return tipoDesastreService.atualizar(id, tipoDesastre)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Remove um tipo de desastre pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Tipo de desastre removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Tipo de desastre não encontrado"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        try {
            tipoDesastreService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (org.springframework.dao.EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
