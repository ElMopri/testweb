package co.edu.ufps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import co.edu.ufps.entities.Personal;
import co.edu.ufps.repositories.PersonalRepository;

@Service
public class PersonalService {

    @Autowired
    private PersonalRepository personalRepository;

    public List<Personal> list() {
        return personalRepository.findAll();
    }

    public Personal create(Personal personal) {
        return personalRepository.save(personal);
    }

    public ResponseEntity<Personal> getById(Integer id) {
        Optional<Personal> personal = personalRepository.findById(id);
        return personal.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Personal> update(Integer id, Personal personalDetails) {
        Optional<Personal> optionalPersonal = personalRepository.findById(id);

        if (!optionalPersonal.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Personal personal = optionalPersonal.get();
        personal.setDocumento(personalDetails.getDocumento());
        personal.setNombre(personalDetails.getNombre());
        personal.setEmail(personalDetails.getEmail());
        personal.setTelefono(personalDetails.getTelefono());

        Personal updatedPersonal = personalRepository.save(personal);
        return ResponseEntity.ok(updatedPersonal);
    }

    public ResponseEntity<Void> delete(Integer id) {
        if (!personalRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        personalRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
