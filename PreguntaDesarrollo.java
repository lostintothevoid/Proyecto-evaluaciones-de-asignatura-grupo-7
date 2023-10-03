
import java.util.ArrayList;

public class PreguntaDesarrollo extends Pregunta{
  private String respEsperada;


  /**
   *Constructor con todos los parámetros, usado para intanciar un a pregunta de desarrollo con su pregunta, tema y respuesta esperada
   *
   *@param pregunta Pregunta de la Pregunta de desarrollo
   *@param tema Tema de la pregunta
   *@param respEsperada Respuesta ideal para la pregunta
   */
  public PreguntaDesarrollo(String pregunta, String tema, String respEsperada){
    super(pregunta, tema);
    this.respEsperada = respEsperada;
  }

  /**
   *Constructor sin parámetros, usado para instanciar una variable PreguntaDesarrollo
   */
  public PreguntaDesarrollo(){
    super();
  }

  /**
   *Getter, usado para obtener el elemento de respuesta esperada
   *
   *@return Respuesta esperada a la pregunta
   */
  public String getRespEsperada(){
    return respEsperada;
  }

  /**
   *Setters, usado para establecer el elemento de respuesta esperada
   *
   *@param respEsperada La respuesta esperada
   */
  public void setRespEsperada(String respEsperada){
    this.respEsperada = respEsperada;
  }

  //Sobreescritura
  //@Override
  /**
   *Entrega un string con todos los contenidos de una pregunta de desarrollo
   *@return Todos los contenidos de la pregunta
   */
  public String contenidos(){
    return ("Pregunta: " + getPregunta() + "\n" + "Tema: "+ getTema() + "\n" + "Respuesta Esperada: "+ respEsperada + "\n");
  }
}