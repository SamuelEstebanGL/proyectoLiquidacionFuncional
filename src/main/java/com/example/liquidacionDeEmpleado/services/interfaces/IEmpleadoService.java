package com.example.liquidacionDeEmpleado.services.interfaces;

import com.example.liquidacionDeEmpleado.dto.EmpleadoDTO;
import com.example.liquidacionDeEmpleado.models.Empleado;

import java.util.List;

public interface IEmpleadoService {
    List<EmpleadoDTO> buscarTodos();

    void guardar(EmpleadoDTO empleadoDTO);

    void eliminar(Integer idEmpleado);
    void actualizar(Empleado empleado);
}
