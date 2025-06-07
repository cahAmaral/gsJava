package com.gs.preventapi.service;

import com.gs.preventapi.model.Checklist;
import com.gs.preventapi.repository.ChecklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChecklistService {

    @Autowired
    private ChecklistRepository checklistRepository;

    public List<Checklist> listarTodos() {
        return checklistRepository.findAll();
    }

    public Optional<Checklist> buscarPorId(Integer id) {
        return checklistRepository.findById(id);
    }

    public Checklist salvar(Checklist checklist) {
        return checklistRepository.save(checklist);
    }

    public void deletar(Integer id) {
        checklistRepository.deleteById(id);
    }

    public Optional<Checklist> atualizar(Integer id, Checklist novoChecklist) {
        return checklistRepository.findById(id).map(checklistExistente -> {
            checklistExistente.setDescricao(novoChecklist.getDescricao());
            checklistExistente.setDataCriacao(novoChecklist.getDataCriacao());
            checklistExistente.setRegiao(novoChecklist.getRegiao());
            return checklistRepository.save(checklistExistente);
        });
    }
}
