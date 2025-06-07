package com.gs.preventapi.service;

import com.gs.preventapi.model.LocalSeguro;
import com.gs.preventapi.repository.LocalSeguroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalSeguroService {

    @Autowired
    private LocalSeguroRepository localSeguroRepository;

    public List<LocalSeguro> listarTodos() {
        return localSeguroRepository.findAll();
    }

    public Optional<LocalSeguro> buscarPorId(Integer id) {
        return localSeguroRepository.findById(id);
    }

    public LocalSeguro salvar(LocalSeguro localSeguro) {
        return localSeguroRepository.save(localSeguro);
    }

    public void deletar(Integer id) {
        localSeguroRepository.deleteById(id);
    }

    public Optional<LocalSeguro> atualizar(Integer id, LocalSeguro novoLocalSeguro) {
        return localSeguroRepository.findById(id).map(localSeguroExistente -> {
            localSeguroExistente.setNome(novoLocalSeguro.getNome());
            localSeguroExistente.setEndereco(novoLocalSeguro.getEndereco());
            localSeguroExistente.setTelefone(novoLocalSeguro.getTelefone());
            localSeguroExistente.setRegiao(novoLocalSeguro.getRegiao());
            return localSeguroRepository.save(localSeguroExistente);
        });
    }
}
