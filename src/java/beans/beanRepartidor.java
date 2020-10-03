/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author ROG STRIX
 */
public class beanRepartidor {
    private int id_Repartidor;
    private String nombre;
    private String apeliido;
    private String telefono;
    private String dni;
    //FUTURO: private beansTransporteP id_Transporte; 
    private int id_Transporte; 

    public int getId_Repartidor() {
        return id_Repartidor;
    }

    public void setId_Repartidor(int id_Repartidor) {
        this.id_Repartidor = id_Repartidor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApeliido() {
        return apeliido;
    }

    public void setApeliido(String apeliido) {
        this.apeliido = apeliido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getId_Transporte() {
        return id_Transporte;
    }

    public void setId_Transporte(int id_Transporte) {
        this.id_Transporte = id_Transporte;
    }
    
    
}
