package upn.solweb.servicios;

import java.util.List;

import upn.solweb.entidades.Servicio;

public interface IServicioServicio {
	public List<Servicio> listar();
	public void registrar(Servicio servicio);
	public void eliminar(int id);
}
