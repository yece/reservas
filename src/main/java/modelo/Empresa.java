package com.example.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the empresa database table.
 * 
 */
@Entity
@NamedQuery(name="Empresa.findAll", query="SELECT e FROM Empresa e")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_empresa")
	private int idEmpresa;

	private String ciudad;

	@Lob
	private String descripcion;

	private String direccion;

	private int estado;

	private String nombre;

	private String ruc;

	private String telefono;

	//bi-directional many-to-one association to Bus
	@OneToMany(mappedBy="empresa")
	private List<Bus> buses;

	//bi-directional many-to-one association to ClienteEmpresa
	@OneToMany(mappedBy="empresa")
	private List<ClienteEmpresa> clienteEmpresas;

	//bi-directional many-to-one association to Personal
	@OneToMany(mappedBy="empresa")
	private List<Personal> personals;

	//bi-directional many-to-one association to Ruta
	@OneToMany(mappedBy="empresa")
	private List<Ruta> rutas;

	//bi-directional many-to-one association to Sucursal
	@OneToMany(mappedBy="empresa")
	private List<Sucursal> sucursals;

	public Empresa() {
	}

	public int getIdEmpresa() {
		return this.idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRuc() {
		return this.ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Bus> getBuses() {
		return this.buses;
	}

	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}

	public Bus addBus(Bus bus) {
		getBuses().add(bus);
		bus.setEmpresa(this);

		return bus;
	}

	public Bus removeBus(Bus bus) {
		getBuses().remove(bus);
		bus.setEmpresa(null);

		return bus;
	}

	public List<ClienteEmpresa> getClienteEmpresas() {
		return this.clienteEmpresas;
	}

	public void setClienteEmpresas(List<ClienteEmpresa> clienteEmpresas) {
		this.clienteEmpresas = clienteEmpresas;
	}

	public ClienteEmpresa addClienteEmpresa(ClienteEmpresa clienteEmpresa) {
		getClienteEmpresas().add(clienteEmpresa);
		clienteEmpresa.setEmpresa(this);

		return clienteEmpresa;
	}

	public ClienteEmpresa removeClienteEmpresa(ClienteEmpresa clienteEmpresa) {
		getClienteEmpresas().remove(clienteEmpresa);
		clienteEmpresa.setEmpresa(null);

		return clienteEmpresa;
	}

	public List<Personal> getPersonals() {
		return this.personals;
	}

	public void setPersonals(List<Personal> personals) {
		this.personals = personals;
	}

	public Personal addPersonal(Personal personal) {
		getPersonals().add(personal);
		personal.setEmpresa(this);

		return personal;
	}

	public Personal removePersonal(Personal personal) {
		getPersonals().remove(personal);
		personal.setEmpresa(null);

		return personal;
	}

	public List<Ruta> getRutas() {
		return this.rutas;
	}

	public void setRutas(List<Ruta> rutas) {
		this.rutas = rutas;
	}

	public Ruta addRuta(Ruta ruta) {
		getRutas().add(ruta);
		ruta.setEmpresa(this);

		return ruta;
	}

	public Ruta removeRuta(Ruta ruta) {
		getRutas().remove(ruta);
		ruta.setEmpresa(null);

		return ruta;
	}

	public List<Sucursal> getSucursals() {
		return this.sucursals;
	}

	public void setSucursals(List<Sucursal> sucursals) {
		this.sucursals = sucursals;
	}

	public Sucursal addSucursal(Sucursal sucursal) {
		getSucursals().add(sucursal);
		sucursal.setEmpresa(this);

		return sucursal;
	}

	public Sucursal removeSucursal(Sucursal sucursal) {
		getSucursals().remove(sucursal);
		sucursal.setEmpresa(null);

		return sucursal;
	}

}