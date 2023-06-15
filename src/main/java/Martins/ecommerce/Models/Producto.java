package Martins.ecommerce.Models;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private TipoProducto tipoProducto;
    private int talle;
    private int cantidad;
    private TipoCategoria tipoCategoria;
    private Boolean activo;
    private double precio;

    @OneToMany(mappedBy = "productos", fetch = FetchType.EAGER)
    private Set<ProductosSeleccionados> productosSeleccionadosSet = new HashSet<>();

    //CONSTRUCTORES
    public Producto() {}
    public Producto(TipoProducto tipoProducto, int talle, int cantidad, TipoCategoria tipoCategoria, Boolean activo) {
        this.tipoProducto = tipoProducto;
        this.talle = talle;
        this.cantidad = cantidad;
        this.tipoCategoria = tipoCategoria;
        this.activo = activo;
    }

    //METODOS
    public void añadirProducto(ProductosSeleccionados productosSeleccionados){
        productosSeleccionados.setProducto(this);
        productosSeleccionadosSet.add(productosSeleccionados);
    }
    //GETTER Y SETTER
    public long getId() {return id;}
    public TipoProducto getTipoProducto() {return tipoProducto;}
    public int getTalle() {return talle;}
    public int getCantidad() {return cantidad;}
    public TipoCategoria getTipoCategoria() {return tipoCategoria;}
    public Boolean getActivo() {return activo;}
    public double getPrecio() {return precio;}
    public Set<ProductosSeleccionados> getProductosSeleccionadosSet() {return productosSeleccionadosSet;}
    public void setTipoProducto(TipoProducto tipoProducto) {this.tipoProducto = tipoProducto;}
    public void setTalle(int talle) {this.talle = talle;}
    public void setCantidad(int cantidad) {this.cantidad = cantidad;}
    public void setTipoCategoria(TipoCategoria tipoCategoria) {this.tipoCategoria = tipoCategoria;}
    public void setActivo(Boolean activo) {this.activo = activo;}
    public void setPrecio(double precio) {this.precio = precio;}
    public void setProductosSeleccionadosSet(Set<ProductosSeleccionados> productosSeleccionadosSet) {this.productosSeleccionadosSet = productosSeleccionadosSet;}
}
