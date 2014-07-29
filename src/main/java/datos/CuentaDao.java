/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;





import com.example.modelo.Cuenta;

/**
 *
 * @author ceci
 */
public class CuentaDao extends Dao{
    
      public Cuenta autenticarClave(String usuario, String clave){
    	  Cuenta c = null;
        try {
        	c= autenticar(usuario, clave);
			return c;
        } catch (Exception e) {
          return null;
        }
        
    }
      public static void main(String... argsx){       
    	  CuentaDao a = new CuentaDao();
          System.out.println(a.autenticarClave("ceci","123"));
         
      }
    
}
