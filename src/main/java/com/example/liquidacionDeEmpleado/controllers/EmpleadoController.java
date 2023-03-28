package com.example.liquidacionDeEmpleado.controllers;

import com.example.liquidacionDeEmpleado.dto.EmpleadoDTO;
import com.example.liquidacionDeEmpleado.models.Empleado;
import com.example.liquidacionDeEmpleado.services.interfaces.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmpleadoController {
    @Autowired
    private IEmpleadoService service;


    @GetMapping("/buscarEmpleados")
    public List<EmpleadoDTO> buscarTodos(){
        List<EmpleadoDTO> empleadoList = service.buscarTodos();
        return empleadoList;
    }

    @PostMapping("/guardarEmpleado")
    public EmpleadoDTO guardar(@RequestBody EmpleadoDTO empleadodto){
        service.guardar(empleadodto);
        return empleadodto;
    }

    @DeleteMapping("/eliminar-Empleado/{id}")
    public String eliminar(@PathVariable("id")Integer idEmpleado){
        service.eliminar (idEmpleado);
        return "SE ELIMINO CORRECTAMENTE";
    }

    @PutMapping("/actualizarEmpleados")
    public Empleado actualizar(@RequestBody Empleado empleado) {
        service.actualizar(empleado);
        return empleado;
    }


}
