package com.gs.preventapi.service;

import com.gs.preventapi.model.Regiao;
import com.gs.preventapi.repository.RegiaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegiaoService {

    @Autowired
    private RegiaoRepository regiaoRepository;

    public List<Regiao> listarTodos() {
        return regiaoRepository.findAll();
    }

    public Optional<Regiao> buscarPorId(Integer id) {
        return regiaoRepository.findById(id);
    }

    public Regiao salvar(Regiao regiao) {
        System.out.println(regiao.getNome());
        System.out.println(regiao.getEstado());
        System.out.println(regiao.getId());
        regiaoRepository.save(regiao);
        return regiao;
    }

    public void deletar(Integer id) {
        regiaoRepository.deleteById(id);
    }

    public Optional<Regiao> atualizar(Integer id, Regiao novaRegiao) {
        return regiaoRepository.findById(id).map(regiaoExistente -> {
            regiaoExistente.setNome(novaRegiao.getNome());
            regiaoExistente.setEstado(novaRegiao.getEstado());

            return regiaoRepository.save(regiaoExistente);
        });
    }
}
