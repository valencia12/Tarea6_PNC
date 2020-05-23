package com.uca.capas.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema="public", name="importancia")

public class Importancia {
	@Id
	@Column(name="c_importancia")
	private Integer contribuyente;
	
	@Column(name="s_importancia")
	private String simportancia;

	@OneToMany(mappedBy="importancia", cascade=CascadeType.ALL)
	private List<Contribuyente> contribuyentes;
	
	public Importancia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getContribuyente() {
		return contribuyente;
	}

	public void setContribuyente(Integer contribuyente) {
		this.contribuyente = contribuyente;
	}

	public String getSimportancia() {
		return simportancia;
	}

	public void setSimportancia(String simportancia) {
		this.simportancia = simportancia;
	}
	
	
}
