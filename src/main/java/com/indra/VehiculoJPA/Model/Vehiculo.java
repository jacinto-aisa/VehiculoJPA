package com.indra.VehiculoJPA.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Vehiculo {
    @Id
    private String Id;
    private double potencia;
    private double velocidad;
    private String descripcion;

    public Vehiculo(String id, double potencia, double velocidad, String descripcion) {
        Id = id;
        this.potencia = potencia;
        this.velocidad = velocidad;
        this.descripcion = descripcion;
    }

    public Vehiculo() {
    }


    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public String getDescripción() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "Id='" + Id + '\'' +
                ", potencia=" + potencia +
                ", velocidad=" + velocidad +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
