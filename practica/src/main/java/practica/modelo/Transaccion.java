package practica.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Document("transacciones")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Transaccion implements Serializable{

    @Id
    @EqualsAndHashCode.Include
    private String id;

    private List<DetalleProducto> productos;
    private String cliente;
    private LocalDateTime fecha;
    private Pago pago;
}
