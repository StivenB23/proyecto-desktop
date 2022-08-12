/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Aprendiz
 */
public class ClienteVo {
    
    private Integer idcliente;
    private String cedulaCliente;
    private String nombre;
    private String telefono;
    private Boolean estado;

    public ClienteVo() {
    }

    public ClienteVo(Integer idcliente, String cedulaCliente, String nombre, String telefono, Boolean estado) {
        this.idcliente = idcliente;
        this.cedulaCliente = cedulaCliente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.estado = estado;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
    
}
