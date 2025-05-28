package mx.unam.aragon.ico.is.tecladosapi.registrosDePrueba;

import mx.unam.aragon.ico.is.tecladosapi.entities.Teclado;
import mx.unam.aragon.ico.is.tecladosapi.repositories.TecladoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class datosPrecargados implements CommandLineRunner {

    private final TecladoRepository tecladoRepository;

    public datosPrecargados(TecladoRepository tecladoRepository) {
        this.tecladoRepository = tecladoRepository;
    }

    @Override
    public void run(String... args) {
        if(tecladoRepository.count() == 0) {
            Teclado teclado1 = new Teclado(null,"Terport", "tr95", "ES", "mecanico", 635f,null);
            Teclado teclado2 = new Teclado(null,"Logitech", "K120", "ES", "membrana", 234.70f,null);
            Teclado teclado3 = new Teclado(null,"Razer", "Huntsman Mini", "EN", "Optico", 3099f,null);
            tecladoRepository.save(teclado1); //insert into
            tecladoRepository.save(teclado2);
            tecladoRepository.save(teclado3);

        }
    }
}
