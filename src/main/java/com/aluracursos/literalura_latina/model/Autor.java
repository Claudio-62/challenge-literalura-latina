package com.aluracursos.literalura_latina.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autores", uniqueConstraints = @UniqueConstraint(columnNames = "nombre"))
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id;
    private  String nombre;
    private Integer fechaDeNacimiento;
    private Double fechaDeMuerte;
    @ManyToMany(mappedBy = "autores")
    private List<Libro> libros;

    public Autor(){}

    public Autor(DatosAutor d) {
        this.nombre = d.nombre();
        this.fechaDeNacimiento = Integer.valueOf(d.fechaDeNacimiento());
        this.fechaDeMuerte = Double.valueOf(d.fechaDeMuerte());
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento (Integer fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public Double getFechaDeMuerte() {
        return fechaDeMuerte;
    }

    public void setFechaDeMuerte (double fechaDeMuerte) {
        this.fechaDeMuerte = fechaDeMuerte;
    }

    @Override
    public String toString() {

        String nacimiento = (fechaDeNacimiento != null) ? fechaDeNacimiento.toString() : "¿?";
        String muerte = (fechaDeMuerte != null) ? fechaDeMuerte.toString() : "¿?";

        return nombre + " (" + nacimiento + " - " + muerte + ")";
    }

}
