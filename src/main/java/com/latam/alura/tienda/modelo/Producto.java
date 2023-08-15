package com.latam.alura.tienda.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/* @Entity - Hibernate y JPA, ellos realizan un mapeamento de los elementos existentes en 
nuestra clase para compararlos con el modelo en la base de datos, entonces por 
default Hibernate entiende y JPA, entiende que el nombre de la clase es el mismo
 nombre que existe para la tabla.
*/

@Entity
//La tabla en la BD se llama productos, si la tama se llama igual que la clase "producto" no hay necesidade de definir la tabla con @table
@Table(name="productos") 
public class Producto { //El nombre de la clase tiene que ser igual que la tabla de la BD, si no es igual entonces la definimos arriba con @Table(name="productos")  - para asi, realizar el mapeamiento.
	//Los atributos de la clase deben de ser igual que los campos de la BD. Sino, entonces se debe definir arriba del atributo de la clase, utilizar @Column(name="nombres")  - para asi, realizar el mapeamiento.
	
	@Id  //Para indicarle a nuestro proyecto cuál va a ser el id o el identificador de cada una de esas filas,
	@GeneratedValue(strategy= GenerationType.IDENTITY) //Indica que quien tiene la responsabilidad de generar ese identificador id va a ser siempre de la BD. Entonces, para nosotros indicarle que la responsabilidad no pertenece al usuario, sino a la base de datos.
	private Long id;
	private String nombre;
	private String descripcion;
	private BigDecimal precio;
	
	
	//Getters and Setters
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	
	

}