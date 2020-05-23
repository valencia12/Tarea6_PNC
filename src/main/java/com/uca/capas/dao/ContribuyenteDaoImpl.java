package com.uca.capas.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;


@Repository
public class ContribuyenteDaoImpl implements ContribuyenteDao{
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;

	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from public.contribuyente");
		Query query = entityManager.createNativeQuery(sb.toString(), Contribuyente.class);
		List<Contribuyente> resulset = query.getResultList();
		
		return resulset;
	}
	@Override
	public List<Importancia> findAllImportance() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("Select * from public.importancia");
		Query query = entityManager.createNativeQuery(sb.toString(), Importancia.class);
		List<Importancia> resulset = query.getResultList();
	
		return resulset;
	}

	@Override
	@Transactional
	public void create(Contribuyente c) throws DataAccessException {
		entityManager.persist(c);
	}
	
	
	
}
