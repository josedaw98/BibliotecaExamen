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
@Table(name="libro")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)//en h2 no funciona , pero se utiliza para indicar que es una tabla singular y el autogenerate del id empieza de 0
public class LibroBean {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)//autogenera el valor de este campo
	@Column 
	private long codLibro;
	
	
	@Column
	private String titulo;
	
	@Column
	private String ISBN;
	
	@Column
	private String editorial;
	
	@Column
	private Integer paginas;
	
	/*VArias biologoscon Varios Movimientos*/
	@ManyToMany
	private List<AutorBean> autores = new ArrayList<AutorBean>();
	
	public void addAutores(AutorBean autorBean) {
        if(!autores.contains(autorBean)) {//si no esta en la lista entra

            autores.add(autorBean);//lo añadea la lista
            autorBean.addLibros(this);//añade este librp a la lista de libros de autor
        }
    }
	

	public long getCodLibro() {
		return codLibro;
	}

	public void setCodLibro(long codLibro) {
		this.codLibro = codLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}

	@Override
	public String toString() {
		return "LibroBean [codLibro=" + codLibro + ", titulo=" + titulo + ", ISBN=" + ISBN + ", editorial=" + editorial
				+ ", paginas=" + paginas + "]";
	}
	
	
	
	
}
