package co.edu.ufps.services;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import co.edu.ufps.models.Usuario;

@Service
public class UsuarioService {
	private List<Usuario> usuarios = new ArrayList<>();

	public UsuarioService() {
		usuarios.add(new Usuario("Usuario1", "Usuario 1", "usuario1@example.com", new Date(), "A"));
		usuarios.add(new Usuario("Usuario2", "Usuario 2", "usuario2@example.com", new Date(), "A"));
	}

	public List<Usuario> getAllUsers() {
		return usuarios;
	}

	public Usuario getUserById(String username) {
		for (Usuario user : usuarios) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}

	public void addUser(Usuario user) {
		usuarios.add(user);
	}

	public void updateUser(String username, Usuario user) {
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getUsername().equals(username)) {
				usuarios.set(i, user);
				break;
			}
		}
	}

	public void deleteUser(String username) {
		usuarios.removeIf(user -> user.getUsername().equals(username));
	}
}