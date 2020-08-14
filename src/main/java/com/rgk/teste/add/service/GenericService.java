package com.rgk.teste.add.service;

import java.util.List;

import com.rgk.teste.add.repository.GenericRepository;

public abstract class GenericService<Entity, Id> {
	
	private GenericRepository<Entity, Id> repository;

	public GenericService(GenericRepository<Entity, Id> repository) {
		super();
		this.repository = repository;
	}
	
	public void salvar(Entity aluno) {
		repository.create(aluno);
	}
	
	public List<Entity> listarTodos() {
		return repository.getAll();
	}
	
	public Entity buscarPorId(Id id) {
		return repository.getById(id);
	}

	public void atualizar(Entity aluno) {
		repository.update(aluno);
	}
	
	public void deletar(Entity aluno) {
		repository.remove(aluno);
	}
	
	public void deletarPorId(Id id) {
		Entity entity = repository.getById(id);
		repository.remove(entity);
	}

}