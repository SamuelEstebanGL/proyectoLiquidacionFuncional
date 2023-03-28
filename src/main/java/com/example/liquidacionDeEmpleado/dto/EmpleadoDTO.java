package com.example.liquidacionDeEmpleado.dto;

public class EmpleadoDTO {
    private int idEmpleado;
    private String nombreEmpleado;
    private String apellidoEmpleado;
    private int sueldoEmpleado;
    private int diasLaborados;

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

    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public int getSueldoEmpleado() {
        return sueldoEmpleado;
    }

    public void setSueldoEmpleado(int sueldoEmpleado) {
        this.sueldoEmpleado = sueldoEmpleado;
    }

    public int getDiasLaborados() {
        return diasLaborados;
    }

    public void setDiasLaborados(int diasLaborados) {
        this.diasLaborados = diasLaborados;
    }
}
