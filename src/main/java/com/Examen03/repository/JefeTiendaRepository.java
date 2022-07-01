package com.Examen03.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Examen03.entity.JefeTienda;
@Repository
public interface JefeTiendaRepository  extends JpaRepository<JefeTienda, Integer>{
			List<JefeTienda> findByApellidoPaternoContains(String apellidoPaterno);
			JefeTienda findByDni(String dni);
			void deleteByCodigo(int codigo);
			JefeTienda findByCodigo(int codigo);
}
