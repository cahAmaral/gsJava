package com.gs.preventapi.service;

import com.gs.preventapi.model.Kit;
import com.gs.preventapi.repository.KitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KitService {

    @Autowired
    private KitRepository kitRepository;

    public List<Kit> listarTodos() {
        return kitRepository.findAll();
    }

    public Optional<Kit> buscarPorId(Integer id) {
        return kitRepository.findById(id);
    }

    public Kit salvar(Kit kit) {
        return kitRepository.save(kit);
    }

    public void deletar(Integer id) {
        kitRepository.deleteById(id);
    }

    public Optional<Kit> atualizar(Integer id, Kit novoKit) {
        return kitRepository.findById(id).map(kitExistente -> {
            kitExistente.setNome(novoKit.getNome());
            kitExistente.setDescricao(novoKit.getDescricao());
            return kitRepository.save(kitExistente);
        });
    }
}
