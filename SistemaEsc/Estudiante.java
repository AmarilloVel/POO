package maestros;

import javax.swing.JOptionPane;


public class Estudiante extends Miembro{

    private int id;
    private String nCuenta;

    @Override
    public void setClave(){
        this.nCuenta = JOptionPane.showInputDialog(null, "Ingrese numero de Cuenta:");
    } 
 
    
    public void setClave(String clave){
        this.nCuenta = clave;
    } 
    
    

    @Override
    public String getClave(){
        return this.nCuenta;
    }


}