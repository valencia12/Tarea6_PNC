package com.uca.capas.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(schema="public", name="contribuyente")
public class Contribuyente {
	@Id
	@Column(name="c_contribuyente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer contribuyente;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "c_importancia")
	private Importancia importancia;
	
	@Column(name="s_nombre")
	@NotEmpty(message="El campo no puede estar vacio")
	private String nombre;
	
	@Column(name="s_apellido")
	@NotEmpty(message="El campo no puede estar vacio")
	private String apellido;
	
	@Column(name="s_nit")
	@NotEmpty(message="El campo no puede estar vacio")
	private String nit;
	
	@Column(name="f_fecha_ingreso")
	private Date fecha;

	
	public Contribuyente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getContribuyente() {
		return contribuyente;
	}

	public void setContribuyente(Integer contribuyente) {
		this.contribuyente = contribuyente;
	}

	public Importancia getImportancia() {
		return importancia;
	}

	public void setImportancia(Importancia importancia) {
		this.importancia = importancia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date date1) {
		this.fecha = date1;		
	}

	

	
	
	
	
}
