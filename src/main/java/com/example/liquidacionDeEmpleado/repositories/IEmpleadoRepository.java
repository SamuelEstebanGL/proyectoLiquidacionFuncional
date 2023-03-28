package com.example.liquidacionDeEmpleado.repositories;

import com.example.liquidacionDeEmpleado.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface IEmpleadoRepository extends JpaRepository<Empleado, Integer> {
    @Transactional(readOnly = true)
     Optional<Empleado> findByIdEmpleado(int idEmpleado);

}
