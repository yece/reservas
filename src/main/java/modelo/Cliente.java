package com.example.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cliente")
	private int idCliente;

	//bi-directional many-to-one association to Boleto
	@OneToMany(mappedBy="cliente")
	private List<Boleto> boletos;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	//bi-directional many-to-one association to ClienteEmpresa
	@OneToMany(mappedBy="cliente")
	private List<ClienteEmpresa> clienteEmpresas;

	public Cliente() {
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public List<Boleto> getBoletos() {
		return this.boletos;
	}

	public void setBoletos(List<Boleto> boletos) {
		this.boletos = boletos;
	}

	public Boleto addBoleto(Boleto boleto) {
		getBoletos().add(boleto);
		boleto.setCliente(this);

		return boleto;
	}

	public Boleto removeBoleto(Boleto boleto) {
		getBoletos().remove(boleto);
		boleto.setCliente(null);

		return boleto;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<ClienteEmpresa> getClienteEmpresas() {
		return this.clienteEmpresas;
	}

	public void setClienteEmpresas(List<ClienteEmpresa> clienteEmpresas) {
		this.clienteEmpresas = clienteEmpresas;
	}

	public ClienteEmpresa addClienteEmpresa(ClienteEmpresa clienteEmpresa) {
		getClienteEmpresas().add(clienteEmpresa);
		clienteEmpresa.setCliente(this);

		return clienteEmpresa;
	}

	public ClienteEmpresa removeClienteEmpresa(ClienteEmpresa clienteEmpresa) {
		getClienteEmpresas().remove(clienteEmpresa);
		clienteEmpresa.setCliente(null);

		return clienteEmpresa;
	}

}