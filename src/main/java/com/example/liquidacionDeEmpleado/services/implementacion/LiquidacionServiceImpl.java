package com.example.liquidacionDeEmpleado.services.implementacion;


import com.example.liquidacionDeEmpleado.dto.EmpleadoLiquidacionDTO;
import com.example.liquidacionDeEmpleado.models.Empleado;
import com.example.liquidacionDeEmpleado.models.Liquidacion;
import com.example.liquidacionDeEmpleado.repositories.IEmpleadoRepository;
import com.example.liquidacionDeEmpleado.repositories.ILiquidacionRepository;
import com.example.liquidacionDeEmpleado.services.interfaces.ILiquidacionService;
import com.example.liquidacionDeEmpleado.utils.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



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
        Optional<Liquidacion> liquidacion = iLiquidacionRepository.findById(idLiquidacion);
        double porciento = 0.12;
        int dosAños = Constantes.año + Constantes.año;
        double prima = (liquidacion.get().getEmpleado().getSueldoEmpleado() +
                Constantes.auxilioTrasporte * liquidacion.get().getEmpleado().getDiasLaborados()/Constantes.año);
        double cesantias = (liquidacion.get().getEmpleado().getSueldoEmpleado()
                * liquidacion.get().getEmpleado().getDiasLaborados()/Constantes.año);
        double interesCesantia = (cesantias * porciento/liquidacion.get().getEmpleado().getDiasLaborados());
        double vacaciones = liquidacion.get().getEmpleado().getSueldoEmpleado() * liquidacion.get().getEmpleado().getDiasLaborados()/dosAños;
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
    }

    @Override
    public List<EmpleadoLiquidacionDTO> buscarEmpleadoYSuLiquidacion() {
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

}
