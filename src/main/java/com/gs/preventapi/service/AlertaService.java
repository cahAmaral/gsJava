package com.gs.preventapi.service;

import com.gs.preventapi.model.Alerta;
import com.gs.preventapi.repository.AlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlertaService {

    @Autowired
    private AlertaRepository alertaRepository;

    public List<Alerta> listarTodos() {
        return alertaRepository.findAll();
    }

    public Optional<Alerta> buscarPorId(Integer id) {
        return alertaRepository.findById(id);
    }

    public Alerta salvar(Alerta alerta) {
        return alertaRepository.save(alerta);
    }

    public void deletar(Integer id) {
        alertaRepository.deleteById(id);
    }

    public Optional<Alerta> atualizar(Integer id, Alerta novoAlerta) {
        return alertaRepository.findById(id).map(alertaExistente -> {
            alertaExistente.setDescricao(novoAlerta.getDescricao());
            alertaExistente.setNivel(novoAlerta.getNivel());
            alertaExistente.setDataCriacao(novoAlerta.getDataCriacao());
            alertaExistente.setRegiao(novoAlerta.getRegiao());
            return alertaRepository.save(alertaExistente);
        });
    }
}
