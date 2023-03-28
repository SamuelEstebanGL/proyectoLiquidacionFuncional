package com.example.liquidacionDeEmpleado.dto;

import java.io.Serializable;

public class EmpleadoLiquidacionDTO implements Serializable {
    private int idEmpleado;
    private String nombreEmpleado;
    private int idLiquidacion;
    private double prima;
    private double cesantia;
    private double interesCesantia;

    private double vacaciones;
    private double totalLiquidacion;

    public double getVacaciones() {
        return vacaciones;
    }

    public void setVacaciones(double vacaciones) {
        this.vacaciones = vacaciones;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public int getIdLiquidacion() {
        return idLiquidacion;
    }

    public void setIdLiquidacion(int idLiquidacion) {
        this.idLiquidacion = idLiquidacion;
    }

    public double getPrima() {
        return prima;
    }

    public void setPrima(double prima) {
        this.prima = prima;
    }

    public double getCesantia() {
        return cesantia;
    }

    public void setCesantia(double cesantia) {
        this.cesantia = cesantia;
    }

    public double getInteresCesantia() {
        return interesCesantia;
    }

    public void setInteresCesantia(double interesCesantia) {
        this.interesCesantia = interesCesantia;
    }

    public double getTotalLiquidacion() {
        return totalLiquidacion;
    }

    public void setTotalLiquidacion(double totalLiquidacion) {
        this.totalLiquidacion = totalLiquidacion;
    }
}
