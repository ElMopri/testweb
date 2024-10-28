package co.edu.ufps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import co.edu.ufps.entities.Funcion;
import co.edu.ufps.entities.Personal;
import co.edu.ufps.entities.TipoPersonal;
import co.edu.ufps.repositories.FuncionRepository;
import co.edu.ufps.repositories.TipoPersonalRepository;

@Service
public class TipoPersonalService {

    @Autowired
    private TipoPersonalRepository tipoPersonalRepository;
	@Autowired
	public FuncionRepository funcionRepository;

    public List<TipoPersonal> list() {
        return tipoPersonalRepository.findAll();
    }
    
    public TipoPersonal get(Integer id) {
    	Optional<TipoPersonal> tipoPersonalOpt = tipoPersonalRepository.findById(id);
    	if(tipoPersonalOpt.isPresent()) {
    		return tipoPersonalOpt.get();
    	}
    	return null;
    }
    
	public TipoPersonal delete(Integer id) {
		Optional<TipoPersonal> tipoPersonalOpt =  tipoPersonalRepository.findById(id);
		
		if (tipoPersonalOpt.isPresent()) {
			
			TipoPersonal tipoPersonal = tipoPersonalOpt.get();
			tipoPersonalRepository.delete(tipoPersonal);
			return tipoPersonal;
		}
		
		return null;
	}

	public TipoPersonal create(TipoPersonal tipoPersona) {
		return tipoPersonalRepository.save(tipoPersona);
	}

    public ResponseEntity<TipoPersonal> update(Integer id, TipoPersonal tipoPersonalDetails) {
        Optional<TipoPersonal> tipoPersonalOpt = tipoPersonalRepository.findById(id);

        if (!tipoPersonalOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        TipoPersonal tipoPersonal = tipoPersonalOpt.get();
        tipoPersonal.setDescripcion(tipoPersonalDetails.getDescripcion());

        TipoPersonal updatedTipoPersonal = tipoPersonalRepository.save(tipoPersonal);
        return ResponseEntity.ok(updatedTipoPersonal);
    }

	public TipoPersonal addFuncion(Integer id, Integer funcionId) {
		Optional<TipoPersonal> tipoPersonalOpt =  tipoPersonalRepository.findById(id);
		if (tipoPersonalOpt.isPresent()) {
			TipoPersonal tipoPersonal = tipoPersonalOpt.get();
			Optional<Funcion> funcionOpt = funcionRepository.findById(funcionId);
			if (funcionOpt.isPresent()) {
				tipoPersonal.addFuncion(funcionOpt.get());	
			}
			return tipoPersonalRepository.save(tipoPersonal);
		}
		return null;
	}
	
}
