package com.rgk.teste.add.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgk.teste.add.model.Aluno;
import com.rgk.teste.add.repository.AlunoRepository;

@Service
public class AlunoService extends GenericService<Aluno, Integer> {
	
	public AlunoService(@Autowired AlunoRepository repository) {
		super(repository);
	}

}
