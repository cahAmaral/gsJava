package com.gs.preventapi.service;

import com.gs.preventapi.model.TipoDesastre;
import com.gs.preventapi.repository.TipoDesastreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDesastreService {

    @Autowired
    private TipoDesastreRepository tipoDesastreRepository;

    public List<TipoDesastre> listarTodos() {
        return tipoDesastreRepository.findAll();
    }

    public Optional<TipoDesastre> buscarPorId(Integer id) {
        return tipoDesastreRepository.findById(id);
    }

    public TipoDesastre salvar(TipoDesastre tipoDesastre) {
        return tipoDesastreRepository.save(tipoDesastre);
    }

    public void deletar(Integer id) {
        tipoDesastreRepository.deleteById(id);
    }

    public Optional<TipoDesastre> atualizar(Integer id, TipoDesastre novoTipoDesastre) {
        return tipoDesastreRepository.findById(id).map(tipoDesastreExistente -> {
            tipoDesastreExistente.setNome(novoTipoDesastre.getNome());
            tipoDesastreExistente.setDescricao(novoTipoDesastre.getDescricao());
            return tipoDesastreRepository.save(tipoDesastreExistente);
        });
    }
}
