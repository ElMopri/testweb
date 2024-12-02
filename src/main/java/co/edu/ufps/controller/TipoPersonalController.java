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
import co.edu.ufps.services.TipoPersonalService;

@RestController
@RequestMapping("/tipo_personal")
public class TipoPersonalController {

	@Autowired
	private TipoPersonalService tipoPersonalService;

	@GetMapping
	public ResponseEntity<List<TipoPersonal>> list() {
		return ResponseEntity.ok(tipoPersonalService.list());
	}

	@GetMapping("/{id}")
	public ResponseEntity<TipoPersonal> get(@PathVariable Integer id) {
		return ResponseEntity.ok(tipoPersonalService.get(id));
	}

	@GetMapping("/{id}/funciones")
	public ResponseEntity<List<Funcion>> getFuncions(@PathVariable Integer id) {
		return ResponseEntity.ok(tipoPersonalService.get(id).getFunciones());
	}

	@PostMapping()
	public ResponseEntity<TipoPersonal> create(@RequestBody TipoPersonal tipoPersona) {
		TipoPersonal nuevaTipoPersonal = tipoPersonalService.create(tipoPersona);
		return ResponseEntity.ok(nuevaTipoPersonal);
	}

	@PostMapping("/{id}/agregar_funciones/{funcionId}")
	public ResponseEntity<TipoPersonal> create(@PathVariable Integer id, @PathVariable Integer funcionId) {
		TipoPersonal nuevaTipoPersonal = tipoPersonalService.addFuncion(id, funcionId);
		return ResponseEntity.ok(nuevaTipoPersonal);
	}

	@DeleteMapping("/{id}/remover_funciones/{funcionId}")
	public ResponseEntity<TipoPersonal> deleteFuncion(@PathVariable Integer id, @PathVariable Integer funcionId) {
		TipoPersonal nuevaTipoPersonal = tipoPersonalService.removeFuncion(id, funcionId);
		return ResponseEntity.ok(nuevaTipoPersonal);
	}

	@PutMapping("/{id}")
	public ResponseEntity<TipoPersonal> update(@PathVariable Integer id,
			@RequestBody TipoPersonal tipoPersonalDetails) {
		TipoPersonal updatedTipoPersonal = tipoPersonalService.update(id, tipoPersonalDetails);
		return ResponseEntity.ok(updatedTipoPersonal);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<TipoPersonal> delete(@PathVariable Integer id) {
		TipoPersonal deletedTipoPersonal = tipoPersonalService.delete(id);
		return ResponseEntity.ok(deletedTipoPersonal);
	}

}
