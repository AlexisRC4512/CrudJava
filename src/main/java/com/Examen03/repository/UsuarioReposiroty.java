package com.Examen03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Examen03.entity.Usuario;
@Repository
public interface UsuarioReposiroty extends JpaRepository<Usuario, Integer>{
	Usuario findByCorreo(String correo);

}
