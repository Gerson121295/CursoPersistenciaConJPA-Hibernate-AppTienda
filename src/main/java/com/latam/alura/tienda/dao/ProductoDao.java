package com.latam.alura.tienda.dao;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.modelo.Producto;

public class ProductoDao {

	/*
	 * Esta clase va a tener los métodos de consulta, así como de guardar o 
	 * actualizar un registro. Para eso tiene que utilizar el EntityManager, 
	 * por lo que se lo vamos a pasar como atributo hacer un atributo privado 
	 * del tipo EntityManager.
	 * 
	 */
	private EntityManager em;

	public ProductoDao(EntityManager em) {
		this.em = em;
	}
	
	public void guardar(Producto producto) {
		this.em.persist(producto);
	}
	
	
	
}