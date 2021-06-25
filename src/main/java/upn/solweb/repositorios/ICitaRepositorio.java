package upn.solweb.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import upn.solweb.entidades.Cita;

public interface ICitaRepositorio extends JpaRepository<Cita, Integer> {
}
