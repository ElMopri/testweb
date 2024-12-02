package co.edu.ufps.dto;

import lombok.Data;

@Data
public class PersonalDTO {

	private Integer id;
	private String nombre;
	private String email;
	private TipoPersonalDTO tipoPersonalDTO;
	
	public PersonalDTO() {
		this(null,null,null,null);
	};
	
	public PersonalDTO(Integer id, String nombre, String email, TipoPersonalDTO tipoPersonalDTO) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.tipoPersonalDTO = tipoPersonalDTO;
	}
}
