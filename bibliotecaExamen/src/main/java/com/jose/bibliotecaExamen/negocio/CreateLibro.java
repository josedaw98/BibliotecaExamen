package com.jose.bibliotecaExamen.negocio;

import javax.persistence.EntityManager;

import com.jose.bibliotecaExamen.beans.AutorBean;
import com.jose.bibliotecaExamen.beans.LibroBean;
import com.jose.bibliotecaExamen.util.ConnectionEntityManagerFactory;

/**
 * Clase que inserta libros en la base de datos
 * @author jose
 *
 */
public class CreateLibro {

	/**
	 * Crea un libro persistíendolo en la base de datos
	 * @param coche
	 */
	
public void create(LibroBean libro) {
		
		//recoge la conexion
		EntityManager entityManager = ConnectionEntityManagerFactory.getEntityManager().createEntityManager();
		
		//empieza la transaccion , persistomos y cerramos
		entityManager.getTransaction().begin();//transaccion
		entityManager.persist(libro);//persistomos
		entityManager.getTransaction().commit();//confirmamos la transaccion
		entityManager.close();//cerramos
	}
	
}
