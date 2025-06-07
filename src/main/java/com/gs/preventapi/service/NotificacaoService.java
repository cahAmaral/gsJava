package com.gs.preventapi.service;

import com.gs.preventapi.model.Notificacao;
import com.gs.preventapi.repository.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    public List<Notificacao> listarTodos() {
        return notificacaoRepository.findAll();
    }

    public Optional<Notificacao> buscarPorId(Integer id) {
        return notificacaoRepository.findById(id);
    }

    public Notificacao salvar(Notificacao notificacao) {
        return notificacaoRepository.save(notificacao);
    }

    public void deletar(Integer id) {
        notificacaoRepository.deleteById(id);
    }

    public Optional<Notificacao> atualizar(Integer id, Notificacao novaNotificacao) {
        return notificacaoRepository.findById(id).map(notificacaoExistente -> {
            notificacaoExistente.setTitulo(novaNotificacao.getTitulo());
            notificacaoExistente.setMensagem(novaNotificacao.getMensagem());
            notificacaoExistente.setDataEnvio(novaNotificacao.getDataEnvio());
            notificacaoExistente.setUsuario(novaNotificacao.getUsuario());
            return notificacaoRepository.save(notificacaoExistente);
        });
    }
}
