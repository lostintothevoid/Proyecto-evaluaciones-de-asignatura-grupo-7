import java.util.ArrayList;

/**
 *La clase Evaluacion representa una evaluacion con una unidad, fecha, asignatura, notas y preguntas.
 */
public class Evaluacion{
  private String unidad;
  private String fecha;
  private String asignatura; 
  private ArrayList <Nota> notas;
  private ArrayList <Pregunta> preguntas;
  /**
   *Constructor de Evaluacion que recibe todos los parametros.
   * @param asignatura La asignatura de la evaluación.
   * @param fecha La fecha de la evaluación.
   * @param notas2 Las notas de la evaluación.
   * @param preguntas2 Las preguntas de la evaluación.
   */
  public Evaluacion(String unidad,String asignatura, String fecha, ArrayList <Nota> notas2, ArrayList <Pregunta> preguntas2){
    this.fecha = fecha;
    this.unidad = unidad;
    this.asignatura = asignatura;
    
    preguntas = new ArrayList();
    for(int i=0; i < preguntas2.size(); i++){
      Pregunta preguntaAnadir = preguntas2.get(i);
      preguntas.add(i, preguntaAnadir);
    }
    
    notas = new ArrayList();
    for(int i=0; i < notas2.size(); i++){
      Nota notaAnadir = notas2.get(i);
      notas.add(i, notaAnadir);
    }
  }
 
  /**
   *Constructor de Evaluacion solo con atributos sin colecciones.
   *@param unidad de la evaluacion
   *@param asignatura la asignatura de la evaluacion.
   *@param fecha
   */
  public Evaluacion(String unidad,String asignatura, String fecha){
    this.fecha = fecha;
    this.unidad = unidad;
    this.asignatura = asignatura;
    
    preguntas = new ArrayList();

    notas = new ArrayList();
  }
 
  /**
   * Constructor de Evaluacion sin parámetros.
   */
  public Evaluacion(){
    preguntas = new ArrayList();
    notas = new ArrayList();
  }

  /**
   * Añade una pregunta a la evaluación.
   * @param pregunta La pregunta a añadir.
   */
  public void anadirPregunta (Pregunta pregunta){
    preguntas.add(pregunta);
  }
  /**
   * Elimina una pregunta de la evaluación.
   * @param pregunta La pregunta a eliminar.
   * @return Verdadero si la pregunta fue eliminada, falso en caso contrario.
   */

  public boolean eliminarPregunta (String pregunta){
    //Si la pregunta está en el ArrayList de preguntas, se elimina, en caso contrario retorna false.
    if(preguntas.contains(pregunta)==false){
      return false;
    }
    else{
      preguntas.remove(preguntas.indexOf(pregunta));
    }
    return true;
  }
  /**
   * Busca una pregunta en la evaluación.
   * @param pregunta La pregunta a buscar.
   * @return La pregunta si se encuentra, null en caso contrario.
   */

  public Pregunta buscarPregunta(String pregunta){
    //Si la encuentra en la evaluación, la retorna, sino retorna null
    for(int i = 0; i < preguntas.size(); i++){
      Pregunta pp = preguntas.get(i);
           
      if(pp.getPregunta().equals(pregunta)){
        return pp;
      }
    }
    return null;
  }
 
  /**
   * Añade una nota a la evaluacion.
   * @param nn La nota a añadir.
   * @return Verdadero si la nota fue añadida, falso en caso contrario.
   */
  public boolean anadirNota(Nota nn){
    if(notas.contains(nn)){
      return false;
    }
    else{
      notas.add(nn);
      return true;
    }
    
  }
  /**
   * Elimina una nota de la evaluación.
   * @param alumno El alumno de la nota a eliminar.
   * @return Verdadero si la nota fue eliminada, falso en caso contrario.
   */

  public boolean eliminarNota(String alumno){
    //Elimina una nota, en caso de no encontrarla retorna false, sino la elimina y retorna true
    for(int i=0 ; i < notas.size(); i++){
      Nota notaAct = notas.get(i);
      if(notaAct.getAlumno().equals(alumno)){
        notas.remove(notaAct);
        return true;
      }
    }
    return false;
  }

  /**
   * Calcula el promedio de las notas de una evaluacion.
   * @return El promedio de las notas.
   */
  public double promedioEvaluacion(){
    //Se promedian las notas del ArrayList de notas, si no hay notas retorna 0.
    int cantNotas = notas.size();
    double suma = 0;
    if(cantNotas == 0){
      return 0;
    }
    for(int i = 0; i < cantNotas; i++){
      Nota nn = (Nota)notas.get(i);
      suma = suma + nn.getNota();
    }
    
    return Math.round(suma/cantNotas*10.0)/10.0;
  }
  /**
   * Busca una nota en la evaluación.
   * @param alumno El alumno de la nota a buscar.
   * @return La nota si se encuentra, null en caso contrario.
   */
  public Nota buscarNota(String alumno){
    //En caso de encontrar la nota la retorna, sino retorna null.
    for(int i = 0; i < notas.size(); i++){
      Nota nota = notas.get(i);
      if(nota.getAlumno().equals(alumno)){
        return nota;
      }
    }
    return null;
  }

  /**
   * Getter de unidad.
   * @return La unidad de la evaluación.
   */
  public String getUnidad(){
    return unidad;
  }
  
  /**
   * Getter de fecha.
   * @return La fecha de la evaluación.
   */
  public String getFecha(){
    return fecha;
  }

  /**
   * Getter de asignatura.
   * @return La asignatura de la evaluación.
   */
  public String getAsignatura(){
    return asignatura;
  }

  /**
   * Getter de un clon de las preguntas de la evaluación.
   * @return Las preguntas de la evaluación.
   */
  public ArrayList<Pregunta> getPreguntas(){
    ArrayList <Pregunta> aux = (ArrayList <Pregunta>) preguntas.clone();
    return aux;
  }

  /**
   * Getter de un clon de las notas de la evaluación.
   * @return Las notas de la evaluación.
   */
  public ArrayList<Nota> getNotas(){
    ArrayList <Nota> aux = (ArrayList <Nota>) notas.clone();
    return aux;
  }

  /**
   * Setter de la fecha de la evaluación.
   * @param fecha La nueva fecha.
   */  
  public void setFecha(String fecha){
    this.fecha = fecha;
  }

  /**
   * Setter de la unidad de la evaluación.
   * @param unidad La nueva unidad.
   */
  public void setUnidad(String unidad){
    this.unidad = unidad;
  }

  /**
   * Setter de la asignatura de la evaluación.
   * @param asignatura La nueva asignatura.
   */
  public void setAsignatura(String asignatura){
    this.asignatura = asignatura;
  }
}