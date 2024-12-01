package co.edu.ufps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.ufps.entities.Funcion;
import co.edu.ufps.entities.TipoPersonal;
import co.edu.ufps.services.FuncionService;

@RestController
@RequestMapping("/funcion")
public class FuncionController {

    @Autowired
    public FuncionService funcionService;

    @GetMapping()
    public ResponseEntity<List<Funcion>> list() {
        return ResponseEntity.ok(funcionService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcion> get(@PathVariable Integer id) {
        return ResponseEntity.ok(funcionService.get(id));
    }

    @GetMapping("/{id}/tipo_personals")
    public ResponseEntity<List<TipoPersonal>> getFuncions(@PathVariable Integer id) {
        return ResponseEntity.ok(funcionService.get(id).getTipoPersonal());
    }

    @PostMapping()
    public ResponseEntity<Funcion> create(@RequestBody Funcion funcion) {
        Funcion nuevaFuncion = funcionService.create(funcion);
        return ResponseEntity.ok(nuevaFuncion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcion> update(@PathVariable Integer id, @RequestBody Funcion funcionDetails) {
        return ResponseEntity.ok(funcionService.update(id, funcionDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Funcion> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(funcionService.delete(id));
    }
}
