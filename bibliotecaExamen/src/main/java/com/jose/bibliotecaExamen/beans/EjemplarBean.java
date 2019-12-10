package com.jose.bibliotecaExamen.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity//especifica que esta clase es mapeada por una tabla en una base de datos 
@Table(name="ejemplar")//indica que es una tabla y su nombre
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)//en h2 no funciona , pero se utiliza para indicar que es una tabla singular y el autogenerate del id empieza de 0

public class EjemplarBean {

	@Id//indica que es el id de la tabla 
	@GeneratedValue(strategy = GenerationType.AUTO)//autogenera el valor de este campo
	@Column//indica que es una columna
	private long codEjemplar;
	
	@Column//indica que es una columna
	private String localizacion;
	
	@OneToMany(mappedBy="ejemplar")
	private List<SacarBean> extracciones = new ArrayList<SacarBean>();
	
		
	
	public void addExtraccion(SacarBean extraccion) {
		
		if(!extracciones.contains(extraccion)) {
			
			extracciones.add(extraccion);
			extraccion.setEjemplar(this);
		}
	}
	
	

	public long getCodEjemplar() {
		return codEjemplar;
	}

	public void setCodEjemplar(long codEjemplar) {
		this.codEjemplar = codEjemplar;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	@Override
	public String toString() {
		return "ejemplarBean [codEjemplar=" + codEjemplar + ", localizacion=" + localizacion + "]";
	}
	
	
	
	
}
