package maestros;

import java.util.Scanner;   

import javax.swing.JOptionPane;

public abstract class Miembro{

    protected int id;
    protected String nombre,email;
    
    Scanner entrada = new Scanner(System.in);

    public void setNombre(String nom){
        this.nombre = nom;
    }

    public void setEmail(String ema){
        this.email = ema;
    }

    

    public abstract void setClave();

    public abstract String getClave();

    public String getNombre(){
        return this.nombre;
    }

    public String getEmail(){
        return this.email;
    }

   


}