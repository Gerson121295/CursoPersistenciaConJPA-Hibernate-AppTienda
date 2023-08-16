package com.latam.alura.tienda.dao;

import java.util.List;

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
	
	public void actualizar(Producto producto) {
        this.em.merge(producto);
    }

    public void remover(Producto producto) {
        producto=this.em.merge(producto);
        this.em.remove(producto);
    }
    
    /*//code dado
    public void remover(Producto producto) {
        categoria=this.em.merge(producto);
        this.em.remove(producto);
    }
	*/
    
    //Consulta por id
    public Producto consultaPorId(Long id) {
    	return em.find(Producto.class, id);
    }
	
    //Consultar todos los elementos(productos) de la tabla Producto
    public List<Producto> consultarTodos(){
    	String jpql = "SELECT P FROM Producto AS P "; //en JPQL no se utiliza el * si no la letra del alias definido: SELECT * FROM Producto P;  //lista a traves de JPQL (Java Persistence Query Language)
    	return em.createQuery(jpql, Producto.class).getResultList();
    }
    
    //Consulta por Nombre
    public List<Producto> consultaPorNombre(String nombre){
    	String jpql = " SELECT P FROM Producto AS P WHERE P.nombre=:nombre"; //si queremos agregar mas parametros a buscar seria asi:  (WHERE  P.nombre=:nombre AND P.descripcion=:descripcion";
    	return em.createQuery(jpql).setParameter("nombre", nombre).getResultList(); // recibe la posicion("nombre") y se le envia la variable(nombre) que contiene la palabra a buscar, y obtiene una lista de resultados.
    }
    
    //Consulta por nombre de Categoria
   
    public List<Producto> consultaPorNombreDeCategoria(String nombre){
    	String jpql="SELECT p FROM Producto AS p WHERE p.categoria.nombre=:nombre";
    	return em.createQuery(jpql).setParameter("nombre", nombre).getResultList();
    }
    
}




