package com.rgk.teste.add.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.transaction.annotation.Transactional;

public abstract class GenericRepository<Entity, Id> {
	
	private Class<Entity> clazz;
	
	public GenericRepository(Class<Entity> clazz) {
		this.clazz = clazz;
	}
	
	@Transactional
	public Entity create(Entity entity) {
		getEntityManager().persist(entity);
		return entity;
	}
	
	@Transactional
	public Entity update(Entity entity) {
		return getEntityManager().merge(entity);
	}
	
	@Transactional
	public void remove(Entity entity) {
		getEntityManager().remove(entity);
	}

	public Entity getById(Id id) {
		return getEntityManager().find(this.clazz, id);
	}
	
	public List<Entity> getAll() {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Entity> cq = cb.createQuery(this.clazz);
        Root<Entity> rootEntry = cq.from(this.clazz);
        CriteriaQuery<Entity> all = cq.select(rootEntry);
        TypedQuery<Entity> allQuery = getEntityManager().createQuery(all);
        return allQuery.getResultList();
	}
	
	protected abstract EntityManager getEntityManager();

}
