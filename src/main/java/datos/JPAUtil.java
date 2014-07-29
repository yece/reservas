/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.datos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author ceci
 */
public class JPAUtil {

   
    private static final EntityManagerFactory sessionFactory;
    
    static {
        try {
           
        	sessionFactory = Persistence.createEntityManagerFactory("reserva_inicialJPA");
        	
        } catch (Throwable ex) {
            
            System.err.println("Inicio de sesión ha fallado." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static EntityManagerFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static EntityManager getSession() {
        return getSessionFactory().createEntityManager();
    }
}
