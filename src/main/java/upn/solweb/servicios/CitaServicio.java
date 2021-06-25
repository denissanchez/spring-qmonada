package upn.solweb.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upn.solweb.entidades.Cita;
import upn.solweb.repositorios.ICitaRepositorio;

@Service
public class CitaServicio implements ICitaServicio {

	@Autowired
	private ICitaRepositorio repositorio;
	
	public CitaServicio() {
		super();
	}

	@Override
	public List<Cita> listar() {
		return repositorio.findAll();
	}

	@Override
	public void registrar(Cita cita) {
		cita.setEstado("PENDIENTE");
		repositorio.save(cita);
	}

	@Override
	public Cita buscarPorId(int id) {
		return repositorio.getById(id);
	}

	@Override
	public void cambiarEstado(int id, String nuevoEstado) {
		Cita cita = buscarPorId(id);
		cita.setEstado(nuevoEstado);
		repositorio.save(cita);
	}
	
}
