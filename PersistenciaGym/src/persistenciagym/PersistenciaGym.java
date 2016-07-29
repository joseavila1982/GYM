/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistenciagym;

import com.gym.entity.Socio;
import com.gym.persistence.dao.SocioDao;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JOSE
 */
public class PersistenciaGym {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
    try {
        SocioDao socioDao = new SocioDao();
        Socio socio = new Socio();
        socio.setCedula("72276131");
        socio.setNombres("JOSE ALVARO");
        socio.setApellidos("AVILA FANDIÑO");
        socio.setDireccion("CALLE 147");
        socio.setCiudad("BOGOTA D.C");
        socio.setTelefono("123");
        socio.setCelular("3017907349");
        socio.setSexo("MACULINO");
        socio.setProfesion("INGENIERO");
        socio.setObservaciones("");
        //socioDao.crear(socio);
        
        List<Socio> listSocio = socioDao.buscarTodos();
        for (int i = 0; i < listSocio.size(); i++) {
            System.out.println("ID: " + listSocio.get(i).getId());
            System.out.println("NOMBRE: " + listSocio.get(i).getNombres());
            System.out.println("Apellidos: " + listSocio.get(i).getApellidos());
        }
            
        } catch (Exception ex) {
            Logger.getLogger(Socio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
