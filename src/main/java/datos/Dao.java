/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.example.modelo.Cuenta;

public class Dao {
      
    public EntityManager getSession() {
        return JPAUtil.getSession();
    }
    
    public boolean guardar(Object obj){
        boolean b = false;
        EntityManager s = getSession();
        EntityTransaction tx = null;
        try {
            tx = s.getTransaction();
            tx.begin();
            s.persist(obj);
            tx.commit();  
            b = true;
        } catch (Exception e) {
            System.out.println(e);
            tx.rollback();
        }finally{
            s.close();
        }        
        return b;        
    }
    
    public boolean eliminar(Object obj){
        boolean b = false;
        EntityManager s = getSession();
        EntityTransaction tx = null;
        try {
            tx = s.getTransaction();
            tx.begin();
            s.remove(obj);
            tx.commit();  
            b = true;
        } catch (Exception e) {   
            System.out.println(e);
            tx.rollback();
        }finally{
            s.close();
        }        
        return b;        
    }
    
    public <T> T getById(Class<T> clase, Long id){
        try {
            EntityManager s = getSession();
            return (T)s.find(clase, id);
        } catch (Exception e) {
            return null;
        }
    }
    
    public <T> List<T> getAll(Class<T> clase){
        try {
        	CriteriaBuilder cb = getSession().getCriteriaBuilder();
            CriteriaQuery<T> cri = cb.createQuery(clase);
            Root<T> c = cri.from(clase);
            cri.select(c);
            List<T> groupList = (List<T>) cri.select(c).getGroupList();
			return groupList;                        
        } catch (Exception e) {
            return new ArrayList<T>();
        }
    }
    
    
	@SuppressWarnings("unchecked")
	public Cuenta autenticar(String usuario, String clave){
		Cuenta c = null;
		try{
			 Query q = getSession().createQuery("Select u from Cuenta u where u.usuario=:usuario and u.clave=:clave");
	            
	            q.setParameter("usuario", usuario);
	            q.setParameter("clave", clave);              
	            
	            ArrayList<Cuenta> ep = new ArrayList<Cuenta>(q.getResultList());
	            
				for(Cuenta e: ep){
					c=e;
				}
				return c;
		}catch(Exception e){
			//System.out.print("no ingres�"+e.getCause().getMessage());
			return null;
		}
       
    }
    
	/*public static void main(String... argsx){                
        System.out.println(new Dao().autenticar("ceci","123"));
       
    }*/

	
    
    
    
}
