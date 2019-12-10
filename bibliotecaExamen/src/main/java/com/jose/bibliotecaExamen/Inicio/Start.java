package com.jose.bibliotecaExamen.Inicio;

import com.jose.bibliotecaExamen.beans.AutorBean;
import com.jose.bibliotecaExamen.beans.EjemplarBean;
import com.jose.bibliotecaExamen.beans.LibroBean;
import com.jose.bibliotecaExamen.beans.SacarBean;
import com.jose.bibliotecaExamen.beans.UsuarioBean;
import com.jose.bibliotecaExamen.negocio.CreateAutor;
import com.jose.bibliotecaExamen.negocio.CreateEjemplar;
import com.jose.bibliotecaExamen.negocio.CreateLibro;
import com.jose.bibliotecaExamen.negocio.CreateSacar;
import com.jose.bibliotecaExamen.negocio.CreateUsuario;

public class Start {

	public static void main(String[] args) {
	
/*
	AutorBean jose = new AutorBean();
	jose.setNombre("jose");
	
	AutorBean pablo = new AutorBean();
	pablo.setNombre("pablo");
	
	
	LibroBean harryPotter = new LibroBean();
	harryPotter.setISBN("123");
	harryPotter.setEditorial("santillana");
	harryPotter.setPaginas(300);
	harryPotter.setTitulo("Harry Potter");
	
	LibroBean anillos = new LibroBean();
	anillos.setISBN("321");
	anillos.setEditorial("santillana");
	anillos.setPaginas(450);
	anillos.setTitulo("Señor de los anillos");
	
	
	

	
		jose.addLibros(anillos);
		pablo.addLibros(harryPotter);
	
	
	

	
	CreateAutor createAutor = new CreateAutor();
	createAutor.create(jose);
	createAutor.create(pablo);
	
	
	CreateLibro createLibro = new CreateLibro();
	createLibro.create(harryPotter);
	createLibro.create(anillos);
	
	*/
		
		
		UsuarioBean marcos = new UsuarioBean();
		marcos.setNombre("Marcos");
		marcos.setDireccion("Oviedo");
		marcos.setTelefono("666777888");
		
		UsuarioBean maria = new UsuarioBean();
		maria.setNombre("Maria");
		maria.setDireccion("Gijon");
		maria.setTelefono("444555666");
		
		CreateUsuario createUsuario = new CreateUsuario();
		createUsuario.create(marcos);
		createUsuario.create(maria);
		
		
		
		
		
		
		
		
		
		
		
		
		
		EjemplarBean ejemplarHarryPotterI = new EjemplarBean();
		ejemplarHarryPotterI.setLocalizacion("5D6H");
		
		EjemplarBean ejemplarHarryPotterII = new EjemplarBean();
		ejemplarHarryPotterII.setLocalizacion("7H9B");
		
		CreateEjemplar createEjemplar = new CreateEjemplar();
		createEjemplar.create(ejemplarHarryPotterI);
		createEjemplar.create(ejemplarHarryPotterII);
		
		
		
		
		
		
		
		
		
		
		
		/*EXTRACION 1*/
		SacarBean extraccion1 = new SacarBean();
		extraccion1.setFechaPrestamo("enero");
		extraccion1.setFechaDevolucion("febrero");
		
		/*EXTRACION 2*/
		SacarBean extraccion2 = new SacarBean();
		extraccion2.setFechaPrestamo("febrero");
		extraccion2.setFechaDevolucion("febrero");

		/*EXTRACION 3*/
		SacarBean extraccion3 = new SacarBean();
		extraccion3.setFechaPrestamo("marzo");
		extraccion3.setFechaDevolucion("abril");
		
		
		// enlazo la extracción 1
		marcos.addExtraccion(extraccion1);
		ejemplarHarryPotterI.addExtraccion(extraccion1);
		
		// enlazo la extracción 2
		marcos.addExtraccion(extraccion2);
		ejemplarHarryPotterII.addExtraccion(extraccion2);
		
		// enlazo la extracción 3
		maria.addExtraccion(extraccion3);
		ejemplarHarryPotterI.addExtraccion(extraccion3);
		
		
		
		
		
		
		
		
		CreateSacar createSacar = new CreateSacar();
		createSacar.create(extraccion1);
		createSacar.create(extraccion2);
		createSacar.create(extraccion3);
	}
	
}

