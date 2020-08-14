package com.rgk.teste.add.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.rgk.teste.add.model.Escola;

@Repository
public class EscolaRepository extends GenericRepository<Escola, Integer> {
	
	@PersistenceContext
	private EntityManager em;
	
	public EscolaRepository() {
		super(Escola.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
