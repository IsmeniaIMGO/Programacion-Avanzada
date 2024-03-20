package practica.dto;

public record ActualizarClienteDTO(
        String codigo,
        String cedula,
        String nombre,
        String email
) {
}
