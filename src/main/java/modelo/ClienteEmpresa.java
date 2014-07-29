package com.example.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cliente_empresa database table.
 * 
 */
@Entity
@Table(name="cliente_empresa")
@NamedQuery(name="ClienteEmpresa.findAll", query="SELECT c FROM ClienteEmpresa c")
public class ClienteEmpresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cliente_empresa")
	private int idClienteEmpresa;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	private Empresa empresa;

	public ClienteEmpresa() {
	}

	public int getIdClienteEmpresa() {
		return this.idClienteEmpresa;
	}

	public void setIdClienteEmpresa(int idClienteEmpresa) {
		this.idClienteEmpresa = idClienteEmpresa;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}