package Martins.ecommerce.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String nombre;
    private String apellido;
    private String email;
    private String contraseña;
    private Boolean activo;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    private Set<Orden> ordenes = new HashSet<>();

    //CONSTRUCTORES
    private Cliente(){}
    public Cliente(String nombre, String apellido, String email, String contraseña, Boolean activo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contraseña = contraseña;
        this.activo = activo;
    }

    //METODOS
    public void añadirOrden(Orden orden){
        orden.setCliente(this);
        ordenes.add(orden);
    }

    //GETTERS Y SETTERS

    public long getId() {return id;}
    public String getNombre() {return nombre;}
    public String getApellido() {return apellido;}
    public String getEmail() {return email;}
    public String getContraseña() {return contraseña;}
    public Boolean getActivo() {return activo;}
    public Set<Orden> getOrdenes() {return ordenes;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setApellido(String apellido) {this.apellido = apellido;}
    public void setEmail(String email) {this.email = email;}
    public void setContraseña(String contraseña) {this.contraseña = contraseña;}
    public void setActivo(Boolean activo) {this.activo = activo;}
}
