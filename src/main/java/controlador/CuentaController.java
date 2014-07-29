package com.example.controlador;

import java.util.List;

import com.example.datos.Dao;
import com.example.modelo.Cliente;
import com.example.modelo.Cuenta;
import com.example.modelo.Personal;
import com.example.modelo.Usuario;



public class CuentaController {

    private List<Cuenta> lista;
    private Cuenta cuentaEdicion;
    private Usuario usuario;
    private Personal personal;
    private Cliente cliente;
    private boolean disabledCurso=true;
    private boolean disabledContrato=true;

    public CuentaController() {
    }
    
    
    
    public String accionNuevo() 
    {
        
        cuentaEdicion = new Cuenta();
        usuario= new Usuario();
        personal= new Personal();
        cliente= new Cliente();
        //usuario.getUsuario();
        return "/usuario/nuevaCuenta?faces-redirect=true";
    }

    public String accionEditar(Cuenta u) {
        cuentaEdicion = u; 
           if("Personal".equals(cuentaEdicion.getRolBean().getNombre())){
                  usuario=new Dao().getById(Usuario.class, (long)cuentaEdicion.getUsuarioBean().getIdUsuario()) ;
                  personal = new Dao().getById(Personal.class,(long) cuentaEdicion.getUsuarioBean().getIdUsuario()) ;
                  disabledCurso=false;
                  disabledContrato=true; 
 
           }else{
                    if("Cliente".equals(cuentaEdicion.getRolBean().getNombre())){     
                        usuario=new Dao().getById(Usuario.class, (long)cuentaEdicion.getUsuarioBean().getIdUsuario()) ;
                        cliente = new Dao().getById(Cliente.class, (long)cuentaEdicion.getUsuarioBean().getIdUsuario()) ;
                        disabledContrato=false;  
                        disabledCurso=true;
           }   else{
                        usuario=cuentaEdicion.getUsuarioBean();
                        disabledCurso=true;
                        disabledContrato=true; 
                    }
                   }

        return "/usuario/editar?faces-redirect=true";
    }


    public void accionEliminar(Cuenta c) {
        Dao dao = new Dao();        
       
        if("Personal".equals(c.getRolBean().getNombre())){
           personal = new Dao().getById(Personal.class, (long)c.getUsuarioBean().getIdUsuario()) ;
            dao.eliminar(c);
            dao.eliminar(personal);
        }else{
            if("Cliente".equals(c.getRolBean().getNombre())){
                cliente = new Dao().getById(Cliente.class,(long)c.getUsuarioBean().getIdUsuario()) ;
                dao.eliminar(c);
                dao.eliminar(cliente);
                
            }else{
                usuario=c.getUsuarioBean();
                dao.eliminar(c);
                dao.eliminar(usuario);
            }
            
        }       
        
    }

    public String accionGuardar() {
            
                   if("Personal".equals(cuentaEdicion.getRolBean().getNombre())){
                   personal.getUsuario().setCedula(usuario.getCedula());
                   personal.getUsuario().setNombre(usuario.getNombre());
                   personal.getUsuario().setApellido(usuario.getApellido());   
                   new Dao().guardar(personal);  
                   cuentaEdicion.setUsuarioBean(personal.getUsuario());; 
                   new Dao().guardar(cuentaEdicion);
 
           }else{
                    if("Cliente".equals(cuentaEdicion.getRolBean().getNombre())){
                   cliente.getUsuario().setCedula(usuario.getCedula());
                   cliente.getUsuario().setNombre(usuario.getNombre());
                   cliente.getUsuario().setApellido(usuario.getApellido());   
                   new Dao().guardar(cliente);  
                   cuentaEdicion.setUsuarioBean(cliente.getUsuario()); 
                   new Dao().guardar(cuentaEdicion);
 
           }   else{
                      new Dao().guardar(usuario);  
                     cuentaEdicion.setUsuarioBean(usuario); 
                     new Dao().guardar(cuentaEdicion);  
                    }
                   }
              

        return "/usuario/lista?faces-redirect=true";
    }
    
    //---------------------------
    
    
    //---------------------------

    
    public static void main(String[] args) {
        //Usuario us = new Usuario("222557398"," jjjj", "jjjj");
//        
      //  Curso cu = new Curso("Primero", "F");
//        System.out.println( new Dao().guardar(cu));
//        Estudiante es = new Estudiante();
//        es.setApellido("AAAAAA");
//        es.setCedula("7878787879");
//        es.setNombre("bbbbbb");
//        es.setCurso(cu);
//        System.out.println( new Dao().guardar(es));
       // Rol rol = new Rol("Tttttaacc", "ttttt");
//        System.out.println( new Dao().guardar(rol));
////        
       // Cuenta cuen = new Cuenta("cuentammmss", "cuentammmss", rol, "activo");
//        if("Tttttaacc".equals(cuen.getRol().getTipo())){
//            
     // System.out.println( new Dao().guardar(us));  
        Long id = null ;
        id=(Long.parseLong("43"));
        Cuenta cuen= new Dao().getById(Cuenta.class,id); 
        
        Personal us = new Dao().getById(Personal.class, (long)cuen.getUsuarioBean().getIdUsuario()) ;
      //  new Dao().eliminar((new Dao().getById(Estudiante.class, cuen.getUsuario().getId())));
        
        System.out.println(us);
        
        //System.out.println(us);
        System.out.println(new Dao().eliminar(cuen));
        System.out.println( new Dao().eliminar(us));
       
//        }
        
        
   // System.out.println(new Dao().eliminar(cuen));
        
        
//        
//        
    }
    
    public void guardarCuenta(Cuenta cuenta){
        new Dao().guardar(cuenta);
    }

    public String accionCancelar() {
        cuentaEdicion = null;
//        usuario=null;
        return "/usuario/lista?faces-redirect=true";
    }

    public List<Cuenta> getLista() {

        lista = new Dao().getAll(Cuenta.class);

        return lista;
    }

    public void setLista(List<Cuenta> lista) {
        this.lista = lista;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Personal getEstudiante() {
        return personal;
    }

    public void setEstudiante(Personal estudiante) {
        this.personal = estudiante;
    }

    public Cliente getDocente() {
        return cliente;
    }

    public void setDocente(Cliente docente) {
        this.cliente = docente;
    }

 
    public Cuenta getCuentaEdicion() {
        return cuentaEdicion;
    }

    public void setCuentaEdicion(Cuenta cuentaEdicion) {
        this.cuentaEdicion = cuentaEdicion;
    }

    public boolean isDisabledCurso() {
        return disabledCurso;
    }

    public void setDisabledCurso(boolean disabledCurso) {
        this.disabledCurso = disabledCurso;
    }

    public boolean isDisabledContrato() {
        return disabledContrato;
    }

    public void setDisabledContrato(boolean disabledContrato) {
        this.disabledContrato = disabledContrato;
    }
    
   
}
