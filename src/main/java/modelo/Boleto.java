package com.example.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the boleto database table.
 * 
 */
@Entity
@NamedQuery(name="Boleto.findAll", query="SELECT b FROM Boleto b")
public class Boleto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_boleto")
	private int idBoleto;

	private String estado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_hora_venta")
	private Date fechaHoraVenta;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_viaje")
	private Date fechaViaje;

	@Column(name="nro_boleto")
	private int nroBoleto;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Destino
	@ManyToOne
	@JoinColumn(name="id_destino")
	private Destino destino;

	public Boleto() {
	}

	public int getIdBoleto() {
		return this.idBoleto;
	}

	public void setIdBoleto(int idBoleto) {
		this.idBoleto = idBoleto;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaHoraVenta() {
		return this.fechaHoraVenta;
	}

	public void setFechaHoraVenta(Date fechaHoraVenta) {
		this.fechaHoraVenta = fechaHoraVenta;
	}

	public Date getFechaViaje() {
		return this.fechaViaje;
	}

	public void setFechaViaje(Date fechaViaje) {
		this.fechaViaje = fechaViaje;
	}

	public int getNroBoleto() {
		return this.nroBoleto;
	}

	public void setNroBoleto(int nroBoleto) {
		this.nroBoleto = nroBoleto;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Destino getDestino() {
		return this.destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

}