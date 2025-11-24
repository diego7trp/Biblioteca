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
@Table(name = "Autor")

public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "autorId")
    private Long autorId;

    private String nombre;
    private String apellido;
    private String ciudad;

    @OneToMany(mappedBy = "autor")
    private List<LibroAutoreado> librosAutoreados;

    public Autor() {
    }

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<LibroAutoreado> getLibroAutoreados() {
        return librosAutoreados;
    }

    public void setLibroAutoreados(List<LibroAutoreado> librosAutoreados) {
        this.librosAutoreados = librosAutoreados;
    }
}
