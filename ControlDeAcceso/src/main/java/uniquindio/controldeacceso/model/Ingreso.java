package uniquindio.controldeacceso.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name="ingresos")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ingreso implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoIngreso;

    @ManyToOne
    private Lugar lugar;

    @ManyToOne
    private Usuario usuario;

    private Date fecha;


    public void setIngreso(Ingreso ingreso){
        this.lugar = ingreso.getLugar();
        this.usuario = ingreso.getUsuario();
        this.fecha = ingreso.getFecha();
    }

    public Ingreso(Lugar lugar, Usuario usuario, Date fecha) {
        this.lugar = lugar;
        this.usuario = usuario;
        this.fecha = fecha;
    }

}
