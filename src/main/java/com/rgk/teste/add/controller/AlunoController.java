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

import com.rgk.teste.add.model.Aluno;
import com.rgk.teste.add.service.AlunoService;

@Controller
@RequestMapping("/aluno")
public class AlunoController {
	
	@Autowired 
	private AlunoService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Aluno Aluno) {
		return "aluno/cadastro";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Integer id, ModelMap model) {
		model.addAttribute("Aluno", service.buscarPorId(id));
		return "aluno/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap m) {
		m.addAttribute("Alunos", service.listarTodos());
		return "aluno/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Aluno aluno, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors())
			return "aluno/cadastro";
		
		service.salvar(aluno);
		attr.addFlashAttribute("success", "Aluno salvo com sucesso!");
		return "redirect:/alunos/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Integer id, ModelMap model) {
		service.deletarPorId(id);
		model.addAttribute("success", "Aluno excluido com sucesso!");
		return "redirect:/alunos/listar";
	}
	
}
