package ejercicioarchivo;

//usraemos el set para validar que el usuario no se equivoco a la hora de capturar los datos
// lo haremos desde el main mediante un if

// atomicidad de transaccion

public class Producto{

    private String cve;
    private String desc;
    private float precio;
    private int exist;
    private int min;
    private int max;

    public Producto(){

        this.max = 0;

    }

    public Producto(String c, String d, float p, int e, int mi, int ma){
        this.cve = c;
        this.desc = d;
        this.precio = p;
        this.exist = e;
        this.min = mi;
        this.max = ma;


    }

    public void setPrecio(float pr){
        this.precio = pr;
        
    }

    
    
    
    public void setCve(String cve) {
        this.cve = cve;
    }
    
   
    public void setDesc(String desc) {
        this.desc = desc;
    }


    public Boolean setExist(int exist) {
        Boolean ok = true;
        
        if(exist>=0 && exist <= this.max){
            this.exist = exist;
        }else{
            ok = false;

        }
        
        return ok;
    }

    public String getCve() {
        return cve;
    }

    public String getDesc() {
        return desc;
    }

    public int getExist() {
        return exist;
    }

    public float getPrecio(){
        return precio;
    }






}