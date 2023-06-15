package Martins.ecommerce.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private LocalDateTime fecha;
    private double precioTotal;
    private Boolean comprado;
    private Boolean activo;

    @OneToMany(mappedBy = "orden", fetch = FetchType.EAGER)
    private Set<ProductosSeleccionados> productosSeleccionadosSet = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private Cliente cliente;

    //CONSTRUCTORES

    public Orden() {}
    public Orden(LocalDateTime fecha, double precioTotal, Boolean comprado, Boolean activo) {
        this.fecha = fecha;
        this.precioTotal = precioTotal;
        this.comprado = comprado;
        this.activo = activo;
    }

    //METODOS
    public void añadirProducto(ProductosSeleccionados productosSeleccionados){
        productosSeleccionados.setOrden(this);
        productosSeleccionadosSet.add(productosSeleccionados);
    }
    //GETTER Y SETTER
    public long getId() {return id;}
    public LocalDateTime getFecha() {return fecha;}
    public double getPrecioTotal() {return precioTotal;}
    public Boolean getComprado() {return comprado;}
    public Boolean getActivo() {return activo;}
    public Set<ProductosSeleccionados> getProductosSeleccionadosSet() {return productosSeleccionadosSet;}
    public void setFecha(LocalDateTime fecha) {this.fecha = fecha;}
    public void setPrecioTotal(double precioTotal) {this.precioTotal = precioTotal;}
    public void setComprado(Boolean comprado) {this.comprado = comprado;}
    public void setActivo(Boolean activo) {this.activo = activo;}
    public void setProductosSeleccionadosSet(Set<ProductosSeleccionados> productosSeleccionadosSet) {this.productosSeleccionadosSet = productosSeleccionadosSet;}
    public void setCliente(Cliente cliente) {this.cliente = cliente;}
}
