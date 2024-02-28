package practica.test;

import practica.modelo.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import practica.repositorios.ClienteRepo;

import java.util.List;

@SpringBootTest
public class ClienteTest {

    @Autowired
    private ClienteRepo clienteRepo;


   /*@Test
    public void registrarClienteTest() {
        Cliente cliente = Cliente.builder()
                .cedula("1234567890")
                .nombre("Juan")
                .email("juan@gmail.com")
                .telefonos(List.of("0987654321", "0987654322")).build();

        Cliente registro = clienteRepo.save(cliente);

        Assertions.assertNotNull(registro);

        Cliente cliente2 = Cliente.builder()
                .cedula("0987654321")
                .nombre("Maria")
                .email("maria@gmail.com")
                .telefonos(List.of("0987654323", "0987654324")).build();

        Cliente registro2 = clienteRepo.save(cliente2);

        Assertions.assertNotNull(registro2);
    }*/

  /* @Test
    public void actualizarClienteTest() {

        Cliente cliente = clienteRepo.findById("65dec57ba394db668320f197").orElseThrow();

        cliente.setEmail("nuevoemail@gmail.com");

        clienteRepo.save(cliente);
       // Cliente clienteActualizado = clienteRepo.findById("  65debe41902a953b9789449c").orElseThrow();
        //Assertions.assertEquals("nuevoemail@gmail.com", clienteActualizado.getEmail());
    }*/

    @Test
    public void listarClientes(){

        List<Cliente> clientes = clienteRepo.findAll();
        clientes.forEach(System.out::println);

        Assertions.assertEquals(2, clientes.size());
    }

    @Test
    public void eliminarClienteTest() {
        clienteRepo.deleteById("65dec57ba394db668320f197");
        Cliente cliente = clienteRepo.findById("65dec57ba394db668320f197").orElse(null);
        Assertions.assertNull(cliente);
    }
}

