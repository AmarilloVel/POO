package maestros;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

// import maestros.Calificacion;
// import maestros.Estudiante;
// import maestros.Materia;



public class Princ{

    public static ArrayList<Docente> docentes = new ArrayList<>();
    public static ArrayList<Estudiante> estudaintes = new ArrayList<>();
    public static ArrayList<Materia> materias = new ArrayList<>();
    public static ArrayList<Calificacion> calificaciones = new ArrayList<>(); 
    public static Scanner le = new Scanner(System.in);

    public static FileWriter archivo = null;//objeto para arbir el archivo
    public static PrintWriter pw = null;//objeto para imprimir el archivo
    public static void main(String[] args){
        
        String menu = new String(
            "1. Agregar maestros\n" + 
            "2. Ver profesores\n" +
            "3. Agregar Alumno\n" +
            "4. Ver Alumnos\n" +
            "5. Agregar Materia\n" +
            "6. Ver materias\n"+
            "7. Capturar califiacion\n"+
            "8. Ver calificacion\n"+
            "9.Consultar calificacion\n"+
            "10. Salir");
        int opc=0;

        while(opc != 9){
            try{
                opc = Integer.parseInt(JOptionPane.showInputDialog(null,menu));
            }catch(Exception e){
                System.exit(-1);
            }

            switch(opc){
                case 1: agregarProfesor();break;
                case 2: verProfesores(); break;
                case 3: agregarAlumno(); break;
                case 4: verAlumnos(); break;
                case 5: agregarMateria(); break;
                case 6: verMaterias(); break;
                case 7: capturarCalif(); break;
                case 8: verCalifiaciones(); break;
                case 9: consCalifiaciones(); break;
                case 10: System.exit(-1);break;
                case 11: eliminarMaestro(); break;
            }

        }
    }
    
    public static void consCalifiaciones(){
        cargarCalif();

        System.out.print("\nIngrese ID de alumno: "); int cvIDE = le.nextInt();
        System.out.print("\nIngrese ID de materia: "); int cvIDM = le.nextInt();
        int IDE;
        int IDM;
        
        for(Calificacion est: calificaciones){
            
            IDE = est.getIDE();
            IDM = est.getIDM();
                
            if(IDE == cvIDE && IDM == cvIDM){
                System.out.printf("\n\tCalificacion: %d ",est.getCal(IDE, IDM));
        
            }             
        }
        


    }

