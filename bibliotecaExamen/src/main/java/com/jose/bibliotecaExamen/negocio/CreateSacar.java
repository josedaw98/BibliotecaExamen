package com.jose.bibliotecaExamen.negocio;

import javax.persistence.EntityManager;

import com.jose.bibliotecaExamen.beans.AutorBean;
import com.jose.bibliotecaExamen.beans.SacarBean;
import com.jose.bibliotecaExamen.util.ConnectionEntityManagerFactory;

/**
 * Clase que inserta autores en la base de datos
 * @author jose
 *
 */
public class CreateSacar {

	
	/**
	 * Crea un autor persistíendolo en la base de datos
	 * @param coche
	 */
	
	public void create(SacarBean sacar) {
		
		//recoge la conexion
		EntityManager entityManager = ConnectionEntityManagerFactory.getEntityManager().createEntityManager();
		
		//empieza la transaccion , persistomos y cerramos
		entityManager.getTransaction().begin();//transaccion
		entityManager.persist(sacar);//persistomos
		entityManager.getTransaction().commit();//confirmamos la transaccion
		entityManager.close();//cerramos
	}
}
