package com.example.liquidacionDeEmpleado.models;

import javax.persistence.*;

@Entity
@Table(name = "liquidacion")
public class Liquidacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLiquidacion;

    private double prima;
    private double cesantia;
    private double interesCesantia;
    private double vacaciones;
    private double totalLiquidacion;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;


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

    public double getVacaciones() {
        return vacaciones;
    }

    public void setVacaciones(double vacaciones) {
        this.vacaciones = vacaciones;
    }

    public double getTotalLiquidacion() {
        return totalLiquidacion;
    }

    public void setTotalLiquidacion(double totalLiquidacion) {
        this.totalLiquidacion = totalLiquidacion;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
