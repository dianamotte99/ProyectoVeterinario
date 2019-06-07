
package Prueba;

import dao.MascotaDao;
import entidades.Mascota;
import org.hibernate.Session;
import utilitarios.HibernateUtil;


public class Ejemplo3 {

  
    public static void main(String[] args) {
        // TODO code application logic here
        
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        
        MascotaDao mascotadao = new MascotaDao();
        Mascota mascota = new Mascota();
        
        mascotadao.actualizarMascota(sesion, mascota);
        
        mascota.setIdMascota(1);
        mascota.setNombreCliente("Sandor");
        mascota.setNombreMascota("Marlin");
        mascota.setRaza("Pastor Aleman");
        
        

      
    }
    
}
