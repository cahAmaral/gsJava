package com.gs.preventapi.controller;

import com.gs.preventapi.model.Kit;
import com.gs.preventapi.service.KitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;

@RestController
@RequestMapping("/kits")
@SecurityRequirement(name = "basicAuth")
public class KitController {

    @Autowired
    private KitService kitService;

    @Operation(summary = "Lista todos os kits")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de kits retornada com sucesso"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @GetMapping
    public List<Kit> listarTodos() {
        return kitService.listarTodos();
    }

    @Operation(summary = "Busca um kit pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Kit encontrado"),
            @ApiResponse(responseCode = "404", description = "Kit não encontrado"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Kit> buscarPorId(@PathVariable Integer id) {
        return kitService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Cadastra um novo kit")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Kit cadastrado com sucesso"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @PostMapping
    public Kit salvar(@RequestBody Kit kit) {
        return kitService.salvar(kit);
    }

    @Operation(summary = "Atualiza um kit existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Kit atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Kit não encontrado"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Kit> atualizar(@PathVariable Integer id, @RequestBody Kit kit) {
        return kitService.atualizar(id, kit)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Remove um kit pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Kit removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Kit não encontrado"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        try {
            kitService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (org.springframework.dao.EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
