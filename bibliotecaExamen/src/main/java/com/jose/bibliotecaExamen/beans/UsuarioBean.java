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
@Table(name="usuario")//indica que es una tabla y su nombre
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)//en h2 no funciona , pero se utiliza para indicar que es una tabla singular y el autogenerate del id empieza de 0

public class UsuarioBean {

	
	@Id//indica que es el id de la tabla 
	@GeneratedValue(strategy = GenerationType.AUTO)//autogenera el valor de este campo
	@Column//indica que es una columna
	private long codUsuario;
	
	@Column//indica que es una columna
	private String nombre;
	
	@Column//indica que es una columna
	private String telefono;
	
	@Column//indica que es una columna
	private String direccion;

	@OneToMany(mappedBy="usuario")
	private List<SacarBean> extracciones = new ArrayList<SacarBean>();
	
		
	
	public void addExtraccion(SacarBean extraccion) {
		
		if(!extracciones.contains(extraccion)) {
			
			extracciones.add(extraccion);
			extraccion.setUsuario(this);
		}
	}
	
	
	
	public long getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(long codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "UsuarioBean [codUsuario=" + codUsuario + ", nombre=" + nombre + ", telefono=" + telefono
				+ ", direccion=" + direccion + "]";
	}
	
	
	
	
}
