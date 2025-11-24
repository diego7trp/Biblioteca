package biblioteca.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import biblioteca.demo.models.Autor;
import jakarta.transaction.Transactional;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, Long> {
    List<Autor> findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase(String queryNombre,
            String queryApellido);

    @Modifying
    @Transactional
    @Query("UPDATE Autor a SET a.nombre = COALESCE(:nombre, a.nombre), a.apellido = COALESCE(:apellido, a.apellido) WHERE a.autorId = :id")
    void actualizarNombreYApellido(Long id, String nombre, String apellido);
}
