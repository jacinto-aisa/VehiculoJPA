package com.indra.VehiculoJPA;

import com.indra.VehiculoJPA.DAL.VehiculoRepository;
import com.indra.VehiculoJPA.Model.Vehiculo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class VehiculoJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehiculoJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(VehiculoRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Vehiculo("AX", 98.89, 78.89, "Furgoneta Chunga"));
			repository.save(new Vehiculo("JH", 90.89, 09.89, "Coche normal"));
			repository.save(new Vehiculo("OP", 100, 190, "Super Coche"));

			//Creamos uno nuevo y lo añadimos
			repository.save(new Vehiculo("AO", 89.89, 68.89, "Coche normal"));

			//mostrar todos los vehiculos
			System.out.println("Los cuatro originales");
			repository.findAll().forEach(System.out::println);

			// fetch an individual customer by ID
			Optional<Vehiculo> ao = repository.findById("AO");
			Vehiculo miVehiculo = ao.get();

			//Update
			Optional<Vehiculo> vehiculoBuscado2 = repository.findById("JH");
			Vehiculo miVehiculo2 = vehiculoBuscado2.get();
			miVehiculo2.setVelocidad(100);

			repository.deleteById("JH");
			repository.save(miVehiculo2);

			//Delete
			repository.deleteById("AO");

			System.out.println("Modificados");
			repository.findAll().forEach(System.out::println);

			double potenciaTotal = 0;
			for(Vehiculo Item : repository.findAll())
			{
				potenciaTotal+=Item.getPotencia();
			}

			System.out.println("Total: "+potenciaTotal);
			System.out.println("-------------");
			System.out.println("Ccches normales");
			repository.findByDescripcion("Coche normal").forEach(System.out::println);

		};
	}
};


