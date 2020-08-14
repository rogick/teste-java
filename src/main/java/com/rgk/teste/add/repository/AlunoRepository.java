package com.rgk.teste.add.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.rgk.teste.add.model.Aluno;

@Repository
public class AlunoRepository extends GenericRepository<Aluno, Integer> {
	
	@PersistenceContext
	private EntityManager em;
	
	public AlunoRepository() {
		super(Aluno.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public List<Aluno> listarPorTurma(Integer idTurma) {
		return em.createQuery("From Aluno Where turma.id = " + idTurma, Aluno.class).getResultList();
	}

}
