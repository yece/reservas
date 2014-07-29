package com.example.controlador;

import java.io.Serializable;

import com.example.datos.Dao;
import com.example.modelo.Cuenta;

@SuppressWarnings("serial")
public class LoginController implements Serializable {
	 	private String usuario;
	    private String clave;
	    private SessionBean session=new SessionBean();

	    public LoginController() {
	    }

	    //Inyección 2
	    public void setSession(SessionBean session1) {
	    	
	        this.session = session1;
	    }
	
	public Cuenta login() {
        Cuenta u = new Dao().autenticar(getUsuario(), clave);
        
        if (u != null) {
            //Autenticó
            if (u.getEstado()==1) {
            		session.setCuentaLogeada(u);
            		 System.out.print("hola");
                    /*if ("Estudiante".equals(u.getRol().getTipo()) || "Docente".equals(u.getRol().getTipo())) {
                        return "opcionUsuario.xhtml?faces-redirect=true";
                    }
                    if ("Administrador".equals(u.getRol().getTipo())) {
                        return "OpcionAdministrador.xhtml?faces-redirect=true";
                    }*/
                    //return "opcionGeneral?faces-redirect=true";
                //} else {
                   /* FacesMessage fm = new FacesMessage("Su cuenta ha sido desactivada");
                    FacesContext.getCurrentInstance().addMessage(null, fm);
                    return null;*/
            }
        } else {
            //No autentica
            /*FacesMessage fm = new FacesMessage("Usuario no encontrado!!!");
            FacesContext.getCurrentInstance().addMessage(null, fm);

            return null;*/
        	u= null;
        }
     
        
        return u;
	}
	
	public static void main(String[] args) {
		try{
			LoginController lc = new LoginController();
			lc.setUsuario("ceci");
			lc.clave="123";
			System.out.print(lc.login());
		}catch(Exception e){
			System.out.print("sssssssssssssss");
		}
			
		
		
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setClave(String clave) {
		// TODO Auto-generated method stub
		this.clave = clave;
	}

	public String getClave() {
		// TODO Auto-generated method stub
		return clave;
	}

	
}
