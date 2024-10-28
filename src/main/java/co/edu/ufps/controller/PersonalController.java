package co.edu.ufps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;

import co.edu.ufps.entities.Personal;
import co.edu.ufps.services.PersonalService;

@RestController
@RequestMapping("/personals")
public class PersonalController {
    
    @Autowired
    private PersonalService personalService;

    @GetMapping
    public List<Personal> list() {
        return personalService.list();
    }

    @PostMapping
    public Personal create(@RequestBody Personal personal) {
        return personalService.create(personal);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personal> getById(@PathVariable Integer id) {
        return personalService.getById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Personal> update(@PathVariable Integer id, @RequestBody Personal personalDetails) {
        return personalService.update(id, personalDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return personalService.delete(id);
    }
	
/*	
	
	@Autowired
	public PersonalRepository personalRepository;
	
	@GetMapping
	public List<Personal> list(){
		List<Personal> personals = personalRepository.findAll();
		return personals;	
	}

	 // Crear un nuevo personal
    @PostMapping
    public Personal create(@RequestBody Personal personal) {
        return personalRepository.save(personal);
    }

    // Obtener un personal por ID
    @GetMapping("/{id}")
    public ResponseEntity<Personal> getById(@PathVariable Integer id) {
        Optional<Personal> personal = personalRepository.findById(id);
        return personal.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Actualizar un personal existente
    @PutMapping("/{id}")
    public ResponseEntity<Personal> update(@PathVariable Integer id, @RequestBody Personal personalDetails) {
        Optional<Personal> optionalPersonal = personalRepository.findById(id);
        
        if (!optionalPersonal.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        
        Personal personal = optionalPersonal.get();
        personal.setDocumento(personalDetails.getDocumento()); // Asumiendo que hay un campo nombre
        personal.setNombre(personalDetails.getNombre());
        personal.setEmail(personalDetails.getEmail());
        personal.setTelefono(personalDetails.getTelefono());
        // Actualiza otros campos según sea necesario
        
        Personal updatedPersonal = personalRepository.save(personal);
        return ResponseEntity.ok(updatedPersonal);
    }

    // Eliminar un personal por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!personalRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        
        personalRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
*/

}
