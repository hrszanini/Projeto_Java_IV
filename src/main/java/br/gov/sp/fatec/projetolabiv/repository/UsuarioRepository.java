package br.gov.sp.fatec.projetolabiv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.projetolabiv.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
