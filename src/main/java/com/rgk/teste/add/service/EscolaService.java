package com.rgk.teste.add.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgk.teste.add.model.Escola;
import com.rgk.teste.add.repository.EscolaRepository;

@Service
public class EscolaService extends GenericService<Escola, Integer>  {
	
	public EscolaService(@Autowired EscolaRepository repository) {
		super(repository);
	}

}
