package biblioteca.demo.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@IdClass(LibroAutoreadoId.class)
@Table(name = "Libros_autoreados")
public class LibroAutoreado {
    @Id
    @Column(name = "autorId")
    private Long autorId;

    @Id
    @Column(name = "libroId")
    private Long libroId;

    @Id
    private LocalDateTime fecha;

    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "autorId", insertable = false, updatable = false)
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "libroId", insertable = false, updatable = false)
    private Libro libro;

    public LibroAutoreado() {
    }

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    public Long getLibroId() {
        return libroId;
    }

    public void setLibroId(Long libroId) {
        this.libroId = libroId;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
}
