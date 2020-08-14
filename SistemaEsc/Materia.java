package maestros;
import java.util.Scanner;

public class Materia{

    private int id;
    private int iddocente;
    private String materia;
    private int semestre;


    public Materia(String m, int sem){

        this.materia = m;
        this.semestre = sem;
    }

    public void setMateria(String m){
        this.materia =  m;
    }

    public void setSemestre(int s){
        this.semestre = s;
    }

    public void setDocente(int idd){
        this.iddocente = idd;
    }

    public String getMateria(){
        return this.materia;
    }

    public int getSemestre(){
        return this.semestre;
    }

    public int getDocente(){
        return this.iddocente;
    }




}