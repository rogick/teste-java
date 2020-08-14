package com.rgk.teste.add.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgk.teste.add.model.Turma;
import com.rgk.teste.add.repository.TurmaRepository;

@Service
public class TurmaService extends GenericService<Turma, Integer>{
	
	public TurmaService(@Autowired TurmaRepository repository) {
		super(repository);
	}

}
