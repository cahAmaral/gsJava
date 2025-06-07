package com.gs.preventapi.service;

import com.gs.preventapi.model.Usuario;
import com.gs.preventapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Integer id) {
        return usuarioRepository.findById(id);
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deletar(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public Optional<Usuario> atualizar(Integer id, Usuario novoUsuario) {
        return usuarioRepository.findById(id).map(usuarioExistente -> {
            usuarioExistente.setNomeUsuario(novoUsuario.getNomeUsuario());
            usuarioExistente.setEmailUsuario(novoUsuario.getEmailUsuario());
            usuarioExistente.setSenhaUsuario(novoUsuario.getSenhaUsuario());
            usuarioExistente.setTipoUsuario(novoUsuario.getTipoUsuario());
            return usuarioRepository.save(usuarioExistente);
        });
    }
}
