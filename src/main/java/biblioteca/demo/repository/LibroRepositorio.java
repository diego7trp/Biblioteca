package biblioteca.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import biblioteca.demo.models.Libro;
import jakarta.transaction.Transactional;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, Long> {

    Libro findByNombreLibro(String nombreLibro);

    @Modifying
    @Transactional
    @Query("UPDATE Libro l SET l.nombreLibro = COALESCE(:nombre, l.nombreLibro), l.precioPublico = COALESCE(:precio, l.precioPublico) WHERE l.libroId = :id")
    void actualizarPrecioPublico(Long id, String nombre, Double precioPublico);
}
