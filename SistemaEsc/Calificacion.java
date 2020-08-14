package maestros;

public class Calificacion{

    private int id;
    private int cal;
    private int idestudiante;
    private int idmateria;

    public Calificacion(int idE, int idM, int calif){
        this.idestudiante = idE;
        this.cal = calif;
        this.idmateria = idM;


    }
    public int getIDE(){
        return this.idestudiante;
    }
    public int getIDM(){
        return this.idmateria;
    }
    public int getCal(){
        return this.cal;
    }


    public int getCal(int idestudiante,int idmateria) {
        return this.cal;
    }
    


}