    public static void agregarAlumno(){
        Estudiante nuevo = new Estudiante();
        System.out.println("Ingrese nombre del Estudainte: "); String nomm= le.next();
        System.out.println("Ingrese clave: "); String cv= le.next();
        System.out.println("Ingrese email: "); String em= le.next();
        

        nuevo.setNombre(nomm);
        nuevo.setEmail(em);
        nuevo.setClave(cv);

        estudaintes.add(nuevo);

        try{
            archivo = new FileWriter("Alumnos.csv",true);//se guarda en archivo
            pw = new PrintWriter(archivo);//para imprimir archivo
            pw.println(
                nomm +","
                +cv+","+em
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

    public static void verAlumnos(){
        cargarAlumnos();

        System.out.print("\n\t\t\t\t\t\t\tALUMNOS:");
        System.out.println("\n\t\t\tNombre\t\t\t\tClave\t\t\t\tEmail");
        for(Estudiante est: estudaintes){
            System.out.printf("\n\t\t\t%s\t\t\t\t%s\t\t\t\t%s\t\t\t ",est.getNombre(),est.getClave(),est.getEmail());
        }

    }

    public static void cargarAlumnos(){
        String nombreArchivo = "Alumnos.csv";
        File aral = new File(nombreArchivo);
        estudaintes.clear();
        try{
            Scanner lineaArchivoAl = new Scanner(aral);//es un tipo array list
            while(lineaArchivoAl.hasNext()){
               String datos = lineaArchivoAl.next(); //variable para sacar los datos
               String []dato = datos.split(",");//
               Estudiante doce = new Estudiante();
               doce.setNombre(dato[0]);
               doce.setClave(dato[1]);
               doce.setEmail(dato[2]);
               
               estudaintes.add(doce);
            }

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }finally{
            //if(alp != null){
           //     alp.close();
            //}
        
        }
    }




    public static void agregarProfesor(){
        Docente nuevo = new Docente();
        System.out.println("Ingrese nombre del Prof: "); String nomm= le.next();
        System.out.println("Ingrese email: "); String em= le.next();
    

        nuevo.setClave();
        nuevo.setNombramiento();
        nuevo.setEmail(em);
        nuevo.setNombre(nomm);

        docentes.add(nuevo);
        try{
            archivo = new FileWriter("Profesores.csv",true);//se guarda en archivo
            pw = new PrintWriter(archivo);//para imprimir archivo
            pw.println(
                nomm +","
                +"["+em+"]"+","+
                nuevo.getClave()+","
                +nuevo.getNombramiento() 
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

    public static void verProfesores(){
        cargarProfesores();


        System.out.print("\t\t\t\t\t\t\t\t\t\tProfesores:");
        System.out.println("\n\t\t\t\tNombre\t\t\t\tClave\t\t\t\t\tEmail\t\t\t\tNombramiento");
        for(Docente profe: docentes){
            System.out.printf("\n\t\t\t\t%s\t\t\t\t%s\t\t\t\t\t%s\t\t\t\t%s",profe.getNombre(),profe.getEmail(),profe.getClave(),profe.getNombramiento());
        }
    }

    public static void cargarProfesores(){
        String nombreArchivo = "Profesores.csv";
        File arpr = new File(nombreArchivo);
        docentes.clear();
        try{
            Scanner lineaArchivoProfes = new Scanner(arpr);//es un tipo array list
            while(lineaArchivoProfes.hasNext()){
               String datos = lineaArchivoProfes.next(); //variable para sacar los datos
               String []dato = datos.split(",");//
               Docente doce = new Docente();
               doce.setNombre(dato[0]);
               doce.setClave(dato[1]);
               doce.setEmail(dato[2]);
               doce.setNombramiento(dato[3]);
               
               docentes.add(doce);
            }

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }finally{
            //if(alp != null){
           //     alp.close();
            //}
        
        }
    }

    public static void agregarMateria(){
        System.out.print("Ingrese materia: "); String materia = le.next();
        System.out.print("\nIngrese Semestre: "); int sem = le.nextInt();
        Materia nueva = new Materia(materia, sem);
        
        materias.add(nueva);
        try{
            archivo = new FileWriter("Materiass.csv",true);//se guarda en archivo
            pw = new PrintWriter(archivo);//para imprimir archivo
            pw.println(
                materia +","
                +sem 
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

    public static void verMaterias(){
        cargarMaterias();
        System.out.print("\t\t\t\t\tMATERIAS");
        System.out.print("\n\t\t\tMateria  \t\t\tSemestres");
        for(Materia m: materias){
            System.out.printf("\n\t\t\t%s\t\t\t\t%d",m.getMateria(),m.getSemestre());
            System.out.println();
        }
    }

    public static void cargarMaterias(){
        String nombreArchivo = "Materiass.csv";
        File arma = new File(nombreArchivo);
        materias.clear();
        try{
            Scanner lineaArchivoMaterias = new Scanner(arma);//es un tipo array list
            while(lineaArchivoMaterias.hasNext()){
               String datos = lineaArchivoMaterias.next(); //variable para sacar los datos
               String []dato = datos.split(",");//
               Materia newm = new Materia(dato[0],Integer.parseInt(dato[1]));
              
               materias.add(newm);
            }

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }finally{
            //if(alp != null){
           //     alp.close();
            //}
        }
    }


    public static void capturarCalif(){

        System.out.println("Ingrese id del estudiante: "); int ide = le.nextInt();
        System.out.println("Ingrese id de la materia: "); int idm = le.nextInt();
        System.out.println("Ingrese Calificacion: "); int cal = le.nextInt();

        Calificacion nueva = new Calificacion(ide, idm, cal);
        calificaciones.add(nueva);
        try{
            archivo = new FileWriter("Calificaciones.csv",true);//se guarda en archivo
            pw = new PrintWriter(archivo);//para imprimir archivo
            pw.println(
                ide +","
                +idm +","
                +cal 
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

    public static void verCalifiaciones(){
        cargarCalif();
        System.out.print("\n\t\t\t\t\t\tCALIFICACIONES");
        System.out.print("\n\t\t\tIDestudiante\t\t\tIDmateria\t\t\tCalificacion");
        for(Calificacion cal: calificaciones){
            System.out.printf("\n\t\t\t%d\t\t\t\t%d\t\t\t\t%d",cal.getIDE(),cal.getIDM(),cal.getCal());
            System.out.println();
        }
    }

    public static void cargarCalif(){
        String nombreArchivo = "Calificaciones.csv";
        File arCa = new File(nombreArchivo);
        calificaciones.clear();
        try{
            Scanner lineaArchivoCal = new Scanner(arCa);//es un tipo array list
            while(lineaArchivoCal.hasNext()){
               String datos = lineaArchivoCal.next(); //variable para sacar los datos
               String []dato = datos.split(",");//
               Calificacion newCal = new Calificacion(Integer.parseInt(dato[0]),Integer.parseInt(dato[1]),Integer.parseInt(dato[2]));
            
               calificaciones.add(newCal);
            }

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }finally{
            //if(alp != null){
           //     alp.close();
            //}        
        }
    }

    public static void eliminarMaestro(){
        
        cargarProfesores();

        System.out.print("\nIngrese id de profesor: "); String id = le.next();

        String nombreArchivo = "Profesores.csv";
        File arpr = new File(nombreArchivo);
        docentes.clear();
        try{
            Scanner lineaArchivoProfes = new Scanner(arpr);//es un tipo array list
            while(lineaArchivoProfes.hasNext()){
               String datos = lineaArchivoProfes.next(); //variable para sacar los datos
               String []dato = datos.split(",");//
               Docente doce = new Docente();
               doce.setNombre(dato[0]);
               doce.setClave(dato[1]);
               doce.setEmail(dato[2]);
               doce.setNombramiento(dato[3]);


               if(id == doce.getClave() ){
                   docentes.remove(doce);
               }
            }


            

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }finally{
            //if(alp != null){
           //     alp.close();
            //}
        
        }

    }




}