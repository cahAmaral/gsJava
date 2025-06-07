package com.gs.preventapi.service;

import com.gs.preventapi.model.HistoricoRisco;
import com.gs.preventapi.repository.HistoricoRiscoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoricoRiscoService {

    @Autowired
    private HistoricoRiscoRepository historicoRiscoRepository;

    public List<HistoricoRisco> listarTodos() {
        return historicoRiscoRepository.findAll();
    }

    public Optional<HistoricoRisco> buscarPorId(Integer id) {
        return historicoRiscoRepository.findById(id);
    }

    public HistoricoRisco salvar(HistoricoRisco historicoRisco) {
        return historicoRiscoRepository.save(historicoRisco);
    }

    public void deletar(Integer id) {
        historicoRiscoRepository.deleteById(id);
    }

    public Optional<HistoricoRisco> atualizar(Integer id, HistoricoRisco novoHistoricoRisco) {
        return historicoRiscoRepository.findById(id).map(historicoExistente -> {
            historicoExistente.setDescricao(novoHistoricoRisco.getDescricao());
            historicoExistente.setDataRegistro(novoHistoricoRisco.getDataRegistro());
            historicoExistente.setRegiao(novoHistoricoRisco.getRegiao());
            historicoExistente.setTipoDesastre(novoHistoricoRisco.getTipoDesastre());
            return historicoRiscoRepository.save(historicoExistente);
        });
    }
}
