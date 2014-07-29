package com.example.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bus database table.
 * 
 */
@Entity
@NamedQuery(name="Bus.findAll", query="SELECT b FROM Bus b")
public class Bus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_bus")
	private int idBus;

	private String descripcion;

	@Column(name="nro_asientos")
	private int nroAsientos;

	@Column(name="nro_bus")
	private int nroBus;

	private String placa;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	private Empresa empresa;

	//bi-directional many-to-one association to Destino
	@OneToMany(mappedBy="bus")
	private List<Destino> destinos;

	public Bus() {
	}

	public int getIdBus() {
		return this.idBus;
	}

	public void setIdBus(int idBus) {
		this.idBus = idBus;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getNroAsientos() {
		return this.nroAsientos;
	}

	public void setNroAsientos(int nroAsientos) {
		this.nroAsientos = nroAsientos;
	}

	public int getNroBus() {
		return this.nroBus;
	}

	public void setNroBus(int nroBus) {
		this.nroBus = nroBus;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Destino> getDestinos() {
		return this.destinos;
	}

	public void setDestinos(List<Destino> destinos) {
		this.destinos = destinos;
	}

	public Destino addDestino(Destino destino) {
		getDestinos().add(destino);
		destino.setBus(this);

		return destino;
	}

	public Destino removeDestino(Destino destino) {
		getDestinos().remove(destino);
		destino.setBus(null);

		return destino;
	}

}