package uniquindio.controldeacceso.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Carrera implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoCarrera;

    @Column(name="nombre_carrera", length=40)
    @Length(max = 40, min = 5, message = "Longitud invalida para el nombre de la carrera")
    private String nombreCarrera;

    @OneToMany(mappedBy="carrera")
    @JsonIgnore
    @ToString.Exclude
    private List<Usuario> usuarios;

    public void setCarrera(Carrera carrera){
        this.codigoCarrera = carrera.getCodigoCarrera();
        this.nombreCarrera = carrera.getNombreCarrera();
    }

}
