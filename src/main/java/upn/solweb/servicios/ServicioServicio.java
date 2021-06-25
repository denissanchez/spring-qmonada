package upn.solweb.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upn.solweb.entidades.Servicio;
import upn.solweb.repositorios.IServicioRepositorio;

@Service
public class ServicioServicio implements IServicioServicio {

	@Autowired
	private IServicioRepositorio repositorio;
	
	@Override
	public List<Servicio> listar() {
		return repositorio.findAll();
	}

	@Override
	public void registrar(Servicio servicio) {
		repositorio.save(servicio);
	}

	@Override
	public void eliminar(int id) {
		repositorio.deleteById(id);
	}

}
