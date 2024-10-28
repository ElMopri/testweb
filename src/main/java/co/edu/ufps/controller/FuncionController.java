package co.edu.ufps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ufps.entities.Funcion;
import co.edu.ufps.entities.TipoPersonal;
import co.edu.ufps.services.FuncionService;

@RestController
@RequestMapping("/funcion")
public class FuncionController {

	@Autowired
	public FuncionService funcionService;
	
	@GetMapping()
	public List<Funcion> list() {
		return funcionService.list();
	}
	
	@GetMapping("/{id}")
	public Funcion get(@PathVariable Integer id) {
		return funcionService.get(id);
	}
	
	@GetMapping("/{id}/tipo_personals")
	public List<TipoPersonal> getFuncions(@PathVariable Integer id) {
		return funcionService.get(id).getTipoPersonal();
	}
	
	@PostMapping()
	public Funcion create(@RequestBody Funcion funcion) {
		
		Funcion nuevaFuncion = funcionService.create(funcion);
		return nuevaFuncion;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Funcion> update(@PathVariable Integer id, @RequestBody Funcion funcionDetails) {
		return funcionService.update(id, funcionDetails);
	}
	
	@DeleteMapping("/{id}")
	public Funcion delete(@PathVariable Integer id) {
		return funcionService.delete(id);
	}
	
}
