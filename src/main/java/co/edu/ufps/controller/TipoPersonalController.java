package co.edu.ufps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<TipoPersonal> list() {
        return tipoPersonalService.list();
    }
	
    @GetMapping("/{id}")
    public TipoPersonal get(@PathVariable Integer id) {
    	return tipoPersonalService.get(id);
    }
    
	@GetMapping("/{id}/funciones")
	public List<Funcion> getFuncions(@PathVariable Integer id) {
		return tipoPersonalService.get(id).getFunciones();
	}
	
	@PostMapping()
	public TipoPersonal create(@RequestBody TipoPersonal tipoPersona) {
		
		TipoPersonal nuevaTipoPersonal = tipoPersonalService.create(tipoPersona);
		return nuevaTipoPersonal;
	}
	
	@PostMapping("/{id}/agregar_funciones/{funcionId}")
	public TipoPersonal create(@PathVariable Integer id, @PathVariable Integer funcionId) {
		TipoPersonal nuevaTipoPersonal = tipoPersonalService.addFuncion(id, funcionId);
		return nuevaTipoPersonal;
	}
	
	@DeleteMapping("/{id}/remover_funciones/{funcionId}")
	public TipoPersonal delete(@PathVariable Integer id, @PathVariable Integer funcionId) {
		TipoPersonal nuevaTipoPersonal = tipoPersonalService.removeFuncion(id, funcionId);
		return nuevaTipoPersonal;
	}
	
	@PutMapping("/{id}")
	public TipoPersonal update(@PathVariable Integer id, @RequestBody TipoPersonal tipoPersonalDetails) {
		return tipoPersonalService.update(id,tipoPersonalDetails);
	}
	
	@DeleteMapping("/{id}")
	public TipoPersonal delete(@PathVariable Integer id) {
		return tipoPersonalService.delete(id);
	}
    
}
