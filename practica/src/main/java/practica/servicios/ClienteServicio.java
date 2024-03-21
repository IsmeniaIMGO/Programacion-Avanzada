package practica.servicios;

import org.springframework.stereotype.Service;
import practica.dto.ActualizarClienteDTO;
import practica.dto.ItemClienteDTO;
import practica.dto.RegistroClienteDTO;

import java.util.List;


public interface ClienteServicio {

    String registrarCliente(RegistroClienteDTO registroClienteDTO)throws Exception;
    void actualizarCliente(ActualizarClienteDTO actualizaClienteDTO)throws Exception;
    ItemClienteDTO obtenerCliente(String idCuenta) throws Exception;
    void eliminarCliente(String idCuenta)throws Exception;
    List<ItemClienteDTO> listarClientes();
}
