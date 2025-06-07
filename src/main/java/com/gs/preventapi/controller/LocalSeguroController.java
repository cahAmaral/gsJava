package com.gs.preventapi.controller;

import com.gs.preventapi.model.LocalSeguro;
import com.gs.preventapi.service.LocalSeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;

@RestController
@RequestMapping("/locais-seguros")
@SecurityRequirement(name = "basicAuth")
public class LocalSeguroController {

    @Autowired
    private LocalSeguroService localSeguroService;

    @Operation(summary = "Lista todos os locais seguros")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de locais seguros retornada com sucesso"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @GetMapping
    public List<LocalSeguro> listarTodos() {
        return localSeguroService.listarTodos();
    }

    @Operation(summary = "Busca um local seguro pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Local seguro encontrado"),
            @ApiResponse(responseCode = "404", description = "Local seguro não encontrado"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<LocalSeguro> buscarPorId(@PathVariable Integer id) {
        return localSeguroService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Cadastra um novo local seguro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Local seguro cadastrado com sucesso"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @PostMapping
    public LocalSeguro salvar(@RequestBody LocalSeguro localSeguro) {
        return localSeguroService.salvar(localSeguro);
    }

    @Operation(summary = "Atualiza um local seguro existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Local seguro atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Local seguro não encontrado"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<LocalSeguro> atualizar(@PathVariable Integer id, @RequestBody LocalSeguro localSeguro) {
        return localSeguroService.atualizar(id, localSeguro)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Remove um local seguro pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Local seguro removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Local seguro não encontrado"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        try {
            localSeguroService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (org.springframework.dao.EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
