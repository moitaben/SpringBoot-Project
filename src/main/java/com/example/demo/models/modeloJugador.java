package com.example.demo.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "jugador")
public class modeloJugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String nombre;

    private Integer goles;

    private String equipo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date fecha; // Si no pongo fecha, la fecha será la del sistema

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getGoles() {
        return goles;
    }

    public void setGoles(Integer goles) {
        this.goles = goles;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "modeloJugador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", goles=" + goles +
                ", equipo='" + equipo + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}