package com.indra.VehiculoJPA.DAL;

import com.indra.VehiculoJPA.Model.Vehiculo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface VehiculoRepository extends CrudRepository<Vehiculo, String> {

    List<Vehiculo> findByDescripcion(String descripcion);
}
