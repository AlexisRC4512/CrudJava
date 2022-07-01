package com.Examen03.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Examen03.entity.JefeTienda;
import com.Examen03.repository.JefeTiendaRepository;




@Controller
@RequestMapping("/jefe")
public class JefeTiendaController {
	@Autowired
	JefeTiendaRepository JefeTiendaRepository;
	@GetMapping("/mostrarCrearJefeTienda")
	public String mostrarCrearJefeTienda(HttpServletRequest request, Model model) {
		JefeTienda objjefeTienda=new JefeTienda();
		model.addAttribute("objJefeTienda", objjefeTienda);
		return "nuevoJefeTienda";
	}
	
	@GetMapping("/gestionar")
	public String gestionar(HttpServletRequest request) {
		return "gestionarJefeTienda";
	}
	@RequestMapping("/buscarApellido")
	public String buscarApellido(HttpServletRequest request, @RequestParam(value = "apellidoPaterno") String apellidoPaterno,Model model) 
	{	
		List<JefeTienda>listaJefesTiendas=JefeTiendaRepository.findByApellidoPaternoContains(apellidoPaterno);
		model.addAttribute("listaJefesTienda",listaJefesTiendas);
		return "gestionarJefeTienda";
	} 
	@GetMapping("/volverJefeTienda")
	public String volverJefeTienda(HttpServletRequest request)
	{
		return "gestionarJefeTienda";
	}
	
	@PostMapping("/grabarJefeTienda")
	public String grabarJefeTienda(HttpServletRequest request, JefeTienda objJefeTienda , Model model) {
		
		
			JefeTiendaRepository.save(objJefeTienda);
			model.addAttribute("mensaje", "El usuario ha sido registrado con éxito");
			JefeTienda objJefeTiendaNuevo = new JefeTienda();
			model.addAttribute("objJefeTienda",objJefeTiendaNuevo);
			
		return "nuevoJefeTienda";
	}
	@Transactional
	@GetMapping("/eliminar/{codigo}")
	public String eliminar(HttpServletRequest request, @PathVariable("codigo") int codigo, Model model) {
		JefeTiendaRepository.deleteByCodigo(codigo);
		model.addAttribute("mensaje", "El Jefe de Tienda ha sido eliminado");
		return "gestionarJefeTienda";
	}
	
	@GetMapping("/editar/{codigo}")
	public String editar(HttpServletRequest request, @PathVariable("codigo") int codigo, Model model) {
		JefeTienda objJefeTienda = JefeTiendaRepository.findByCodigo(codigo);
		model.addAttribute("objJefeTienda", objJefeTienda);
		return "editarJefeTienda";
	}
	
	@PostMapping("/actualizar")
	public String actualizar(HttpServletRequest request,JefeTienda objJefeTienda, Model model) {
		JefeTiendaRepository.save(objJefeTienda);
		return "gestionarJefeTienda";
	}
}
