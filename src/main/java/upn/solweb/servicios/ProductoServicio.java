package upn.solweb.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upn.solweb.entidades.Producto;
import upn.solweb.repositorios.IProductoRepositorio;

@Service
public class ProductoServicio implements IProductoServicio {
	
	@Autowired
	private IProductoRepositorio repositorio;

	@Override
	public List<Producto> listar() {
		return repositorio.findAll();
	}

	@Override
	public void registrar(Producto producto) {
		repositorio.save(producto);
	}
	
}
