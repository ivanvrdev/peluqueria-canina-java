
package Persistencia;

import Logica.Mascota;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MascotaController {
    
    //Instanciamos la clase MascotaJPA
    MascotaJpaController masJPA = new MascotaJpaController();
    
    //Método para insertar Mascota
    
    public void crearMascota(Mascota mascota){
        try {
            masJPA.create(mascota);
        } catch (Exception ex) {
            Logger.getLogger(MascotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Método para eliminar Mascota
    public void eliminarMascota(int id){
        try {
            masJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(MascotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Método para editar Mascota
    public void modificarMascota(Mascota mascota){
        try {
            masJPA.edit(mascota);
        } catch (Exception ex) {
            Logger.getLogger(MascotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Mascota> listarMascotas(){
        List<Mascota> listarMascota = masJPA.findMascotaEntities();
        return listarMascota;
    }
    
    public Mascota buscarUnaMascota(int id){
        Mascota mascota = masJPA.findMascota(id);
        return mascota;
    }
}
