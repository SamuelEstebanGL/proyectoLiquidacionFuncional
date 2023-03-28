package com.example.liquidacionDeEmpleado.services.implementacion;

import com.example.liquidacionDeEmpleado.dto.EmpleadoDTO;
import com.example.liquidacionDeEmpleado.models.Empleado;
import com.example.liquidacionDeEmpleado.repositories.IEmpleadoRepository;
import com.example.liquidacionDeEmpleado.services.interfaces.IEmpleadoService;
import com.example.liquidacionDeEmpleado.services.interfaces.ILiquidacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServeceImpl implements IEmpleadoService {

    @Autowired
    private IEmpleadoRepository iEmpleadoRepository;

    @Autowired
    private ILiquidacionService liquidacionService;

    @Override
    public List<EmpleadoDTO> buscarTodos() {
        List<Empleado> empleadoList = iEmpleadoRepository.findAll();
        List<EmpleadoDTO> empleadoDTOList = new ArrayList<>();
        if(!empleadoList.isEmpty()){
            empleadoList.forEach(empleado -> {
                EmpleadoDTO empleadoDTO = new EmpleadoDTO();
                empleadoDTO.setIdEmpleado(empleado.getIdEmpleado());
                empleadoDTO.setNombreEmpleado(empleado.getNombreEmpleado());
                empleadoDTO.setApellidoEmpleado(empleado.getApellidoEmpleado());
                empleadoDTO.setSueldoEmpleado(empleado.getSueldoEmpleado());
                empleadoDTO.setDiasLaborados(empleado.getDiasLaborados());
                empleadoDTOList.add(empleadoDTO);
            });
        }
        return empleadoDTOList;
    }

    @Override
    public void guardar(EmpleadoDTO empleadoDTO) {
        Empleado empleado = new Empleado();
        empleado.setNombreEmpleado(empleadoDTO.getNombreEmpleado());
        empleado.setApellidoEmpleado(empleadoDTO.getApellidoEmpleado());
        empleado.setSueldoEmpleado(empleadoDTO.getSueldoEmpleado());
        empleado.setDiasLaborados(empleadoDTO.getDiasLaborados());
        iEmpleadoRepository.save(empleado);
        liquidacionService.crearLiquidacion(empleado.getIdEmpleado());
    }

    @Override
    public void eliminar(Integer idEmpleado) {
        Optional<Empleado> empleadolist = iEmpleadoRepository.findByIdEmpleado(idEmpleado);
        if (empleadolist.isPresent()){
            iEmpleadoRepository.deleteById(idEmpleado);
        }else {
            throw  new ResponseStatusException( HttpStatus.NOT_FOUND, "No! hay registro de este empleado" +
                    " en la base de datos" );
        }

    }

    @Override
    public void actualizar(Empleado empleado) {
        List<Empleado> empleadoList = iEmpleadoRepository.findAll();
        if (empleadoList.isEmpty()){
            iEmpleadoRepository.save(empleado);
        }else{
            throw  new ResponseStatusException( HttpStatus.NOT_FOUND, "No! hay registro de este empleado" +
                    " en la base de datos" );
        }

    }



}
