package upn.solweb.entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cita")
public class Cita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String servicio;
	private String nombres;
	private String apellidos;
	private String datetime;
	private String comentario;
	private String estado;
	

	public Cita() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	
	public String getCliente() {
		return nombres + " " + apellidos;
	}
	
	public String getDetalleUrl() {
		return "/citas/detalle/" + id;
	}
	
	public String getDate() throws ParseException {
		SimpleDateFormat formatterBd = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		Date date = formatterBd.parse(datetime);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		return formatter.format(date);
	}

	public String getTime() throws ParseException {
		SimpleDateFormat formatterBd = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		Date date = formatterBd.parse(datetime);
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		return formatter.format(date);
	}

}
