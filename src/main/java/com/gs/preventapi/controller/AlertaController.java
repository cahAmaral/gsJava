package com.gs.preventapi.controller;

import com.gs.preventapi.model.Alerta;
import com.gs.preventapi.service.AlertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.dao.EmptyResultDataAccessException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;

@RestController
@RequestMapping("/alertas")
@SecurityRequirement(name = "basicAuth")
public class AlertaController {

    @Autowired
    private AlertaService alertaService;

    @Operation(summary = "Listar todos os alertas")
    @ApiResponse(responseCode = "200", description = "Lista de alertas retornada com sucesso")
    @GetMapping
    public List<Alerta> listarTodos() {
        return alertaService.listarTodos();
    }

    @Operation(summary = "Buscar alerta por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Alerta encontrado"),
            @ApiResponse(responseCode = "404", description = "Alerta não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Alerta> buscarPorId(@PathVariable Integer id) {
        return alertaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Salvar um novo alerta")
    @ApiResponse(responseCode = "200", description = "Alerta salvo com sucesso")
    @PostMapping
    public Alerta salvar(@RequestBody Alerta alerta) {
        return alertaService.salvar(alerta);
    }

    @Operation(summary = "Atualizar alerta por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Alerta atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Alerta não encontrado para atualização")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Alerta> atualizar(@PathVariable Integer id, @RequestBody Alerta alerta) {
        return alertaService.atualizar(id, alerta)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Deletar alerta por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Alerta deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Alerta não encontrado para deletar")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        try {
            alertaService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
