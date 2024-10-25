package co.edu.ufps.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="tipo_personal")
public class TipoPersonal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // El 'id' será generado automáticamente
	private Integer id;
	private String descripcion;
	
	@OneToMany(mappedBy = "tipoPersonal", cascade= CascadeType.ALL)
	@JsonIgnore
	List<Personal> personal = null;
	
}
