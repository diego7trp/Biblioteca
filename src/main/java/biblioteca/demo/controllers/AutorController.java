package biblioteca.demo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import biblioteca.demo.models.Autor;
import biblioteca.demo.services.IAutorService;

@Controller
@RequestMapping("/autores")
public class AutorController {
    private final IAutorService autorService;

    public AutorController(IAutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public String getAutores(Model mode) {
        mode.addAttribute("autores", autorService.listarAutores());
        return "autor/listar";
    }

    @GetMapping("/nuevo")
    public String formNuevoAutor(Model model) {
        model.addAttribute("autor", new Autor());
        return "autor/crear";
    }

    @PostMapping("/guardar")
    public String guardarAutor(@ModelAttribute Autor autor) {
        autorService.crearAutor(autor);
        return "redirect:/autores";
    }

    @GetMapping("/editar/{id}")
    public String formEditarAutor(@PathVariable Long id, Model model) {
        model.addAttribute("autor", autorService.buscarPorId(id));
        return "autor/editar";
    }

    @PostMapping("/editar/{id}")
    public String actualizarAutor(@PathVariable Long id, @ModelAttribute Autor autor) {
        autorService.actualizaDireccion(id, autor.getCiudad());
        autorService.actualizarNombreYApellido(id, autor.getNombre(), autor.getApellido());
        return "redirect:/autores";
    }

    @GetMapping("/buscar")
    public String buscarAutor(@RequestParam("nombre") String nombre, Model model) {
        List<Autor> autores = autorService.buscarPorNombreOApellido(nombre);
        model.addAttribute("autores", autores);
        return "autor/listar";
    }

}
