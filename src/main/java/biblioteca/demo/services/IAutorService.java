package biblioteca.demo.services;

import java.util.List;

import biblioteca.demo.models.Autor;

public interface IAutorService {
    Long crearAutor(Autor autor);

    void actualizarNombreYApellido(Long id, String nombre, String apellido);

    List<Autor> buscarPorNombreOApellido(String query);

    List<Autor> listarAutores();

    Autor buscarPorId(Long id);

    void actualizaDireccion(Long idAutor, String nuevaCiudad);
}
