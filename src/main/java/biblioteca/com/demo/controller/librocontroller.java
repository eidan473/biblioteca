package biblioteca.com.demo.controller;

import biblioteca.com.demo.model.Libro1;
import biblioteca.com.demo.service.Libroservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/libros")
public class librocontroller {

    @Autowired
    private Libroservices libroservices;

    @GetMapping
    public List<Libro1> listarLibros() {
        return libroservices.getLibros();
    }

    @PostMapping
    public Libro1 agregarLibro(@RequestBody Libro1 libro) {
        return libroservices.saveLibro(libro);
    }

    @GetMapping("/{id}")
    public Libro1 buscarLibro(@PathVariable int id) {
        return libroservices.getLibroId(id);
    }

    @PutMapping("/{id}")
    public Libro1 actualizarLibro(@PathVariable int id, @RequestBody Libro1 libro) {
        return libroservices.updateLibro(libro);
    }

    @DeleteMapping("/{id}")
    public String eliminarLibro(@PathVariable int id) {
        return libroservices.deleteLibro(id);
    }
}