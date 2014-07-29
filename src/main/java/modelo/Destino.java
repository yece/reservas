package com.example.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the destino database table.
 * 
 */
@Entity
@NamedQuery(name="Destino.findAll", query="SELECT d FROM Destino d")
public class Destino implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_destino")
	private int idDestino;

	@Column(name="boletos_reservados")
	private int boletosReservados;

	@Column(name="boletos_stock")
	private int boletosStock;

	@Column(name="boletos_vendidos")
	private int boletosVendidos;

	private String conductor;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	//bi-directional many-to-one association to Boleto
	@OneToMany(mappedBy="destino")
	private List<Boleto> boletos;

	//bi-directional many-to-one association to Bus
	@ManyToOne
	private Bus bus;

	//bi-directional many-to-one association to Dia
	@ManyToOne
	private Dia dia;

	public Destino() {
	}

	public int getIdDestino() {
		return this.idDestino;
	}

	public void setIdDestino(int idDestino) {
		this.idDestino = idDestino;
	}

	public int getBoletosReservados() {
		return this.boletosReservados;
	}

	public void setBoletosReservados(int boletosReservados) {
		this.boletosReservados = boletosReservados;
	}

	public int getBoletosStock() {
		return this.boletosStock;
	}

	public void setBoletosStock(int boletosStock) {
		this.boletosStock = boletosStock;
	}

	public int getBoletosVendidos() {
		return this.boletosVendidos;
	}

	public void setBoletosVendidos(int boletosVendidos) {
		this.boletosVendidos = boletosVendidos;
	}

	public String getConductor() {
		return this.conductor;
	}

	public void setConductor(String conductor) {
		this.conductor = conductor;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<Boleto> getBoletos() {
		return this.boletos;
	}

	public void setBoletos(List<Boleto> boletos) {
		this.boletos = boletos;
	}

	public Boleto addBoleto(Boleto boleto) {
		getBoletos().add(boleto);
		boleto.setDestino(this);

		return boleto;
	}

	public Boleto removeBoleto(Boleto boleto) {
		getBoletos().remove(boleto);
		boleto.setDestino(null);

		return boleto;
	}

	public Bus getBus() {
		return this.bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Dia getDia() {
		return this.dia;
	}

	public void setDia(Dia dia) {
		this.dia = dia;
	}

}