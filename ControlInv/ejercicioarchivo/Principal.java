package ejercicioarchivo;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
//inv FILE

public class Principal{

    //porque hace estas clases fuera del main?
    public static String menu = new String(
        "1.Cargar Productos\n"+
        "2. Mostrar lista de productos\n" +
        "3. Añadir producto\n"+
        "9. Salir"
    );
    public static Scanner le  = new Scanner(System.in);
    public static ArrayList<Producto> lp = new ArrayList<>();
    
    public static FileWriter archivo = null;//objeto para arbir el archivo
    public static PrintWriter pw = null;//objeto para imprimir el archivo

    public static void main(String[] args){
        menu();
    }

    public static void menu(){
        
        int op = 0;
        do{
            System.out.println(menu);
            op = le.nextInt();

            switch(op){
                case 1: listaProductos();break;
                case 2: mostrarLista(); break;
                case 3: agregarProducto(); break;

                //podemos quitar el exit orque no tendremos ventanas emergentes, porque es la terminal(lee   que no hace nada)
            }

        }while(op!=9);
    }

    public static void agregarProducto(){
        
        System.out.println("Clave:  ");     String cp= le.next();
        System.out.println("Descripcion:"); String de= le.next();
        System.out.println("Existencia:");  int ex= le.nextInt();
        System.out.println("Precio"); float pr = le.nextFloat();
        //cp,de,pr son variables auxiliares
        Producto art = new Producto(cp,de,pr,ex,0,0);
        lp.add(art);//se guarda en memora


        try{
            archivo = new FileWriter("productos.csv",true);//se guarda en archivo
            pw = new PrintWriter(archivo);//para imprimir archivo
            pw.println(
                cp + "," + 
                de + "," +
                pr + ","+
                ex + "," +
                "0,0"

            );
        }catch(Exception e){
            e.printStackTrace();//imprime en lista los errores que se dieron
        }finally{//asegurarnos cerrar el archivo
            try{
                if(archivo != null){
                    archivo.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }

    public static void listaProductos(){
        //variable aux para nombre del archivo
        String nombreArchivo = "productos.csv";
        File alp = new File(nombreArchivo);
        lp.clear();//para que no se cargue la lista anterior
        try{
            Scanner lineaArchivoProductos = new Scanner(alp);//es un tipo array list
            while(lineaArchivoProductos.hasNext()){
               String datos = lineaArchivoProductos.next(); //variable para sacar los datos
               String []dato = datos.split(",");//
               Producto p = new Producto(dato[0],dato[1],
               Float.parseFloat(dato[2]),
               Integer.parseInt(dato[3]),
               Integer.parseInt(dato[4]),
                Integer.parseInt(dato[5]));
               lp.add(p);
            }

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }finally{
            //if(alp != null){
           //     alp.close();
            //}
        
        }
    }

    public static void mostrarLista(){
        
        System.out.println("Cve.\tDescripcion\t\tPrecio\tExistencia");
        for(Producto p : lp){//productos de lp
            System.out.printf("%s\t%s\t\t\t%.2f\t%02d",p.getCve(),p.getDesc(),p.getPrecio(),p.getExist());//printf para que se apegue al formulario
            System.out.println();

        } 


    }


}