package practica.servicios;

import practica.dto.ActualizarClienteDTO;
import practica.dto.ItemClienteDTO;
import practica.dto.RegistroClienteDTO;
import practica.modelo.Cliente;

import java.util.List;

public interface ClienteServicio {

    String registrarCliente(RegistroClienteDTO registroClienteDTO)throws Exception;
    void actualizarCliente(ActualizarClienteDTO actualizaClienteDTO)throws Exception;
    Cliente obtenerCliente(String idCuenta) throws Exception;
    void eliminarCliente(String idCuenta)throws Exception;
    List<ItemClienteDTO> listarClientes();
}
