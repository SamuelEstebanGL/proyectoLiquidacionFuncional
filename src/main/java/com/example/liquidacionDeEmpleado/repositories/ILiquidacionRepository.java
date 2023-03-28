package com.example.liquidacionDeEmpleado.repositories;

import com.example.liquidacionDeEmpleado.models.Liquidacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ILiquidacionRepository extends JpaRepository<Liquidacion,Integer> {

    @Query(value="select * from empleados e JOIN liquidacion l ON e.id_empleado = l.id_empleado ORDER BY l.total_liquidacion" +
            " DESC LIMIT 2,1", nativeQuery=true)
     List<Liquidacion> buscarTercerEmpleado();
}
