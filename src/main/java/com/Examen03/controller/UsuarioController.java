package com.Examen03.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Examen03.entity.Usuario;
import com.Examen03.repository.UsuarioReposiroty;



@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	 UsuarioReposiroty usuarioReposiroty;
	@Autowired
	UsuarioReposiroty usuarioRepository;
	@GetMapping("/mostrarCrearUsuario")
	public String mostrarCrearUsuario(HttpServletRequest request, Model model) {
		Usuario objUsuario = new Usuario();
		model.addAttribute("objUsuario", objUsuario);
		return "nuevoUsuario";
	}
	
	@PostMapping("/grabarUsuario")
	public String grabarUsuario(HttpServletRequest request, Usuario objUsuario, Model model) {
		Usuario objUsuarioBD = usuarioRepository.findByCorreo(objUsuario.getCorreo());
		if (objUsuarioBD==null) {
			usuarioRepository.save(objUsuario);
			model.addAttribute("mensaje", "El usuario ha sido registrado con éxito");
			Usuario objUsuarioNuevo = new Usuario();
			model.addAttribute("objUsuario",objUsuarioNuevo);
			
		}
		else {
			model.addAttribute("mensaje", "El usuario ya se encuentra registrado en el sistema");
			model.addAttribute("objUsuario",objUsuario);
		}
		return "nuevoUsuario";
	}
	@GetMapping("/volverIndex")
	public String volverIndex(HttpServletRequest request)
	{
		return "index";
	}
	@RequestMapping("/loginUser")
	public String loginUser(HttpServletRequest request, @RequestParam(value="correo" )  String correo ,@RequestParam(value = "password")String password ) {
		Usuario objUsuarioBDCorreo = usuarioReposiroty.findByCorreo(correo);
	
		if (objUsuarioBDCorreo!=null & objUsuarioBDCorreo.getPassword().equals(password)) {
	 
			return "principal";
			
		}
		else {
			return "index";
		}
		
	}
	
}
