package com.example.controlador;

import java.io.Serializable;

import com.example.modelo.Cuenta;

@SuppressWarnings("serial")
public class SessionBean implements Serializable{
	private Cuenta cuentaLogeada;

    public SessionBean() {
    }        

    public Cuenta getCuentaLogeada() {
        return cuentaLogeada;
    }

    public void setCuentaLogeada(Cuenta cuentaLogeada) {
        this.cuentaLogeada = cuentaLogeada;
    }
}
