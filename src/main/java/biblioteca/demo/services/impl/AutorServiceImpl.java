package biblioteca.demo.services.impl;

import biblioteca.demo.services.IAutorService;
import biblioteca.demo.models.Autor;
import biblioteca.demo.repository.AutorRepositorio;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
class AutorServiceImpl implements IAutorService {
    private final AutorRepositorio autorRepositorio;

    public AutorServiceImpl(AutorRepositorio autorRepositorio) {
        this.autorRepositorio = autorRepositorio;
    }

    @Override
    public Long crearAutor(Autor autor) {
        if (autor == null) {
            throw new IllegalArgumentException("El autor no puede ser nulo");
        }
        return autorRepositorio.save(autor).getAutorId();
    }

    @Override
    public List<Autor> buscarPorNombreOApellido(String query) {
        if (query == null || query.trim().isEmpty()) {
            throw new IllegalArgumentException("El query de búsqueda no puede ser nulo o vacío");
        }
        return autorRepositorio.findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase(query, query);
    }

    @Override
    public void actualizarNombreYApellido(Long id, String nombre, String apellido) {
        autorRepositorio.actualizarNombreYApellido(id, nombre, apellido);
    }

    @Override
    public void actualizaDireccion(Long idAutor, String nuevaCiudad) {
        if (idAutor == null || nuevaCiudad == null || nuevaCiudad.isEmpty()) {
            throw new IllegalArgumentException("ID del autor y nueva ciudad no pueden ser nulos o vacíos");
        }
        Autor autor = autorRepositorio.findById(idAutor).orElse(null);
        if (autor != null) {
            autor.setCiudad(nuevaCiudad);
            autorRepositorio.save(autor);
        } else {
            throw new IllegalArgumentException("Autor con ID " + idAutor + " no encontrado");
        }
    }

    @Override
    public List<Autor> listarAutores() {
        return autorRepositorio.findAll();
    }

    @Override
    public Autor buscarPorId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID del autor no puede ser nulo");
        }
        return autorRepositorio.findById(id).orElse(null);
    }

}