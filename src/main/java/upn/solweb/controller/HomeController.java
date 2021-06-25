package upn.solweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import upn.solweb.entidades.Producto;
import upn.solweb.servicios.IProductoServicio;

@Controller
public class HomeController {

	@Autowired
	private IProductoServicio productoService;
	
	@GetMapping("/")
	public String index(Model model) {
		List<Producto> productos = productoService.listar();
		model.addAttribute("productos", productos);
		return "home/index";
	}
}
