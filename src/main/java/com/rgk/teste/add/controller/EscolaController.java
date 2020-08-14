package com.rgk.teste.add.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rgk.teste.add.model.Escola;
import com.rgk.teste.add.service.EscolaService;

@Controller
@RequestMapping("/escola")
public class EscolaController {
	
	@Autowired 
	private EscolaService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Escola Escola) {
		return "escola/cadastro";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Integer id, ModelMap model) {
		model.addAttribute("Escola", service.buscarPorId(id));
		return "escola/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap m) {
		m.addAttribute("Escolas", service.listarTodos());
		return "escola/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Escola escola, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors())
			return "escola/cadastro";
		
		service.salvar(escola);
		attr.addFlashAttribute("success", "Escola salva com sucesso!");
		return "redirect:/escolas/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Integer id, ModelMap model) {
		service.deletarPorId(id);
		model.addAttribute("success", "Escola excluida com sucesso!");
		return "redirect:/escolas/listar";
	}
	
}
