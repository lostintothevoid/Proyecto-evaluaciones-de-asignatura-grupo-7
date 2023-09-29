
import java.util.ArrayList;

public class PreguntaDesarrollo extends Pregunta{
  private String respEsperada;

  //Constructor
  public PreguntaDesarrollo(String pregunta, String tema, String respEsperada){
    super(pregunta, tema);
    this.respEsperada = respEsperada;
  }

  public PreguntaDesarrollo(){
    super();
  }

  //Getters
  public String getRespEsperada(){
    return respEsperada;
  }

  //Setters
  public void setRespEsperada(String respEsperada){
    this.respEsperada = respEsperada;
  }

  //Sobreescritura
  public String contenidos(){
    return (getPregunta() + "\n" + "Tema: "+ getTema() + "\n" + "Respuesta Esperada: "+ respEsperada);
  }
  
  
}
