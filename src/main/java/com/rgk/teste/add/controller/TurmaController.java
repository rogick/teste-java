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

import com.rgk.teste.add.model.Turma;
import com.rgk.teste.add.service.TurmaService;

@Controller
@RequestMapping("/turma")
public class TurmaController {
	
	@Autowired 
	private TurmaService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Turma Turma) {
		return "turma/cadastro";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Integer id, ModelMap model) {
		model.addAttribute("turma", service.buscarPorId(id));
		return "turma/cadastro";
	}
	
	@GetMapping("/visualizar/{id}")
	public String visualizar(@PathVariable("id") Integer id, ModelMap model) {
		model.addAttribute("turma", service.buscarPorId(id));
		return "turma/visualizar";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap m) {
		m.addAttribute("turmas", service.listarTodos());
		return "turma/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Turma turma, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors())
			return "turma/cadastro";
		
		service.salvar(turma);
		attr.addFlashAttribute("success", "Turma salva com sucesso!");
		return "redirect:/turma/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Integer id, ModelMap model) {
		service.deletarPorId(id);
		model.addAttribute("success", "Turma excluida com sucesso!");
		return "redirect:/turma/listar";
	}
	
}
