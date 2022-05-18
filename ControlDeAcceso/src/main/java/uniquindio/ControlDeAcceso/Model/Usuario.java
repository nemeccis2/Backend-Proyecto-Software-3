package uniquindio.ControlDeAcceso.Model;

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

    @OneToMany(mappedBy = "usuario")
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
        //this.ingresos = usuario.getIngresos();
    }

    public Usuario(Integer cedula, String nombres, String apellidos, Carrera carrera, Rol rol, Date fechaNacimiento, String direccion, String celular, String correo, String password) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.carrera = carrera;
        this.rol = rol;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.celular = celular;
        this.correo = correo;
        this.password = password;
    }
}

