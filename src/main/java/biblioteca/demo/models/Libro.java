package biblioteca.demo.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LibroId")
    private Long libroId;

    private String ISBN;
    private String nombreLibro;

    @Column(name = "precio_publico")
    private Double precioPublico;

    @OneToMany(mappedBy = "libro")
    private List<LibroAutoreado> autores;

    public Libro() {
    }

    public Long getLibroId() {
        return libroId;
    }

    public void setLibroId(Long libroId) {
        this.libroId = libroId;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public Double getPrecioPublico() {
        return precioPublico;
    }

    public void setPrecioPublico(Double precioPublico) {
        this.precioPublico = precioPublico;
    }

    public List<LibroAutoreado> getAutores() {
        return autores;
    }

    public void setAutores(List<LibroAutoreado> autores) {
        this.autores = autores;
    }
}
