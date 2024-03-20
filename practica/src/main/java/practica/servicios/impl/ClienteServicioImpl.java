package practica.servicios.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practica.dto.ActualizarClienteDTO;
import practica.dto.ItemClienteDTO;
import practica.dto.RegistroClienteDTO;
import practica.modelo.Cliente;
import practica.repositorios.ClienteRepo;
import practica.servicios.ClienteServicio;

import java.util.List;

@Service
@Transactional
public class ClienteServicioImpl implements ClienteServicio {
    private final ClienteRepo clienteRepo;

    public ClienteServicioImpl(ClienteRepo clienteRepo){
        this.clienteRepo = clienteRepo;
    }


    @Override
    public String registrarCliente(RegistroClienteDTO registroClienteDTO) throws Exception {
       Cliente cliente = new Cliente();

       cliente.setNombre(registroClienteDTO.nombre());
       cliente.setCedula(registroClienteDTO.cedula());
       //cliente.setTelefonos();
        cliente.setEmail(registroClienteDTO.email());

        if(existeEmail(registroClienteDTO.email())){
            throw new Exception("El correo ya se encuentra registrado");
        }

        Cliente clienteGuardado = clienteRepo.save(cliente);

        return clienteGuardado.getCodigo();
    }

    private boolean existeEmail(String email) {
        return clienteRepo.findByEmail(email).isPresent();
    }

    @Override
    public void actualizarCliente(ActualizarClienteDTO actualizaClienteDTO) throws Exception {

    }

    @Override
    public Cliente obtenerCliente(String idCuenta) throws Exception {
        return null;
    }

    @Override
    public void eliminarCliente(String idCuenta) throws Exception {

    }

    @Override
    public List<ItemClienteDTO> listarClientes() {
        return null;
    }
}
