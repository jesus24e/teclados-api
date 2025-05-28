package mx.unam.aragon.ico.is.tecladosapi.services.interfaces;

import mx.unam.aragon.ico.is.tecladosapi.entities.Teclado;

import java.util.Optional;

public interface TecladoService {
    public abstract Optional<Teclado> buscarPorId(Long id);
    public abstract Iterable<Teclado> listar();
    public abstract Teclado crear(Teclado teclado);
    public abstract Teclado actualizar(Long id,Teclado teclado);
    public abstract Teclado eliminar(Long id);
}
