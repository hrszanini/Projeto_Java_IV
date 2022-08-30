package br.gov.sp.fatec.projetolabiv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.projetolabiv.entity.Usuario;
import br.gov.sp.fatec.projetolabiv.repository.UsuarioRepository;

@Service
public class SegurancaServiceImpl implements SegurancaService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario novoUsuario(Usuario usuario) {
        if(usuario.getNome() == null || usuario.getNome().isBlank() || usuario.getSenha() == null || usuario.getSenha().isBlank())
            throw new IllegalArgumentException("Nome ou senha em branco.");

        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario novoUsuario(String nome, String senha) {
        Usuario usuario = new Usuario();

        usuario.setNome(nome);
        usuario.setSenha(senha);

        return novoUsuario(usuario);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarUsuarioPorId(Long id) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        
        if(usuarioOpt.isEmpty())
            throw new IllegalArgumentException("Id inválido");
    
        return usuarioOpt.get();
    }
    
}
