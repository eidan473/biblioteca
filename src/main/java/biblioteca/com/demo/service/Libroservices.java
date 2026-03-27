package biblioteca.com.demo.service;

import biblioteca.com.demo.model.Libro1;
import biblioteca.com.demo.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class Libroservices {

    @Autowired
    private LibroRepository libroRepository;

    public List<Libro1> getLibros() {
        return libroRepository.obtenerLibros();
    }

    public Libro1 saveLibro(Libro1 libro) {
        return libroRepository.guardar(libro);
    }

    public Libro1 getLibroId(int id) {
        return libroRepository.buscarPorId(id);
    }

    public Libro1 updateLibro(Libro1 libro) {
        return libroRepository.actualizar(libro);
    }

    public String deleteLibro(int id) {
        libroRepository.eliminar(id);
        return "producto eliminado";
    }
}