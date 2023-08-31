import java.io.*;
import java.util.ArrayList;

public class tipoEvaluacion{
  private double promedioNotas;
  private int cantNotas;
  private String fecha;
  private String unidad;
  private ArrayList <String> preguntas;

  public tipoEvaluacion(double promedio, String fecha, string contenido, ArrayList preguntas2 ){
    promedioNotas = promedio;
    this.fecha = fecha;
    this.contenido = contenido;
    preguntas = new ArrayList();
    for(int i; i<preguntas2.size(); i++){
      preguntas.add(i, preguntas2.get(i));
    }
  }

  public String getUnidad(){
    return unidad;
  }

  public int getCantNotas(){
    return cantNotas;
  }
  
  public double getPromedio(){
    return promedioNotas;
  }
  
  public String getFecha(){
    return fecha;
  }

  public ArrayList<String> getPreguntas(){
    return preguntas;
  }

  public void anadirNotaPromedio(double notaAnadir){
    if(cantNotas==0){
      cantNotas ++;
      promedioNotas = notaAnadir;
      return;
    }
    double promedioCant = promedioNotas * cantNotas;
    promedioCant = promedioCant + notaAnadir;
    cantNotas++;
    promedioNotas = promedioCant / (cantNotas);
    return;
  }

  //Sobrecarga del método anterior en caso de pasar un int en vez de un double
  //Se casteará a double para hacer el cálculo del promedio
  public void anadirNotaPromedio(int notaAnadir){
    if(cantNotas==0){
      cantNotas ++;
      promedioNotas = (double)notaAnadir;
      return;
    }
    double promedioCant = promedioNotas * cantNotas;
    promedioCant = promedioCant + (double)notaAnadir;
    cantNotas++;
    promedioNotas = promedioCant / (cantNotas);
    return;
  }  

  public void setTotalNotas(int notastotal){
    cantNotas = notastotal;
    return;
  }
  
  public void setFecha(String fecha){
    this.fecha = fecha ;
    return;
  }

  public void setUnidad(String unidad){
    this.unidad = unidad ;
    return;
  }

  public void anadirPregunta(String pregunta){
    preguntas.add(pregunta);
  }

  public void eliminarPregunta(string pregunta){
    if(preguntas.contains(pregunta)==false){
      system.out.println("Esta pregunta no se encuentra");
      return;
    }
    else{
      preguntas.remove(preguntas.indexOf(pregunta));
    }
    return;
  }
  
  public void listarPreguntas(){
    System.out.println("Preguntas de la "+ unidad +":");
    //Hay que complementar listar ya que hay que ver bien que hay que mostrar
    for(int i = 0 ; i < preguntas.size() ; i++){
      System.out.println( (i+1) +") " + preguntas.get(i));
    }
  }
  
}