import java.io.*;
import java.util.ArrayList;

public class tipoAsignatura{
  private String nombreAsignatura;
  private ArrayList < tipoEvaluacion > evaluaciones; 
  private int cantEvaluaciones;
  
  public tipoAsignatura(String nombre){
    nombreAsignatura = nombre;
    cantEvaluaciones = 0;
    evaluaciones = new ArrayList();
  }
  
  public String getNombre(){
    return nombreAsignatura;
  }

  public void setNombre(String nuevoNombre){
    nombreAsignatura=nuevoNombre;
    return;
  }

  public int getCantEvaluaciones(){
    return cantEvaluaciones;
  }

  public void setCantEvaluaciones(int cantEvaluaciones){
    this.cantEvaluaciones = cantEvaluaciones;
    return;
  }

  public tipoEvaluacion buscarEvaluacion(String nombre){
    // condicion la cual verificar si el ArrayList se encuentra vacio
    if(evaluaciones.isEmpty()== true){
      return null;
    }
    //:D

    //CAMBIAR ESTO Y QUIZAS AÑADIR UN MAPA
    
    if(evaluaciones.contains(nombre) == true){
      return evaluaciones.get(evaluaciones.indexOf(nombre));
    }
    // por ultimo de no encontrar nada en el proceso por defecto retornara null
    return null;
  }
  
  public boolean agregarEvaluacion(tipoEvaluacion evaluacion){
    //Si la asignatura no se encuentra o el arreglo esta vacio se devuelve un false
    if(evaluaciones.indexOf(evaluacion) != -1) return false;
    
    if(eva != null) return false;
    
    //Si pasa el if anterior significa que la asignatura no existe por lo tanto se agrega
    evaluaciones.add(evaluacion);
    cantEvaluaciones++;
    
    return true;
  }

  public void eliminarEvaluacion (tipoEvaluacion eva){   
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
//listado de evaluaciones
  public void listarEvaluaciones(){
    System.out.println("Evaluaciones de " + this.nombreAsignatura +":");
    //Hay que complementar listar ya que hay que ver bien que hay que mostrar
    for(int i = 0; i < evaluaciones.size(); i++){
      System.out.println(evaluaciones.get(i).getUnidad());
    }
  }
}