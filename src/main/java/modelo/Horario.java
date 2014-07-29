package com.example.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;


/**
 * The persistent class for the horario database table.
 * 
 */
@Entity
@NamedQuery(name="Horario.findAll", query="SELECT h FROM Horario h")
public class Horario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_horario")
	private int idHorario;

	@Column(name="hora_llegada")
	private Time horaLlegada;

	//bi-directional many-to-one association to HoraViaje
	@ManyToOne
	@JoinColumn(name="id_hora_viaje")
	private HoraViaje horaViaje;

	//bi-directional many-to-one association to Ruta
	@ManyToOne
	@JoinColumn(name="id_ruta")
	private Ruta ruta;

	public Horario() {
	}

	public int getIdHorario() {
		return this.idHorario;
	}

	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}

	public Time getHoraLlegada() {
		return this.horaLlegada;
	}

	public void setHoraLlegada(Time horaLlegada) {
		this.horaLlegada = horaLlegada;
	}

	public HoraViaje getHoraViaje() {
		return this.horaViaje;
	}

	public void setHoraViaje(HoraViaje horaViaje) {
		this.horaViaje = horaViaje;
	}

	public Ruta getRuta() {
		return this.ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

}