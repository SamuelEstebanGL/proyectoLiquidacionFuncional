package com.example.liquidacionDeEmpleado.services.implementacion;


import com.example.liquidacionDeEmpleado.dto.EmpleadoLiquidacionDTO;
import com.example.liquidacionDeEmpleado.models.Empleado;
import com.example.liquidacionDeEmpleado.models.Liquidacion;
import com.example.liquidacionDeEmpleado.repositories.IEmpleadoRepository;
import com.example.liquidacionDeEmpleado.repositories.ILiquidacionRepository;
import com.example.liquidacionDeEmpleado.services.interfaces.ILiquidacionService;
import com.example.liquidacionDeEmpleado.utils.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LiquidacionServiceImpl implements ILiquidacionService {
    @Autowired
    private ILiquidacionRepository iLiquidacionRepository;

    @Autowired
    private IEmpleadoRepository iEmpleadoRepository;

    @Override
    public int calcularRubros(int idLiquidacion) {
        Optional<Empleado> empleado = iEmpleadoRepository.findByIdEmpleado(idLiquidacion);
        Optional<Liquidacion> liquidacion = iLiquidacionRepository.findById(idLiquidacion);
        double porciento = 0.12;
        int dosAños = Constantes.año + Constantes.año;
        double prima = (empleado.get().getSueldoEmpleado() +
                Constantes.auxilioTrasporte * empleado.get().getDiasLaborados()/Constantes.año);
        double cesantias = (empleado.get().getSueldoEmpleado()
                * empleado.get().getDiasLaborados()/Constantes.año);
        double interesCesantia = (cesantias * porciento/empleado.get().getDiasLaborados());
        double vacaciones = empleado.get().getSueldoEmpleado() * empleado.get().getDiasLaborados()/dosAños;
        liquidacion.get().setPrima(prima);
        liquidacion.get().setCesantia(cesantias);
        liquidacion.get().setInteresCesantia(interesCesantia);
        liquidacion.get().setVacaciones(vacaciones);
        int calcularRubro = (int) (prima + cesantias + interesCesantia + vacaciones);
        liquidacion.get().setTotalLiquidacion(calcularRubro);
        iLiquidacionRepository.save(liquidacion.get());
        return calcularRubro;
    }

    @Override
    public void crearLiquidacion(int idEmpleado) {
        Optional<Empleado> empleado = iEmpleadoRepository.findByIdEmpleado(idEmpleado);
            Liquidacion liquidacion = new Liquidacion();
            liquidacion.setEmpleado(empleado.get());
            iLiquidacionRepository.save(liquidacion);
            actualizarIdLiquidacionEmpleado(empleado.get());
    }

    @Override
    public List<EmpleadoLiquidacionDTO> buscarEmpleadoYSuLiquidacion() {
        List<Empleado> empleadoList = iEmpleadoRepository.findAll();
        List<Liquidacion> liquidacionList = iLiquidacionRepository.findAll();
        List<EmpleadoLiquidacionDTO> empleadoLiquidacionDTOList = new ArrayList<>();
        if(!liquidacionList.isEmpty()){
            liquidacionList.forEach(liquidacion -> {
                EmpleadoLiquidacionDTO empleadoDTO = new EmpleadoLiquidacionDTO();
                empleadoDTO.setIdEmpleado(liquidacion.getEmpleado().getIdEmpleado());
                empleadoDTO.setNombreEmpleado(liquidacion.getEmpleado().getNombreEmpleado());
                empleadoDTO.setIdLiquidacion(liquidacion.getIdLiquidacion());
                empleadoDTO.setPrima(liquidacion.getPrima());
                empleadoDTO.setCesantia(liquidacion.getCesantia());
                empleadoDTO.setInteresCesantia(liquidacion.getInteresCesantia());
                empleadoDTO.setVacaciones(liquidacion.getVacaciones());
                empleadoDTO.setTotalLiquidacion(liquidacion.getTotalLiquidacion());
                empleadoLiquidacionDTOList.add(empleadoDTO);
            });
        }
        return empleadoLiquidacionDTOList;
    }

    @Override
    public List<Liquidacion> buscarTercerEmpleado() {
        List<Liquidacion> liquidacionList = iLiquidacionRepository.buscarTercerEmpleado();
        return liquidacionList;
    }

    private void actualizarIdLiquidacionEmpleado(Empleado empleado){

        iEmpleadoRepository.save(empleado);
    }


}
