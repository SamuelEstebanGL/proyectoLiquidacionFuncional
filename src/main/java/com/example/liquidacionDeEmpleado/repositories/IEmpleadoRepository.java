package com.example.liquidacionDeEmpleado.repositories;

import com.example.liquidacionDeEmpleado.models.Empleado;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface IEmpleadoRepository extends JpaRepository<Empleado, Integer> {
    @Transactional(readOnly = true)
    public Optional<Empleado> findByIdEmpleado(int idEmpleado);

}
