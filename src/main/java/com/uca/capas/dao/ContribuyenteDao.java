package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;

public interface ContribuyenteDao {
	public List<Contribuyente> findAll() throws DataAccessException;
	public void create(Contribuyente contribuyente) throws DataAccessException;
	public List<Importancia> findAllImportance() throws DataAccessException;
}