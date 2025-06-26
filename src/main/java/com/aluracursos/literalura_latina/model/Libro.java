package com.aluracursos.literalura_latina.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private String titulo;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "libro_idiomas", joinColumns = @JoinColumn(name = "libro_id"))
    @Column(name = "idioma")
    private List<String> idiomas;
    private Integer numeroDeDescarga;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(
            name = "libro_autor",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private List<Autor> autores;


    public Libro() {}

    public Libro(DatosLibros datosLibros){
        this.titulo = datosLibros.titulo();
        this.idiomas =  datosLibros.idiomas();
        this.numeroDeDescarga= datosLibros.numeroDeDescargas();

    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getNumeroDeDescarga() {
        return numeroDeDescarga;
    }

    public void setNumeroDeDescarga(Integer numeroDeDescarga) {
        this.numeroDeDescarga = numeroDeDescarga;
    }

    @Override
    public String toString() {

        StringBuilder la = new StringBuilder();
        la.append("◊".repeat(35)).append("\n");
        la.append(String.format("%" + (35 + " LIBRO ".length()) / 2 + "s\n", " LIBRO "));
        la.append("◊".repeat(35)).append("\n");
        la.append(" Título: ").append(titulo).append("\n");
        la.append(" Idiomas: ").append(idiomas).append("\n");
        la.append(" Descargas: ").append(numeroDeDescarga).append("\n");

        if (autores == null || autores.isEmpty()) {
            la.append(" Autores: No registrados todavía.\n");
        } else {
            la.append(" Autores:\n");
            for (Autor autor : autores) {
                la.append("   - ").append(autor).append("\n");  // Usa autor.toString()
            }
        }

        return la.toString();
    }
}