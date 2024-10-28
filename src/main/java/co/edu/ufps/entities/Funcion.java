package co.edu.ufps.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="funcion")
public class Funcion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // El 'id' será generado automáticamente
	private Integer id;
	private String descripcion;
	
	@ManyToMany(mappedBy = "funciones")
	@JsonIgnore
	List<TipoPersonal> tipoPersonal;
	
}
