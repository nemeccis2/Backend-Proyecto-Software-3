package uniquindio.controldeacceso.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Entity
@Table(name="usuario")
@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario implements Serializable {

    @Id
    @Column(name="cedula")
    @EqualsAndHashCode.Include
    private Integer cedula;

    @Column(name="nombres", length=50, nullable=false)
    private String nombres;

    @Column(name="apellidos", length=50, nullable=false)
    private String apellidos;

    @ManyToOne
    @JsonBackReference
    private Carrera carrera;

    @ManyToOne
    private Rol rol;

    @Column(name="fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name="direccion")
    private String direccion;

    @Column(name="celular", length=14, nullable=false)
    private String celular;

    @Column(name="correo", nullable=false)
    private String correo;

    @Column(name="password", nullable=false)
    @ToString.Exclude
    private String password;

    @OneToMany(mappedBy = "usuario" ,cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @JsonIgnore
    private List<Ingreso> ingresos;


    public void setUsuario(Usuario usuario){
        this.cedula = usuario.getCedula();
        this.nombres = usuario.getNombres();
        this.apellidos = usuario.getApellidos();
        this.carrera = usuario.getCarrera();
        this.rol = usuario.getRol();
        this.fechaNacimiento = usuario.getFechaNacimiento();
        this.direccion = usuario.getDireccion();
        this.celular = usuario.getCelular();
        this.correo = usuario.getCorreo();
        this.password = usuario.getPassword();
    }

}

