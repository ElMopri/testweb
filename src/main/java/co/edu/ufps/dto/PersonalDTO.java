package co.edu.ufps.dto;

import lombok.Data;

@Data
public class PersonalDTO {

	private Integer id;
	private String nombre;
	private String email;
	private TipoPersonalDTO tipoPersonalDTO;
}
