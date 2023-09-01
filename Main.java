import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

class Main {
  public static void main(String[] args) throws IOException{
    Colegio colegio = new Colegio();
    BufferedReader lector = new BufferedReader (new InputStreamReader(System.in));
    HashMap <String, tipoFecha> evalxFecha = new HashMap();
        
    while(true){
      int opcion;
      colegio.datosIniciales();
      System.out.println("");
      System.out.println("Ingrese 1 para agregar una asignatura");
      System.out.println("Ingrese 2 para agregar una evaluación");
      System.out.println("Ingrese 3 para ver todas las evaluaciones de una asignatura");
      System.out.println("Ingrese 4 para ver todas las evaluaciones de todas las asignaturas");
      System.out.println("Ingrese 5 para ver todas las asignaturas");
      System.out.println("Ingrese 0 para salir de la aplicación");
      System.out.println("");
      opcion = Integer.parseInt(lector.readLine());
      
      switch(opcion){
        case 0: 
          System.out.println("--------PROGRAMA FINALIZADO--------");
          return;
        case 1:
          System.out.println("Ingrese la Asignatura que desea agregar: ");
          String asignaturaNueva = lector.readLine();
        //  System.out.println("Ingrese la cantidad de evaluaciones : ");
          //int numNotas = Integer.parseInt(lector.readLine());
          
          tipoAsignatura asig = new tipoAsignatura(asignaturaNueva);
          colegio.agregar(asig);

          System.out.println("");
          break;
          
        //Inserción manual / agregar elemento
        case 2:
          System.out.println("Ingrese la asignatura a la que desea añadir la evaluación: ");
          String nombreAsignatura = lector.readLine();

          tipoAsignatura asignatura = colegio.buscar(nombreAsignatura);
          if(asignatura == null){
            System.out.println("La asignatura no se encuentra registrada");
            System.out.println("");
            break;
          }
          
          System.out.println("Ingrese la fecha de la evaluación: ");
          String fecha = lector.readLine();
          System.out.println("Ingrese la unidad de la evaluación: ");
          String unidad = lector.readLine();
          
          ArrayList <String> preguntas = new ArrayList();
          
          System.out.println("Ingrese la cantidad de notas: ");
          int cantNotas = Integer.parseInt(lector.readLine());

          int sumaNotas = 0;
          int nota;
          for(int i=0; i<cantNotas; i++){
            System.out.println("Ingrese nota n°"+i+1);
            nota = Integer.parseInt(lector.readLine());
            sumaNotas=sumaNotas+nota;
          }
          int promedio = sumaNotas/cantNotas;
          
          System.out.println("Ingrese la cantidad de preguntas de la evaluación: ");
          int cantPreguntas = Integer.parseInt(lector.readLine());
    
          for(int i=0; i<cantPreguntas; i++){
            System.out.println("Ingrese pregunta n°"+i+1);
            String pregunta = lector.readLine();
            preguntas.add(i,pregunta);
          }
  
          tipoEvaluacion nuevaEvaluacion = new tipoEvaluacion(promedio, fecha, unidad, preguntas);
          asignatura.agregarEvaluacion(nuevaEvaluacion);

          if(evalxFecha.containsKey(fecha)==false){
            tipoFecha arrayFecha = new tipoFecha();
            arrayFecha.addEva(nuevaEvaluacion);
            evalxFecha.put(fecha, arrayFecha);
          }      
          else{
           tipoFecha arrayFecha = new tipoFecha();
            evalxFecha.get(arrayFecha);
            arrayFecha.addEva(nuevaEvaluacion);
          }
          System.out.println("");
          break;
          
          //Mostrar por pantalla listado de elementos
        case 3:
          System.out.println("Ingrese la asignatura para ver sus Evaluaciones");
          String nameAsignatura = lector.readLine();
          tipoAsignatura asignatu = colegio.buscar(nameAsignatura);
          if(asignatu != null){
            asignatu.listarEvaluacionesCompleto();
          }
          else
          {
            System.out.println("La asignatura no se encuentra registrada.");
          }
          System.out.println("");
          break;

        case 4:
          colegio.listarAsignaturasYevaluaciones();
          System.out.println("");
          break;
          
        default:
          System.out.println("no se ingreso un numero valido");

        case 5:
          colegio.listarAsignaturas();
          System.out.println("");
          break;
          
      }
    }
  }
}
