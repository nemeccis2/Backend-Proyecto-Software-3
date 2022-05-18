package uniquindio.ControlDeAcceso.Model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="lugar")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Lugar implements Serializable {

    @Id
    @Column(name="codigo")
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoLugar;

    @Column(name = "nombre", nullable = false, length = 50)
    @Length(max = 50, min = 1, message = "El nombre debe tener un tamaño de minimo 1 y maximo 50 caracteres")
    private String nombre;

    @Column(name = "direccion", length = 100)
    @Length(max = 100, min = 10, message = "El tamaño de la direccion no es valido")
    private String direccion;

    @Column(name = "tipo", length = 20)
    @Length(max = 20, min = 1, message = "Rol invalido")
    private String tipo;

    @OneToMany(mappedBy = "lugar")
    @JsonIgnore
    @ToString.Exclude
    private List<Ingreso> ingresos;

    public void setLugar(Lugar lugar){
        this.codigoLugar = lugar.getCodigoLugar();
        this.nombre = lugar.getNombre();
        this.direccion = lugar.getDireccion();
        this.tipo = lugar.getTipo();
    }
}
