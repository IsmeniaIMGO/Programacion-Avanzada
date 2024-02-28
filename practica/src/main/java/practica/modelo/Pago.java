package practica.modelo;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class Pago {

    private String codigo;
    private LocalDateTime fecha;
    private float totalPagado;
    private String estado;
    private String metodoPago;
}
