package co.edu.ufps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.entities.Funcion;
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
		if (tipoPersonalOpt.isPresent()) {
			return tipoPersonalOpt.get();
		}
		return null;
	}

	public TipoPersonal delete(Integer id) {
		Optional<TipoPersonal> tipoPersonalOpt = tipoPersonalRepository.findById(id);

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

	public TipoPersonal update(Integer id, TipoPersonal tipoPersonalDetails) {
		Optional<TipoPersonal> tipoPersonalOpt = tipoPersonalRepository.findById(id);

		if (!tipoPersonalOpt.isPresent()) {
			return null;
		}

		TipoPersonal tipoPersonal = tipoPersonalOpt.get();
		tipoPersonal.setDescripcion(tipoPersonalDetails.getDescripcion());

		return tipoPersonalRepository.save(tipoPersonal);
	}

	public TipoPersonal addFuncion(Integer id, Integer funcionId) {
		Optional<TipoPersonal> tipoPersonalOpt = tipoPersonalRepository.findById(id);
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

	public TipoPersonal removeFuncion(Integer id, Integer funcionId) {
		Optional<TipoPersonal> tipoPersonalOpt = tipoPersonalRepository.findById(id);
		if (tipoPersonalOpt.isPresent()) {
			TipoPersonal tipoPersonal = tipoPersonalOpt.get();
			Optional<Funcion> funcionOpt = funcionRepository.findById(funcionId);
			if (funcionOpt.isPresent()) {
				tipoPersonal.removeFuncion(funcionOpt.get());
			}
			return tipoPersonalRepository.save(tipoPersonal);
		}
		return null;
	}

	public TipoPersonal addFuncionSinRepetidos(Integer id, Integer funcionId) {
		Optional<TipoPersonal> tipoPersonalOpt = tipoPersonalRepository.findById(id);
		if (tipoPersonalOpt.isPresent()) {
			TipoPersonal tipoPersonal = tipoPersonalOpt.get();
			Optional<Funcion> funcionOpt = funcionRepository.findById(funcionId);

			if (funcionOpt.isPresent()) {
				Funcion funcion = funcionOpt.get();

				// Verifica si la función ya existe en el conjunto de funciones de tipoPersonal
				if (!tipoPersonal.getFunciones().contains(funcion)) {
					tipoPersonal.addFuncion(funcion); // Agrega solo si no existe
				}
			}
			return tipoPersonalRepository.save(tipoPersonal);
		}
		return null;
	}

}
