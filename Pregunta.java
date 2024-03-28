
import java.util.ArrayList;

public class Pregunta{
  private String pregunta;
  private String tema;
  

  /**
   *Constructor con todos los parámetros, usado para intanciar un a pregunta con su pregunta y tema
   *@param pregunta Pregunta de la Pregunta
   *@param tema Tema de la pregunta
   */
  public Pregunta(String pregunta, String tema){
    this.pregunta = pregunta;
    this.tema = tema;
  }

  /**
   *Constructor sin parámetros, usado para instanciar una variable Pregunta
   */
  public Pregunta(){
    this.pregunta = "pepe";
  }

  /**
   *Getter, usado para obtener el elemento de pregunta
   *@return La pregunta
   */
  public String getPregunta(){
    return pregunta;
  }

  /**
   *Getter, usado para obtener el elemento de tema
   *@return El tema de la pregunta
   */
  public String getTema(){
    return tema;
  }

  /**
   *Setters, usado para establecer el elemento de respuesta esperada
   *@param pregunta El enuciado de la pregunta
   */
  public void setPregunta(String pregunta){
    this.pregunta = pregunta;
  }

  /**
  *Setters, usado para establecer el elemento de respuesta esperada
  *
  *@param El tema de la pregunta
  */
  public void setTema(String tema){
    this.tema = tema;
  }

  //Sobreescritura

  /**
   *Entrega un string con la pregunta y el tema
   *@return Todos los contenidos de la pregunta
   */
  public String contenidos(){
    return (pregunta + "\n" + "Tema: "+ tema);
  }
}
