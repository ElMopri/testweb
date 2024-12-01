package co.edu.ufps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.ufps.entities.Personal;
import co.edu.ufps.services.PersonalService;

@RestController
@RequestMapping("/personals")
public class PersonalController {

    @Autowired
    private PersonalService personalService;

    @GetMapping
    public ResponseEntity<List<Personal>> list() {
        return ResponseEntity.ok(personalService.list());
    }

    @PostMapping
    public ResponseEntity<Personal> create(@RequestBody Personal personal) {
        Personal nuevaPersonal = personalService.create(personal);
        return ResponseEntity.ok(nuevaPersonal);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personal> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(personalService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Personal> update(@PathVariable Integer id, @RequestBody Personal personalDetails) {
        return ResponseEntity.ok(personalService.update(id, personalDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Personal> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(personalService.delete(id));
    }

    @PostMapping("/{id}/agregar_tipo_personal/{tipoPersonalId}")
    public ResponseEntity<Personal> create(@PathVariable Integer id, @PathVariable Integer tipoPersonalId) {
        Personal nuevaPersonal = personalService.addTipoPersonal(id, tipoPersonalId);
        return ResponseEntity.ok(nuevaPersonal);
    }
}

