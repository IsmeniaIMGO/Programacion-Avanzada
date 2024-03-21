package practica.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import practica.dto.*;
import practica.servicios.*;
import java.util.List;


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
                "juanito@gmail.com"
        );
        //Se registra el cliente
        String codigo = clienteServicio.registrarCliente(registroClienteDTO);
        //Se verifica que el código no sea nulo, es decir, que se haya registrado el cliente
        Assertions.assertNotNull(codigo);
    }

    @Test
    public void actualizarTest() throws Exception{
        //Se crea un objeto de tipo ActualizarClienteDTO
        ActualizarClienteDTO actualizarClienteDTO = new ActualizarClienteDTO(
                "Cliente1",
                "Juan",
                "juan@email.com",
                "Armenia"
        );
        //Se actualiza el cliente
        clienteServicio.actualizarCliente(actualizarClienteDTO);
        //Con el método obtenerCliente se obtiene el cliente con el id "Cliente1"
        ItemClienteDTO detalleClienteDTO = clienteServicio.obtenerCliente("Cliente1");
        //Se verifica que la foto de perfil sea la misma que se actualizó
        //Assertions.assertEquals("nueva foto", detalleClienteDTO.fotoPerfil());
    }
    @Test
    public void eliminarTest() throws Exception{
        //Se elimina el cliente con el id "Cliente1"
        clienteServicio.eliminarCliente("Cliente1");
        //Al intentar obtener el cliente con el id "Cliente1" se debe lanzar una excepción
        Assertions.assertThrows(Exception.class, () -> clienteServicio.obtenerCliente("Cliente1") );
    }
    @Test
    public void listarClientes(){
        //Se obtiene la lista de clientes
        List<ItemClienteDTO> lista = clienteServicio.listarClientes();
        //Se verifica que la lista no sea nula y que tenga 3 elementos
        Assertions.assertEquals(3, lista.size());
    }

}
