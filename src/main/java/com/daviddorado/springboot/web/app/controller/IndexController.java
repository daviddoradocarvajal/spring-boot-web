package com.daviddorado.springboot.web.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daviddorado.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	// El método si se omite es tipo get también
	// Tambien exiten anotaciones @PostMapping...
	// Anotación @RequestMapping para genéricos y cambiar metodo 
	// Model == interfaz ModelMap == implementación
	// También se puede usar con Map para clave valor
	// ModelAndView es más técnico por usar mas métodos.
	// La mas usada es model
	@GetMapping({"/index", "/home", "/",""})
	public String index(Model model) {
		model.addAttribute("titulo",textoIndex);
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		System.out.println("Hola");
		Usuario usuario = new Usuario();
		usuario.setNombre("David");
		usuario.setApellido("Apellido");
		usuario.setEmail("aaa@aaa.es");
		model.addAttribute("titulo","Hola mundo spring");
		model.addAttribute("titulo2",textoPerfil.concat(usuario.getNombre()));
		// En html se accederá con user punto atributo no con usuario
		model.addAttribute("user",usuario);
		return "./model/perfil";
	}
	@RequestMapping("/listar")
	public String listar(Model model) {
		
		model.addAttribute("titulo",textoListar);		
		return "lista";
	}
	
	// Como parámetro de la anotación se pasa el nombre a poner en el HTML para acceder al valor de return
	@ModelAttribute("users")
	public List<Usuario> rellenarListaUsuarios(){
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario usuario = new Usuario();		
		usuario.setNombre("David");
		usuario.setApellido("Apellido");
		usuario.setEmail("aaa@aaa.es");
		usuarios.add(usuario);
		usuarios.add(new Usuario("Usuario2","Apellido2","usuario@usuario.es"));
		return usuarios;
	}
}
