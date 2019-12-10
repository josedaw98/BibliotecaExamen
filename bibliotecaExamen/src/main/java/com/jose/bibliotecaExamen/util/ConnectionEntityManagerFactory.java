package com.jose.bibliotecaExamen.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class ConnectionEntityManagerFactory {

	private static EntityManagerFactory entityManagerFactory = null;//instaciamos el obejto de su porpia clase a null
	
	private ConnectionEntityManagerFactory() {//creamos un constructor
		
		entityManagerFactory = Persistence.createEntityManagerFactory("com.jose.bibliotecaExamen.H2");//el constructor iguala el objeto que creamos antes al entity que genera el persistence
	}
	
	/*CREAMOS UN METODO STATICO PARA LLAMAR AL CONSTRUCTOR Y QUE NOS PERMITA CREAR EL OBEJTO SOLO UNA VE Z*/
	
	public static EntityManagerFactory getEntityManager() {
		
		if(entityManagerFactory==null) {//COMPROBAMOS SI EXISTE EL ENTITY
			
			new ConnectionEntityManagerFactory();//SI NO EXISTE LO CREA
		}
		return entityManagerFactory;//SI EXISTE LO DEVUELVO
	}
}