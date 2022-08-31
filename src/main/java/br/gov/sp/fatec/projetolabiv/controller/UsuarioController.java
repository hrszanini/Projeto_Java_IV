package br.gov.sp.fatec.projetolabiv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.projetolabiv.entity.Usuario;
import br.gov.sp.fatec.projetolabiv.service.SegurancaService;

@RestController
@CrossOrigin
@RequestMapping(value = "/usuario")
public class UsuarioController {
    
    @Autowired
    private SegurancaService segurancaService;
    
    @GetMapping
    public List<Usuario> listarTodosUsuarios(){
        return segurancaService.listarUsuarios();
    }

    @PostMapping
    public Usuario novoUsuario(@RequestBody Usuario usuario){
        return segurancaService.novoUsuario(usuario);
    }

    @GetMapping(value = "/{id}")
    public Usuario buscarPeloId(@PathVariable("id") Long id){
        return segurancaService.buscarUsuarioPorId(id);
    }
}
