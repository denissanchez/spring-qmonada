package upn.solweb.servicios;

import java.util.List;

import upn.solweb.entidades.Producto;

public interface IProductoServicio {
	public List<Producto> listar();
	public void registrar(Producto producto);
}
