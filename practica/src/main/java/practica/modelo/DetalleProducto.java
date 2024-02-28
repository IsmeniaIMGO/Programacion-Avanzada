package practica.modelo;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
public class DetalleProducto {

    private String codigoProducto;
    private float precio;
    private int cantidad;
}
