import java.io.*;
import java.util.ArrayList;

public class tipoAsignatura{
  private String nombreAsignatura;
  private ArrayList <tipoEvaluaciones> evaluaciones; 
  private int cantEvaluaciones;
  
  public tipoAsignatura(String nombre, int tamano){
    nombreAsignatura = nombre;
    cantEvaluaciones = tamano;
    evaluaciones = new ArrayList();
  }
  public String getNombre(){
    return nombreAsignatura;
  }

  public void setNombre(String nuevoNombre){
    nombreAsignatura.nombre=nuevoNombre;
    return;
  }

  public int getEvaluaciones(){
    return cantEvaluaciones;
  }

  public tipoEvaluacion buscar(String nombre){
    // condicion la cual verificar si el ArrayList se encuentra vacio
    if(evaluaciones.isEmpty()== true){
      return null;
    }
    //:D
    if(evaluaciones.contains(nombre) == true){
      return evaluaciones.get(evaluaciones.indexOf(nombre));
    }
    // por ultimo de no encontrar nada en el proceso por defecto retornara null
    return null;
  }
  
  public bool agregarEvaluacion(tipoEvaluacion evaluacion){
    //Si la asignatura no se encuentra o el arreglo esta vacio se devuelve un false
    tipoEvaluacion eva = buscar(evaluacion.getNombre());
    if(eva != null) return false;
    
    //Si pasa el if anterior significa que la asignatura no existe por lo tanto se agrega
    evaluaciones.add(evaluacion);
    //mapaAsignaturas.put(asignatura.getNombre(),asignatura);
    return true;
  }

  public void eliminar (tipoEvaluacion eva){   
    if (eva == null){
      System.out.println("La evaluación no existe");
      return;
    }
    else{
      //Busco en el ArrayList
      for(int i=0; i < evaluaciones.size(); i++){
        if(evaluaciones.get(i) == eva){
          //Se elimina del ArrayList
          evaluaciones.remove(i);
          //mapaAsignaturas.remove(nombre);
          System.out.println("La evaluacion ha sido borrada con exito");
          return;
        }
      }
    }
  }

  
  public void listarEvaluaciones(){
    System.out.println("Evaluaciones de " + nombreAsignatura +":");
    //Hay que complementar listar ya que hay que ver bien que hay que mostrar
    for(int i = 0; i < evaluaciones.size(); i++){
      System.out.println(evaluaciones.get(i).getNombre());
    }
  }
}