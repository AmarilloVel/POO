package maestros;
import javax.swing.JOptionPane;


public class Docente extends Miembro{ 
   
   protected String nombramiento;
   protected String ntrabajador;

   public void setNombramiento() {

    this.nombramiento = JOptionPane.showInputDialog(null, "Nombramiento: ");
    
   }
   public void setNombramiento(String nombra) {

    this.nombramiento = nombra;
    
   }

   public String getNombramiento(){
       return this.nombramiento;
   }


   //Ingresamos la clave al numero de trabajador        
   @Override
   public void setClave(){
       this.ntrabajador = JOptionPane.showInputDialog(null, "Ingrese ID:");
   } 

   
   public void setClave(String clave){
       this.ntrabajador = clave;
   } 


   @Override
   public String getClave(){
       return this.ntrabajador;
   }

   
   


}