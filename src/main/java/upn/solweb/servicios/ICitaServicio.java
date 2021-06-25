package upn.solweb.servicios;

import java.util.List;
import upn.solweb.entidades.Cita;


public interface ICitaServicio {
	public List<Cita> listar();
	public void registrar(Cita cita);
	public Cita buscarPorId(int id);
	public void cambiarEstado(int id, String nuevoEstado);
}
