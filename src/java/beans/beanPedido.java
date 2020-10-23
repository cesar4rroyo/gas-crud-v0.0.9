/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.Timestamp;
/**
 *
 * @author ROG STRIX
 */
public class beanPedido {
    
    private Timestamp fecha_inicio;
    private int precio;
    private beanEstadoPed id_Estado_pedido;
    private beanProducto id_Producto;
    private beanRepartidor id_Repartidor;
    private beanCliente id_Cliente;
    private int id_Pedido;
    private Timestamp fecha_entrega;

    public Timestamp getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Timestamp fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public beanEstadoPed getId_Estado_pedido() {
        return id_Estado_pedido;
    }

    public void setId_Estado_pedido(beanEstadoPed id_Estado_pedido) {
        this.id_Estado_pedido = id_Estado_pedido;
    }

    public beanProducto getId_Producto() {
        return id_Producto;
    }

    public void setId_Producto(beanProducto id_Producto) {
        this.id_Producto = id_Producto;
    }

    public beanRepartidor getId_Repartidor() {
        return id_Repartidor;
    }

    public void setId_Repartidor(beanRepartidor id_Repartidor) {
        this.id_Repartidor = id_Repartidor;
    }

    public beanCliente getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(beanCliente id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public int getId_Pedido() {
        return id_Pedido;
    }

    public void setId_Pedido(int id_Pedido) {
        this.id_Pedido = id_Pedido;
    }

    public Timestamp getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Timestamp fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }
   
    
}
