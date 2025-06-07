package com.gs.preventapi.service;

import com.gs.preventapi.model.Dica;
import com.gs.preventapi.repository.DicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DicaService {

    @Autowired
    private DicaRepository dicaRepository;

    public List<Dica> listarTodos() {
        return dicaRepository.findAll();
    }

    public Optional<Dica> buscarPorId(Integer id) {
        return dicaRepository.findById(id);
    }

    public Dica salvar(Dica dica) {
        return dicaRepository.save(dica);
    }

    public void deletar(Integer id) {
        dicaRepository.deleteById(id);
    }

    public Optional<Dica> atualizar(Integer id, Dica novaDica) {
        return dicaRepository.findById(id).map(dicaExistente -> {
            dicaExistente.setDescricao(novaDica.getDescricao());
            dicaExistente.setDataCriacao(novaDica.getDataCriacao());
            dicaExistente.setRegiao(novaDica.getRegiao());
            return dicaRepository.save(dicaExistente);
        });
    }
}
