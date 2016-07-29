/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gym.gymcore.utils.main;

import com.gym.entity.Socio;
import com.gym.persistence.dao.SocioDao;
import java.util.List;

/**
 *
 * @author JOSE
 */
public class Main {
    
     public static void main(String[] args) throws Exception {
       SocioDao socioDao = new SocioDao();
       List<Socio> soc = socioDao.buscarTodos();
       if(soc.size() > 0){
           for(int i=0; i<soc.size();i++){
           System.out.println(".::Datos del Socio::."); 
           System.out.println("Cedula: " + soc.get(i).getCedula());
           System.out.println("Nombres: " + soc.get(i).getNombres());
           System.out.println("Apellidos: " + soc.get(i).getApellidos());
           }
       }
       
      /* for(Socio index: socioDao.buscarTodos()){
           System.out.println(".::Datos del Socio::."); 
           System.out.println("Cedula: " + socio.getCedula());
           System.out.println("Nombres: " + socio.getNombres());
           System.out.println("Apellidos: " + socio.getApellidos());
           
       }*/
              
     }
}
