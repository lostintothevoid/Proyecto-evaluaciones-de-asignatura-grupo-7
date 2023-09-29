import java.util.ArrayList;

public class Evaluacion{
  private String fecha;
  private String unidad;
  private String asignatura; 
  private ArrayList <Nota> notas;
  private ArrayList <Pregunta> preguntas;

  //Constructor, recibe todos los parámetros
  //???
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

  public Evaluacion(String unidad,String asignatura, String fecha){
    this.fecha = fecha;
    this.unidad = unidad;
    this.asignatura = asignatura;
    
    preguntas = new ArrayList();

    notas = new ArrayList();
  }

  public Evaluacion(){
    preguntas = new ArrayList();
    notas = new ArrayList();
  }

  //Getters
  public String getUnidad(){
    return unidad;
  }
  
  public String getFecha(){
    return fecha;
  }
  
  public String getAsignatura(){
    return asignatura;
  }

  //??
  public ArrayList<Pregunta> getPreguntas(){
    ArrayList <Pregunta> aux = (ArrayList <Pregunta>) preguntas.clone();
    return aux;
  }

  public ArrayList<Nota> getNotas(){
    ArrayList <Nota> aux = (ArrayList <Nota>) notas.clone();
    return aux;
  }

  //Setters  
  public void setFecha(String fecha){
    this.fecha = fecha;
  }

  public void setUnidad(String unidad){
    this.unidad = unidad;
  }

  public void setAsignatura(String asignatura){
    this.asignatura = asignatura;
  }

  //Extras nota
  public void anadirNota(Nota nn){
    notas.add(nn);
  }

  public boolean eliminarNota(String alumno){
    for(int i=0 ; i < notas.size(); i++){
      Nota notaAct = notas.get(i);
      if(notaAct.getAlumno().equals(alumno)){
        notas.remove(notaAct);
        return true;
      }
    }
    return false;
  }

  public double promedioEvaluacion(){
    int cantNotas = notas.size();
    double suma = 0;
    if(cantNotas == 0){
      return 0;
    }
    for(int i = 0; i < cantNotas; i++){
      Nota nn = (Nota)notas.get(i);
      suma = suma + nn.getNota();
    }
    return suma/cantNotas;
  }

  public Nota buscarNota(String alumno){
    for(int i = 0; i < notas.size(); i++){
      Nota nota = notas.get(i);
      if(nota.getAlumno().equals(alumno)){
        return nota;
      }
    }
    return null;
  }

  //Extras pregunta

  //??
  public void anadirPregunta (Pregunta pregunta){
    preguntas.add(pregunta);
  }

  //??
  public boolean eliminarPregunta (String pregunta){
    if(preguntas.contains(pregunta)==false){
      //System.out.println("Esta pregunta no se encuentra");
      
      return false;
    }
    else{
      preguntas.remove(preguntas.indexOf(pregunta));
    }
    return true;
  }

  //??
  public Pregunta buscarPregunta(String pregunta){
    for(int i = 0; i < preguntas.size(); i++){
      Pregunta pp = preguntas.get(i);
           
      if(pp.getPregunta().equals(pregunta)){
        return pp;
      }
    }
    return null;
  }  

}