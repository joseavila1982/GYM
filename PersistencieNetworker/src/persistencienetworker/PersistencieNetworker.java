/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencienetworker;

import com.networker.entity.Categoria;
import com.networker.persistence.dao.CategoriaDao;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JOSE
 */
public class PersistencieNetworker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
        CategoriaDao categoriaDao = new CategoriaDao();
        Categoria categoria = new Categoria();
        categoria.setNombre("Promociones");
        try {
           // categoriaDao.crear(categoria);
        } catch (Exception ex) {
            Logger.getLogger(PersistencieNetworker.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            List<Categoria> listCategoria = categoriaDao.buscarTodos();
            for(int i=0; i<listCategoria.size(); i++){
                System.out.println("ID: "+listCategoria.get(i).getId());
                System.out.println("NOMBRE: "+listCategoria.get(i).getNombre());
            }
        } catch (Exception ex) {
            Logger.getLogger(PersistencieNetworker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}
