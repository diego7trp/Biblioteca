package biblioteca.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import biblioteca.demo.models.LibroAutoreado;
import biblioteca.demo.models.LibroAutoreadoId;

@Repository
public interface LibroAutoreadoRepositorio extends JpaRepository<LibroAutoreado, LibroAutoreadoId> {
    List<LibroAutoreado> findByAutor_AutorId(Long autorId);

    List<LibroAutoreado> findByLibro_LibroId(Long libroId);
}
