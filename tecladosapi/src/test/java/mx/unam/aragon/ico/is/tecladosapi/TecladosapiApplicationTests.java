package mx.unam.aragon.ico.is.tecladosapi;

import mx.unam.aragon.ico.is.tecladosapi.entities.Teclado;
import mx.unam.aragon.ico.is.tecladosapi.repositories.TecladoRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@Disabled
@SpringBootTest
class TecladosapiApplicationTests {
    @Autowired
    private TecladoRepository tecladoRepository;

    @Test
    void contextLoads() {
    }


    @Test
    void insertarTeclado() {
        Teclado teclado1 = new Teclado(null,"Terport", "tr95", "ES", "mecanico", 635f,null);
        Teclado teclado2 = new Teclado(null,"Logitech", "K120", "ES", "membrana", 234.70f,null);
        Teclado teclado3 = new Teclado(null,"Razer", "Huntsman Mini", "EN", "Optico", 3099f,null);
        Teclado teclado4 = new Teclado(null,"generico", "patito", "EN", "membrana", 99f,null);
        tecladoRepository.save(teclado1); //insert into
        tecladoRepository.save(teclado2);
        tecladoRepository.save(teclado3);
        tecladoRepository.save(teclado4);
    }

    @Test
    void leerTecladoporclave() {
        Long claveTmp = 2L; //teclado logitech
        Teclado tmp = tecladoRepository.findTecladoByClave(claveTmp);
        System.out.println(tmp);
    }

    @Test
    public  void eliminarTeclado() {
        Long claveTmp=4l; //teclado generico
        tecladoRepository.deleteById(claveTmp);
    }

    @Test
    public  void actualizarTeclado() {
        Long claveTmp=3l; //teclado razer
        Teclado tmp = tecladoRepository.findTecladoByClave(claveTmp);
        tmp.setTipo("Opto-Mecánico");
        tecladoRepository.save(tmp);
    }

}
