package biblioteca.com.demo.repository;

import biblioteca.com.demo.model.Libro1;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LibroRepository {

    private List<Libro1> listaLibros = new ArrayList<>();

    public List<Libro1> obtenerLibros() {
        return listaLibros;
    }

    public Libro1 buscarPorId(int id) {
        for (Libro1 libro : listaLibros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    public Libro1 buscarPorIsbn(String isbn) {
        for (Libro1 libro : listaLibros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    public Libro1 guardar(Libro1 lib) {
        listaLibros.add(lib);
        return lib;
    }

    public Libro1 actualizar(Libro1 lib) {
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).getId() == lib.getId()) {
                id = lib.getId();
                idPosicion = i;
            }
        }

        Libro1 libro1 = new Libro1();
        libro1.setId(id);
        libro1.setTitulo(lib.getTitulo());
        libro1.setAutor(lib.getAutor());
        libro1.setFechaPublicacion(lib.getFechaPublicacion());
        libro1.setEditorial(lib.getEditorial());
        libro1.setIsbn(lib.getIsbn());

        listaLibros.set(idPosicion, libro1);
        return libro1;
    }

    public void eliminar(int id) {
        Libro1 libro = buscarPorId(id);
        if (libro != null) {
            listaLibros.remove(libro);
        }
    }
}
