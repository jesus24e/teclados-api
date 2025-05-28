package mx.unam.aragon.ico.is.tecladosapi.controllers;

import mx.unam.aragon.ico.is.tecladosapi.entities.Teclado;
import mx.unam.aragon.ico.is.tecladosapi.services.interfaces.TecladoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/teclados")
public class TecladoRestController {
    @Autowired
    private TecladoService tecladoService;

    @GetMapping("/")
    public ResponseEntity<Iterable<Teclado>> getTeclados() {

        return new ResponseEntity<>(tecladoService.listar(), HttpStatus.OK);
    }

    @GetMapping("/{clave}")
    public ResponseEntity<Teclado> gettecladoPorClave(@PathVariable Long clave) {

        Optional <Teclado> tmp = tecladoService.buscarPorId(clave);
        if (tmp.isPresent()) {
            return new ResponseEntity<>(tmp.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Teclado> createTeclado(@RequestBody Teclado teclado) {
        return new ResponseEntity<>(tecladoService.crear(teclado), HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> noExiste() {
        return new ResponseEntity<>("End Point no soportado", HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/{clave}")
    public ResponseEntity<Teclado> actualizaParcial(@PathVariable Long clave, @RequestBody Teclado teclado) {
        Teclado tmp = tecladoService.buscarPorId(clave).orElse(null);
        if (tmp != null) {
            if (teclado.getMarca() != null) tmp.setMarca(teclado.getMarca());
            if (teclado.getModelo() != null) tmp.setModelo(teclado.getModelo());
            if (teclado.getIdioma() != null) tmp.setIdioma(teclado.getIdioma());
            if (teclado.getTipo() != null) tmp.setTipo(teclado.getTipo());
            if (teclado.getPrecio() != null) tmp.setPrecio(teclado.getPrecio());
            if (teclado.getImagen() != null) tmp.setImagen(teclado.getImagen());
            return new ResponseEntity<>(tecladoService.actualizar(clave, tmp), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{clave}")
    public ResponseEntity<Teclado> editar(@PathVariable Long clave, @RequestBody Teclado teclado) {
        Optional tmp = tecladoService.buscarPorId(clave);

        if (tmp.isPresent()) {
            return new ResponseEntity<>(tecladoService.actualizar(clave, teclado), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{clave}")
    public ResponseEntity<Teclado> eliminar(@PathVariable Long clave) {
        Teclado tmp =tecladoService.eliminar(clave);
        if (tmp != null){
            return new ResponseEntity<>(tmp, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
