package test;

import modelo.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import repositorios.ClienteRepo;

import java.util.List;

@SpringBootTest
public class ClienteTest {

    @Autowired
    private ClienteRepo clienteRepo;


    @Test
    public void registrarClienteTest() {
        Cliente cliente = Cliente.builder()
                .cedula("1234567890")
                .nombre("Juan")
                .email("juan@gmail.com")
                .telefonos(List.of("0987654321", "0987654322")).build();

        Cliente registro = clienteRepo.save(cliente);

        Assertions.assertNotNull(registro);

    }

}

