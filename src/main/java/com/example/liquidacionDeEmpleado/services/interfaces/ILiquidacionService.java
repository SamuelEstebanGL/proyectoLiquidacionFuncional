package com.example.liquidacionDeEmpleado.services.interfaces;

import com.example.liquidacionDeEmpleado.dto.EmpleadoLiquidacionDTO;
import com.example.liquidacionDeEmpleado.models.Liquidacion;

import java.util.List;

public interface ILiquidacionService {
    public int calcularRubros(int idLiquidacion);
    public void crearLiquidacion(int idEmpleado);
    List<EmpleadoLiquidacionDTO> buscarEmpleadoYSuLiquidacion();

    List<Liquidacion> buscarTercerEmpleado();
}
