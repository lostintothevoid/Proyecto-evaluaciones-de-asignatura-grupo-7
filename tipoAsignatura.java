import java.util.ArrayList;
// returns no necesarios segun netbeans marcados con **
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
    //**
    return;
  }

  public int getCantEvaluaciones(){
    return cantEvaluaciones;
  }

  public void setCantEvaluaciones(int cantEvaluaciones){
    this.cantEvaluaciones = cantEvaluaciones;
    //**
    return;
  }

  public void setCantEvaluaciones(double cantEvaluaciones){
    this.cantEvaluaciones = (int)cantEvaluaciones;
    //**
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
    
    if(evaluacion == null) return false;
    
    //Si pasa el if anterior significa que la asignatura no existe por lo tanto se agrega
    evaluaciones.add(evaluacion);
    cantEvaluaciones++;
    
    return true;
  }

  public void eliminarEvaluacion (tipoEvaluacion eva){   
    if (eva == null){
      System.out.println("La evaluación no existe");
      //**
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

    if(evaluaciones.isEmpty()){
      System.out.println("La asignatura" + this.nombreAsignatura + "no posee evaluaciones registradas");
      return;
    }
    
    System.out.println("Evaluaciones de " + this.nombreAsignatura +":");
    //Hay que complementar listar ya que hay que ver bien que hay que mostrar
    for(int i = 0; i < evaluaciones.size(); i++){
      //tipoEvaluacion evaluacion = evaluaciones.get(i);
      //String unidad = evaluacion.getUnidad();
      System.out.println(evaluaciones.get(i).getUnidad());
    }
  }

  public void listarEvaluacionesCompleto(){
    if(evaluaciones.isEmpty()){
      System.out.println("La asignatura" + this.nombreAsignatura + "No posee evaluaciones registradas");
      return;
    }
    
    System.out.println("Evaluaciones de " + this.nombreAsignatura +":");
    //Hay que complementar listar ya que hay que ver bien que hay que mostrar
    for(int i = 0; i < evaluaciones.size(); i++){
      System.out.println("Unidad: " + evaluaciones.get(i).getUnidad() + " | Fecha: " + evaluaciones.get(i).getFecha() + " | Promedio:  " + evaluaciones.get(i).getPromedio());
      ArrayList <String> preguntas = evaluaciones.get(i).getPreguntas();
      if(preguntas.isEmpty() == false){
        for(int j = 0 ; j < preguntas.size() ; j++){
          System.out.println("- " + preguntas.get(j));
        }
        System.out.println("");
      }
    }
    
  }
}


































