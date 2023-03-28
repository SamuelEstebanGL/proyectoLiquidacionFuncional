package com.example.liquidacionDeEmpleado.controllers;


import com.example.liquidacionDeEmpleado.dto.EmpleadoLiquidacionDTO;
import com.example.liquidacionDeEmpleado.models.Liquidacion;
import com.example.liquidacionDeEmpleado.services.interfaces.ILiquidacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LiquidacionController {

    @Autowired
    private ILiquidacionService liquidacionService;

    @GetMapping("/calcular-Rubros/{id}")
    public int rubros(@PathVariable(name="id")Integer id){
        return liquidacionService.calcularRubros(id);
    }

    @GetMapping("/buscarEmpleadoYSuLiquidacion")
    public List<EmpleadoLiquidacionDTO> buscarEmpleadoYSuLiquidacion(){
        List<EmpleadoLiquidacionDTO> empleadoList = liquidacionService.buscarEmpleadoYSuLiquidacion();
        return empleadoList;
    }

    @GetMapping("/LiquidacionTercerEmpleado")
    public List<Liquidacion> findByLiquidacionTercerEmpleado(){
        List<Liquidacion> liquidacionList = liquidacionService.buscarTercerEmpleado();
        return liquidacionList;
    }



}
