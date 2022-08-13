/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
/**
 *
 * @author andre
 */
public class CuentaVo {
    private int IdCuenta;
    private int NumeroCuenta;
    private String Titular;
    private double Saldo;
    private String FechaApertura;
    private int IdCliente;
    
    public CuentaVo(){}

    public CuentaVo(int IdCuenta, int NumeroCuenta, String Titular, double Saldo, String FechaApertura, int IdCliente) {
        this.IdCuenta = IdCuenta;
        this.NumeroCuenta = NumeroCuenta;
        this.Titular = Titular;
        this.Saldo = Saldo;
        this.FechaApertura = FechaApertura;
        this.IdCliente = IdCliente;
    }

    public int getIdCuenta() {
        return IdCuenta;
    }

    public void setIdCuenta(int IdCuenta) {
        this.IdCuenta = IdCuenta;
    }

    public int getNumeroCuenta() {
        return NumeroCuenta;
    }

    public void setNumeroCuenta(int NumeroCuenta) {
        this.NumeroCuenta = NumeroCuenta;
    }

    public String getTitular() {
        return Titular;
    }

    public void setTitular(String Titular) {
        this.Titular = Titular;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double Saldo) {
        this.Saldo = Saldo;
    }

    public String getFechaApertura() {
        return FechaApertura;
    }

    public void setFechaApertura(String FechaApertura) {
        this.FechaApertura = FechaApertura;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }
}