
import java.util.ArrayList;

public class Pregunta{
  private String pregunta;
  private String tema;
  
  //Constructor
  public Pregunta(String pregunta, String tema){
    this.pregunta = pregunta;
    this.tema = tema;
  }

  public Pregunta(){

  }

  //Getters
  public String getPregunta(){
    return pregunta;
  }

  public String getTema(){
    return tema;
  }

  //Setters
  public void setPregunta(String pregunta){
    this.pregunta = pregunta;
  }

  public void setTema(String tema){
    this.tema = tema;
  }

  //Sobreescritura
  public String contenidos(){
    return (pregunta + "\n" + "Tema: "+ tema);
  }
}
