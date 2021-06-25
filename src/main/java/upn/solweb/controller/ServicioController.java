package upn.solweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import upn.solweb.entidades.Servicio;
import upn.solweb.servicios.IServicioServicio;

@Controller
@RequestMapping("/servicios")
public class ServicioController {
	@Autowired
	private IServicioServicio service;
	
	@GetMapping("/")
	public String index(Model model) {
		List<Servicio> servicios = service.listar();
		model.addAttribute("servicios", servicios);
		return "servicios/index";
	}
	
	@GetMapping("/registrar")
	public String registrar(Model model) {
		return "servicios/registrar";
	}
	
	@PostMapping("/registrar")
	public RedirectView registrar(Servicio servicio) {
		service.registrar(servicio);
		return new RedirectView ("/servicios/");
	}
	
	@GetMapping("/eliminar/{id}")
	public RedirectView registrar(@PathVariable int id, Model model) {
		service.eliminar(id);
		return new RedirectView ("/servicios/");
	}
}
