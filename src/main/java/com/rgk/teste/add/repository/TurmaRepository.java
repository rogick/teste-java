package com.rgk.teste.add.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rgk.teste.add.model.Turma;

@Repository
public class TurmaRepository extends GenericRepository<Turma, Integer> {
	
	@PersistenceContext
	private EntityManager em;
	
	public TurmaRepository() {
		super(Turma.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	@Transactional
	public Turma carregarTurma(Integer id) {
		Turma turma = getById(id);
		turma.getAlunos().size();
		return turma;
	}

}
