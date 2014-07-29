package com.example.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.List;


/**
 * The persistent class for the hora_viaje database table.
 * 
 */
@Entity
@Table(name="hora_viaje")
@NamedQuery(name="HoraViaje.findAll", query="SELECT h FROM HoraViaje h")
public class HoraViaje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_horario_viaje")
	private int idHorarioViaje;

	private Time hora;

	//bi-directional many-to-one association to Horario
	@OneToMany(mappedBy="horaViaje")
	private List<Horario> horarios;

	public HoraViaje() {
	}

	public int getIdHorarioViaje() {
		return this.idHorarioViaje;
	}

	public void setIdHorarioViaje(int idHorarioViaje) {
		this.idHorarioViaje = idHorarioViaje;
	}

	public Time getHora() {
		return this.hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public List<Horario> getHorarios() {
		return this.horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

	public Horario addHorario(Horario horario) {
		getHorarios().add(horario);
		horario.setHoraViaje(this);

		return horario;
	}

	public Horario removeHorario(Horario horario) {
		getHorarios().remove(horario);
		horario.setHoraViaje(null);

		return horario;
	}

}