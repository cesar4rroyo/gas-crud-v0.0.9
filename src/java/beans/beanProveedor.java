/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


public class beanProveedor {

    public String getDireccion_provedor() {
        return direccion_proveedor;
    }

    public void setDireccion_provedor(String direccion_provedor) {
        this.direccion_proveedor = direccion_provedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId_Provedor() {
        return id_Proveedor;
    }

    public void setId_Provedor(int id_Provedor) {
        this.id_Proveedor = id_Provedor;
    }
    private String direccion_proveedor;
    private String nombre;
    private String ruc;
    private String telefono;
    private int id_Proveedor;

}
