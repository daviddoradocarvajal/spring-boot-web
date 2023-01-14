package com.daviddorado.springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	// forward no cambia la url se hace por debajo (mantiene los parámetros del request)
	// redirect cambia la url y reinicia la petición completamente
	
	@GetMapping("/")
	public String home() {
		return "forward:/app/index";
	}
	@GetMapping("/google")
	public String google() {
		return "redirect:https://www.google.es";
	}
}
