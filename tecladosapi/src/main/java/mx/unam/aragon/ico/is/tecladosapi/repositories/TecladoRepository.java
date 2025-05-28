package mx.unam.aragon.ico.is.tecladosapi.repositories;

import mx.unam.aragon.ico.is.tecladosapi.entities.Teclado;
import org.springframework.data.repository.CrudRepository;

public interface TecladoRepository extends CrudRepository<Teclado, Long> {
    public Teclado findTecladoByClave(Long clave);
}
