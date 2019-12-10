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
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity//especifica que esta clase es mapeada por una tabla en una base de datos 
@Table(name="autor")//indica que es una tabla y su nombre
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)//en h2 no funciona , pero se utiliza para indicar que es una tabla singular y el autogenerate del id empieza de 0
public class AutorBean {
	
	@Id//indica que es el id de la tabla 
	@GeneratedValue(strategy = GenerationType.AUTO)//autogenera el valor de este campo
	@Column//indica que es una columna
	private long codAutor;
	
	@Column//indica que es una columna
	private String nombre;
	
	@ManyToMany(mappedBy="autores")//nombre del mapeo debe coincidir con el nombre de la lista de la otra clase 
	private List<LibroBean> libros = new ArrayList<LibroBean>();//creamos una lista en la que añadir los libros
	
	/**
	 * Operación que permite añadir libros al autor y esta autor a la lista de autores del libro
	 * @param libro
	 */
	
	public void addLibros(LibroBean libro) {

        if(!libros.contains(libro)) {//si no esta entra

            libros.add(libro);//añade el libro a la lista
            libro.addAutores(this);//añade este autor a la lista de autor de libro
        }
    }
	
	

	public long getCodAutor() {
		return codAutor;
	}

	public void setCodAutor(long codAutor) {
		this.codAutor = codAutor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "AutorBean [codAutor=" + codAutor + ", nombre=" + nombre + "]";
	}
	
	
	

	
}
