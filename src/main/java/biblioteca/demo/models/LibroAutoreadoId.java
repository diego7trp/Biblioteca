package biblioteca.demo.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class LibroAutoreadoId implements Serializable {
    private Long autorId;
    private Long libroId;
    private LocalDateTime fecha;

    public LibroAutoreadoId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LibroAutoreadoId)) return false;
        LibroAutoreadoId that = (LibroAutoreadoId) o;
        return Objects.equals(autorId, that.autorId) &&
               Objects.equals(libroId, that.libroId) &&
               Objects.equals(fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autorId, libroId, fecha);
    }
}
