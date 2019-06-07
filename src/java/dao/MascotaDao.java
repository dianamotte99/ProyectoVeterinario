/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Mascota;
import interfaces.IMascota;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilitarios.HibernateUtil;

/**
 *
 * @author Juan Carlos
 */
public class MascotaDao implements IMascota{

    @Override
    public  boolean guardarMascota(Mascota mascota) {
        //Construir una nueva session y una nueva transaccion
        boolean respuesta=true;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();
        
        //Registrar en la base de datos la mascota
        try {
            sesion.save(mascota);
            transaccion.commit();
        } catch (Exception e) {
            respuesta=false;
        }
        
        
        sesion.close();
        return  respuesta;
    }

    @Override
    public ArrayList<Mascota> listarMascotas(Session sesion) {
        ArrayList<Mascota> milista = new ArrayList<>();
        //Crear la consulta hacia la base de datos
        Query query = sesion.createQuery("FROM Mascota");
        
        //Ejecutar la consulta y obtener la lista
        try {
            milista = (ArrayList<Mascota>) query.list();
        } catch (Exception e) {
            
        }
   
        return milista;
    
    }

    @Override
    public void actualizarMascota(Session sesion, Mascota mascota) {
        Session session =HibernateUtil.getSessionFactory().openSession();
     
        sesion.update(mascota);
     
    }
    @Override
    public ArrayList<Mascota> listarraza(Session sesion) {
         ArrayList<Mascota> milista = new ArrayList<>();
        //Crear la consulta hacia la base de datos
        Query query = sesion.createQuery("FROM  mascota where pastorAleman");
        
        //Ejecutar la consulta y obtener la lista
        milista = (ArrayList<Mascota>)query.list();
    
        return milista;
        
    }

    @Override
    public Mascota buscarnombreMascota(Session sesion, int IdSandor) {
        return (Mascota) sesion.get(Mascota.class, IdSandor);
    }

    @Override
    public Integer ContadorDeRegistros(Session sesion) {
        Query query = sesion.createQuery("select count(*)FROM Mascota");
        Long FilasTab=(Long)query.uniqueResult();
        Integer cont=FilasTab.intValue();
        return cont;
    }
    
}
