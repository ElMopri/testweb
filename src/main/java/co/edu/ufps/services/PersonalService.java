package co.edu.ufps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.dto.PersonalDTO;
import co.edu.ufps.dto.TipoPersonalDTO;
import co.edu.ufps.entities.Personal;
import co.edu.ufps.entities.TipoPersonal;
import co.edu.ufps.repositories.PersonalRepository;
import co.edu.ufps.repositories.TipoPersonalRepository;

@Service
public class PersonalService {

    @Autowired
    private PersonalRepository personalRepository;
    
    @Autowired
    private TipoPersonalRepository tipoPersonalRepository;

    public List<Personal> list() {
        return personalRepository.findAll();
    }

    public Personal create(Personal personal) {
        return personalRepository.save(personal);
    }

    public PersonalDTO getById(Integer id) {
        Optional<Personal> optionalPersonal = personalRepository.findById(id);
        if (!optionalPersonal.isPresent()) {
            return null;
        }
        Personal personal = optionalPersonal.get();
        TipoPersonalDTO tipoPersonalDTO = new TipoPersonalDTO();
        if (personal.getTipoPersonal() != null) {
        	tipoPersonalDTO.setDescripcion(personal.getTipoPersonal().getDescripcion());
        }else {
        	tipoPersonalDTO = null;
        }
        PersonalDTO personalDTO = new PersonalDTO(personal.getId(),personal.getNombre(),personal.getEmail(),tipoPersonalDTO);
        return personalDTO;
    }

    public Personal update(Integer id, Personal personalDetails) {
        Optional<Personal> optionalPersonal = personalRepository.findById(id);
        if (!optionalPersonal.isPresent()) {
            return null;
        }
        Personal personal = optionalPersonal.get();
        personal.setDocumento(personalDetails.getDocumento());
        personal.setNombre(personalDetails.getNombre());
        personal.setEmail(personalDetails.getEmail());
        personal.setTelefono(personalDetails.getTelefono());

        return personalRepository.save(personal);
    }

    public Personal delete(Integer id) {
        Optional<Personal> optionalPersonal = personalRepository.findById(id);

        if (!optionalPersonal.isPresent()) {
            return null;
        }

        Personal personal = optionalPersonal.get();
        personalRepository.deleteById(id);
        return personal;
    }
    
	public Personal addTipoPersonal(Integer id, Integer tipoPersonalId) {
		Optional<Personal> personalOpt =  personalRepository.findById(id);
		if (personalOpt.isPresent()) {
			Personal personal = personalOpt.get();
			Optional<TipoPersonal> tipoPersonalOpt = tipoPersonalRepository.findById(tipoPersonalId);
			if (tipoPersonalOpt.isPresent()) {
				personal.setTipoPersonal(tipoPersonalOpt.get());	
			}
			return personalRepository.save(personal);
		}
		return null;
	}

}

