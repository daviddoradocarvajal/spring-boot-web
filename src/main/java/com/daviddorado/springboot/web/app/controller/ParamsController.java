package com.daviddorado.springboot.web.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("params")
public class ParamsController {
	
	@GetMapping("/")
	public String index() {
		return "params/index";
	}
	
	@GetMapping("/string")
	public String param(@RequestParam(name="texto", defaultValue = "No hay valor enviado") String texto, Model model) {
		model.addAttribute("resultado", "El parámetro enviado es: "+texto);
		return "params/ver";
	}
	
	@GetMapping("/mix-params")
	public String param(@RequestParam String texto, @RequestParam Integer numero, Model model) {
		model.addAttribute("texto", "El parámetro enviado es: "+texto);
		model.addAttribute("numero", "El número enviado es: "+numero);
		return "params/ver";
	}
	
	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request, Model model) {
		String texto = request.getParameter("texto");
		Integer numero = null;
		try {
			numero = Integer.parseInt(request.getParameter("numero"));
		} catch (Exception e) {
			numero = 0;
		}		
		model.addAttribute("texto", "El parámetro enviado es: "+texto);
		model.addAttribute("numero", "El número enviado es: "+numero);
		return "params/ver";
	}
}
