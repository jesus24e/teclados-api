package mx.unam.aragon.ico.is.tecladosapi.services;

import mx.unam.aragon.ico.is.tecladosapi.entities.Teclado;
import mx.unam.aragon.ico.is.tecladosapi.repositories.TecladoRepository;
import mx.unam.aragon.ico.is.tecladosapi.services.interfaces.TecladoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TecladoServiceImpl implements TecladoService {
    @Autowired
    private TecladoRepository tecladoRepository;

    @Override
    public Optional<Teclado> buscarPorId(Long id) {
        return tecladoRepository.findById(id);
    }

    @Override
    public Iterable<Teclado> listar() {
        return tecladoRepository.findAll();
    }

    @Override
    public Teclado crear(Teclado teclado) {
        return tecladoRepository.save(teclado);
    }

    @Override
    public Teclado actualizar(Long id, Teclado teclado) {
        Optional<Teclado> tecladoActual = tecladoRepository.findById(id);

        if (tecladoActual.isPresent()) {
            Teclado tmp = tecladoActual.get();
            tmp.setMarca(teclado.getMarca());
            tmp.setModelo(teclado.getModelo());
            tmp.setIdioma(teclado.getIdioma());
            tmp.setTipo(teclado.getTipo());
            tmp.setPrecio(teclado.getPrecio());
            tmp.setImagen(teclado.getImagen());
            return tecladoRepository.save(tmp);
        }else {
            return null;
        }
    }

    @Override
    public Teclado eliminar(Long id) {
        Optional<Teclado> tecladoActual = tecladoRepository.findById(id);
        if (tecladoActual.isPresent()) {
            tecladoRepository.deleteById(id);
            return tecladoActual.get();
        }else {
            return null;
        }
    }
}
