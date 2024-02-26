package modelo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import java.util.List;


@Document("clientes") // Indica que es una entidad de MongoDB
@Getter // Genera los métodos getters
@Setter // Genera los métodos setters
@NoArgsConstructor // Genera un constructor sin argumentos
@ToString // Genera el método toString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)  // Genera los métodos equals y hashCode
public class Cliente implements Serializable {

    @Id // Indica que es el identificador de la entidad
    @EqualsAndHashCode.Include // Incluye el atributo en el método equals y hashCode
    private String codigo;

    private String cedula;
    private String nombre;
    private String email;
    private List<String> telefonos;


}
