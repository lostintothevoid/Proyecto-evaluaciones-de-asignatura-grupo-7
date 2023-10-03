/**
 * La clase Nota representa una nota con un valor y un alumno.
 */

public class Nota{
  private double nota;
  private String alumno;

  //Constructores
  /**
  *constructor con los atributos de nota y alumno.
  *@param nota El valor de la nota.
  *@param alumno El alumno de la nota.
  */

  //Constructor con todos los parámetros
  public Nota (double nota, String alumno){
    this.nota = nota;
    this.alumno = alumno;
  }
    
  /**
   * Constructor de Nota sin parámetros.
   */

  //Constructor sin parámetros
  public Nota (){
  }

  /**
   * Establece el valor de la nota.
   * @param nota El nuevo valor de la nota.
   */

  //Setters
  public void setNota(double nota){
    this.nota = nota;
  }

  /**
   * Establece el alumno de la nota.
   * @param alumno El nuevo alumno de la nota.
   */
  
  public void setAlumno(String alumno){
    this.alumno = alumno;
  }

  /**
   * Obtiene el valor de la nota.
   * @return El valor de la nota.
   */
  
  //Getters
  public double getNota(){
    return nota;
  }

  /**
   * Obtiene la nota como un string.
   * @return La nota como un string.
   */

  //Este método se utiliza para obtener la nota como un string
  public String getNotaString(){
    String notaString = String.valueOf(nota);
    return notaString;
  }

  /**
   * Obtiene el alumno de la nota.
   * @return El alumno de la nota.
   */
  
  public String getAlumno(){
    return alumno;
  }
}