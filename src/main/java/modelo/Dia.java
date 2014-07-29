package com.example.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dia database table.
 * 
 */
@Entity
@NamedQuery(name="Dia.findAll", query="SELECT d FROM Dia d")
public class Dia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_dia")
	private int idDia;

	private String nombre;

	//bi-directional many-to-one association to Destino
	@OneToMany(mappedBy="dia")
	private List<Destino> destinos;

	public Dia() {
	}

	public int getIdDia() {
		return this.idDia;
	}

	public void setIdDia(int idDia) {
		this.idDia = idDia;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Destino> getDestinos() {
		return this.destinos;
	}

	public void setDestinos(List<Destino> destinos) {
		this.destinos = destinos;
	}

	public Destino addDestino(Destino destino) {
		getDestinos().add(destino);
		destino.setDia(this);

		return destino;
	}

	public Destino removeDestino(Destino destino) {
		getDestinos().remove(destino);
		destino.setDia(null);

		return destino;
	}

}