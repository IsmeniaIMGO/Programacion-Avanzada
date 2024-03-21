package practica.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import practica.dto.RegistroClienteDTO;
import practica.servicios.ClienteServicio;


@SpringBootTest
public class ClienteServicioTest {

    @Autowired
    private ClienteServicio clienteServicio;


    @Test
    public void registrarTest() throws Exception {
        //Se crea un objeto de tipo RegistroClienteDTO
        RegistroClienteDTO registroClienteDTO = new RegistroClienteDTO(
                "12345",
                "Juan",
                "juanito"
        );
        //Se registra el cliente
        String codigo = clienteServicio.registrarCliente(registroClienteDTO);
        //Se verifica que el código no sea nulo, es decir, que se haya registrado el cliente
        Assertions.assertNotNull(codigo);
    }
}
