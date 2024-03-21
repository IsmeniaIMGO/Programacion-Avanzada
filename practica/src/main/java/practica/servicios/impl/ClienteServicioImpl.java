package practica.servicios.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practica.dto.ActualizarClienteDTO;
import practica.dto.ItemClienteDTO;
import practica.dto.RegistroClienteDTO;
import practica.excepciones.ResourceNotFoundException;
import practica.modelo.Cliente;
import practica.repositorios.ClienteRepo;
import practica.servicios.ClienteServicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClienteServicioImpl implements ClienteServicio {
    private final ClienteRepo clienteRepo;

    public ClienteServicioImpl(ClienteRepo clienteRepo) {
        this.clienteRepo = clienteRepo;
    }


    @Override
    public String registrarCliente(RegistroClienteDTO registroClienteDTO) throws Exception {
       Cliente cliente = new Cliente();

       cliente.setNombre(registroClienteDTO.nombre());
       cliente.setCedula(registroClienteDTO.cedula());
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
        Cliente cliente = buscarClientePorId(actualizaClienteDTO.codigo());

        cliente.setNombre(actualizaClienteDTO.nombre());
        cliente.setCedula(actualizaClienteDTO.cedula());
        cliente.setEmail(actualizaClienteDTO.email());

        clienteRepo.save(cliente);

    }

    @Override
    public ItemClienteDTO obtenerCliente(String idCuenta) throws Exception {

        Cliente cliente = buscarClientePorId(idCuenta);

        return new ItemClienteDTO(cliente.getCodigo(), cliente.getNombre(), cliente.getEmail(), cliente.getCedula());
    }

    @Override
    public void eliminarCliente(String idCuenta) throws Exception {

        Cliente cliente = buscarClientePorId(idCuenta);

        clienteRepo.delete(cliente);
        //en el caso de que tenga el atributo estado seria:
        //cliente.setEstado(EstadoCliente.INACTIVO);
        //clienteRepo.save(cliente);
    }

    @Override
    public List<ItemClienteDTO> listarClientes() {
        List<Cliente> clientes = clienteRepo.findAll();

        List<ItemClienteDTO> items = new ArrayList<>();

        for(Cliente cliente : clientes){
            items.add(new ItemClienteDTO(cliente.getCodigo(), cliente.getNombre(), cliente.getEmail(), cliente.getCedula()));
        }

        return  items;

    }


    public Cliente buscarClientePorId(String idCuenta) throws Exception {
        Optional<Cliente> optionalCliente = clienteRepo.findById(idCuenta);

        if (optionalCliente.isEmpty()) {
            throw new ResourceNotFoundException("No se encontró el cliente con ID: " + idCuenta);
        }

        return optionalCliente.get();
    }



}
