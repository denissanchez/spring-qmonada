package upn.solweb.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import upn.solweb.entidades.Producto;

public interface IProductoRepositorio extends JpaRepository<Producto, Integer> {
}
