public class Nota{
  private double nota;
  private String alumno;

  //Constructor
  public Nota (double nota, String alumno){
    this.nota = nota;
    this.alumno = alumno;
  }

  public Nota (){
  }

  //Setters
  public void setNota(double nota){
    this.nota = nota;
  }

  public void setAlumno(String alumno){
    this.alumno = alumno;
  }

  //Getters
  public double getNota(){
    return nota;
  }
  
  public String getNotaString(){
    String notaString = String.valueOf(nota);
    return notaString;
  }
  
  public String getAlumno(){
    return alumno;
  }
}