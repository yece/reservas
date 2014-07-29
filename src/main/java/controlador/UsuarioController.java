package com.example.controlador;

import java.util.List;

import com.example.datos.Dao;
import com.example.modelo.Cuenta;
import com.example.modelo.Usuario;

public class UsuarioController {

    private List<Usuario> lista;
    private Usuario usuarioEdicion;
    private Cuenta cuentaEdicion;
    private String claveActual;
    private String claveNueva;
    
   
    private SessionBean session;        

    public UsuarioController() {
    }

    public void setSession(SessionBean session) {
        this.session = session;
    }
    
    public String accionEditarUsuario(){
        cuentaEdicion=session.getCuentaLogeada();
                     
        return "";
    }

    public String accionGuardarUsuario() {               
        new Dao().guardar(cuentaEdicion.getUsuario());
        return "guardar usuario";
    }
    
     public String accionEditarPassword(){
                             
        return "editar pass";
    }

    public String accionGuardarPassword() {   
        cuentaEdicion=session.getCuentaLogeada();
        if(cuentaEdicion.getClave().equals(claveActual)){
            cuentaEdicion.setClave(claveNueva);
            new Dao().guardar(cuentaEdicion);
            return "guardar passw";
        }
            return "editarPassword?faces-redirect=true";
        
    }
    
    public String accionCancelar() {
        cuentaEdicion = null;
        return "canc";
    }


    public List<Usuario> getLista() {
        return lista;
    }

    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }

    public Usuario getUsuarioEdicion() {
        return usuarioEdicion;
    }

    public void setUsuarioEdicion(Usuario usuarioEdicion) {
        this.usuarioEdicion = usuarioEdicion;
    }

   
    public Cuenta getCuentaEdicion() {
        return cuentaEdicion;
    }

    public void setCuentaEdicion(Cuenta cuentaEdicion) {
        this.cuentaEdicion = cuentaEdicion;
    }

    public String getClaveActual() {
        return claveActual;
    }

    public void setClaveActual(String claveActual) {
        this.claveActual = claveActual;
    }

    public String getClaveNueva() {
        return claveNueva;
    }

    public void setClaveNueva(String claveNueva) {
        this.claveNueva = claveNueva;
    }
}
