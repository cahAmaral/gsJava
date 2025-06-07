package com.gs.preventapi.controller;

import com.gs.preventapi.model.Checklist;
import com.gs.preventapi.service.ChecklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;

@RestController
@RequestMapping("/checklists")
@SecurityRequirement(name = "basicAuth")
public class ChecklistController {

    @Autowired
    private ChecklistService checklistService;

    @Operation(summary = "Lista todos os checklists")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de checklists retornada com sucesso"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @GetMapping
    public List<Checklist> listarTodos() {
        return checklistService.listarTodos();
    }

    @Operation(summary = "Busca um checklist pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Checklist encontrado"),
            @ApiResponse(responseCode = "404", description = "Checklist não encontrado"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Checklist> buscarPorId(@PathVariable Integer id) {
        return checklistService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Salva um novo checklist")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Checklist salvo com sucesso"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @PostMapping
    public Checklist salvar(@RequestBody Checklist checklist) {
        return checklistService.salvar(checklist);
    }

    @Operation(summary = "Atualiza um checklist existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Checklist atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Checklist não encontrado"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Checklist> atualizar(@PathVariable Integer id, @RequestBody Checklist checklist) {
        return checklistService.atualizar(id, checklist)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Deleta um checklist pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Checklist deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Checklist não encontrado"),
            @ApiResponse(responseCode = "403", description = "Acesso negado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        try {
            checklistService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (org.springframework.dao.EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
