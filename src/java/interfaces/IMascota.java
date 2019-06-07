/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Mascota;
import java.util.ArrayList;
import org.hibernate.Session;

/**
 *
 * @author Juan Carlos
 */
public interface IMascota {
    
    public abstract boolean guardarMascota(Mascota mascota);
    public abstract ArrayList<Mascota> listarMascotas(Session sesion);
    
    public abstract  void actualizarMascota(Session sesion, Mascota mascota);
    public abstract ArrayList<Mascota> listarraza(Session sesion);
    public abstract Mascota buscarnombreMascota(Session sesion,int id);
    public abstract Integer ContadorDeRegistros(Session sesion);
    
}
