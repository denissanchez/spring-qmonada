package upn.solweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import upn.solweb.entidades.Producto;
import upn.solweb.servicios.IProductoServicio;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private IProductoServicio service;

	@GetMapping("/")
	public String index(Model model) {
		List<Producto> productos = service.listar();
		model.addAttribute("productos", productos);
		return "productos/index";
	}
	
	@GetMapping("/registrar")
	public String registrar(Model model) {
		return "productos/registrar";
	}
	
	@PostMapping("/registrar")
	public RedirectView registrar(Producto producto) {
		service.registrar(producto);
		return new RedirectView ("/productos/");
	}
}
