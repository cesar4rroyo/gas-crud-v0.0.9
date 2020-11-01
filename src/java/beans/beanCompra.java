
package beans;

import java.sql.Timestamp;


public class beanCompra {
    private int id_Compra;
    private int cantidad;
    private beanProveedor provedor;
    private beanProducto producto;
    private Timestamp fecha;
    private int total;
    

    public int getId_Compra() {
        return id_Compra;
    }

    public void setId_Compra(int id_Compra) {
        this.id_Compra = id_Compra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public beanProveedor getProvedor() {
        return provedor;
    }

    public void setProvedor(beanProveedor provedor) {
        this.provedor = provedor;
    }

    public beanProducto getProducto() {
        return producto;
    }

    public void setProducto(beanProducto producto) {
        this.producto = producto;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
    
}
