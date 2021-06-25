package upn.solweb.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import upn.solweb.entidades.Cita;
import upn.solweb.entidades.Servicio;
import upn.solweb.servicios.ICitaServicio;
import upn.solweb.servicios.IServicioServicio;

@Controller
@RequestMapping("/citas")
public class CitaController {

	@Autowired
	private ICitaServicio service;
	
	@Autowired
	private IServicioServicio servicioService;
	
	@GetMapping("/")
	public String index(Model model) {
		List<Cita> citas = service.listar();
		model.addAttribute("citas", citas);
		return "citas/index";
	}
	
	@GetMapping("/pendientes")
	public String pendientes(Model model) {
		List<Cita> citas = service.listar();
		citas.removeIf(cita -> (cita.getEstado().equals("COMPLETADO")));
		model.addAttribute("citas", citas);
		return "citas/index";
	}
	
	@GetMapping("/detalle/{id}")
	public String detalle(@PathVariable int id, Model model) {
		Cita cita = service.buscarPorId(id);
		model.addAttribute("cita", cita);
		return "citas/detalle";
	}
	
	@GetMapping("/registrar")
	public String registrar(Model model) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		Date now = new Date();
		model.addAttribute("minDate", formatter.format(now));
		List<Servicio> servicios = servicioService.listar();
		model.addAttribute("servicios", servicios);
		return "citas/registrar";
	}
	
	@PostMapping("/registrar")
	public RedirectView registrar(Cita cita) {
		service.registrar(cita);
		return new RedirectView ("/citas/detalle/" + cita.getId());
	}
	
	@GetMapping("/actualizar/{id}/{estado}")
	public RedirectView cambiarEstado(@PathVariable int id, @PathVariable String estado, Model model) {
		service.cambiarEstado(id, estado);
		return new RedirectView ("/citas/");
	}
}
