package uniquindio.ControlDeAcceso.Model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
//@Table(name="rol")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Rol implements Serializable {
    @Id
    @Column(name="codigo_rol")
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoRol;

    @Column(name="nombre_rol", length=40)
    @Length(max = 40, min = 5, message = "Longitud invalida para el nombre del rol")
    private String nombreRol;

    @OneToMany(mappedBy = "rol")
    @ToString.Exclude
    @JsonIgnore
    private List<Usuario> usuarios;

    public void setRol(Rol rol){
        this.codigoRol = rol.getCodigoRol();
        this.nombreRol = rol.getNombreRol();
    }
}
