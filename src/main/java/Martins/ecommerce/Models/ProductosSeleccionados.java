package Martins.ecommerce.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class ProductosSeleccionados {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO , generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private int cantidad;
    private double precio;
    private double precioTotal;
    private boolean activo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="orden")
    private Orden orden;

    @ManyToOne(fetch = FetchType.EAGER)
    private Producto producto;

    //CONSTRUCTORES

    public ProductosSeleccionados() {}
    public ProductosSeleccionados(int cantidad, double precio, double precioTotal, boolean activo) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.precioTotal = precioTotal;
        this.activo = activo;
    }

    //GETTER Y SETTER
    public long getId() {return id;}
    public int getCantidad() {return cantidad;}
    public double getPrecio() {return precio;}
    public double getPrecioTotal() {return precioTotal;}
    public boolean isActivo() {return activo;}
    public Orden getOrden() {return orden;}
    public Producto getProducto() {return producto;}

    public void setCantidad(int cantidad) {this.cantidad = cantidad;}
    public void setPrecio(double precio) {this.precio = precio;}
    public void setPrecioTotal(double precioTotal) {this.precioTotal = precioTotal;}
    public void setActivo(boolean activo) {this.activo = activo;}
    public void setOrden(Orden orden) {this.orden = orden;}
    public void setProducto(Producto producto) {this.producto = producto;}
}
