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
    private beanEstadoPed estado_Pedido;
    private beanProducto producto;
    private beanRepartidor repartidor;
    private beanCliente cliente;
    private int importe_total;
    private int id_estado_pedido;
    private int id_repartido;
    private int id_Pedido;
    private Timestamp fecha_entrega;

    public beanRepartidor getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(beanRepartidor repartidor) {
        this.repartidor = repartidor;
    }

    public int getImporte_total() {
        return importe_total;
    }

    public void setImporte_total(int importe_total) {
        this.importe_total = importe_total;
    }

    public int getId_repartido() {
        return id_repartido;
    }

    public void setId_repartido(int id_repartido) {
        this.id_repartido = id_repartido;
    }      

    public beanEstadoPed getEstado_Pedido() {
        return estado_Pedido;
    }

    public void setEstado_Pedido(beanEstadoPed estado_Pedido) {
        this.estado_Pedido = estado_Pedido;
    }

    public beanProducto getProducto() {
        return producto;
    }

    public void setProducto(beanProducto producto) {
        this.producto = producto;
    }


    public beanCliente getCliente() {
        return cliente;
    }

    public void setCliente(beanCliente cliente) {
        this.cliente = cliente;
    }

    public int getId_estado_pedido() {
        return id_estado_pedido;
    }

    public void setId_estado_pedido(int id_estado_pedido) {
        this.id_estado_pedido = id_estado_pedido;
    }

    public int getId_repartidor() {
        return id_repartido;
    }

    public void setId_repartidor(int id_repartido) {
        this.id_repartido = id_repartido;
    }
    

    public Timestamp getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Timestamp fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
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
