package modelo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;
import java.util.List;


@Document // Indica que es una entidad de MongoDB
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente implements Serializable {

    @Id // Indica que es el identificador de la entidad
    @EqualsAndHashCode.Include
    private String codigo;

    private String cedula;
    private String nombre;
    private String email;
    private List<String> telefonos;


}
