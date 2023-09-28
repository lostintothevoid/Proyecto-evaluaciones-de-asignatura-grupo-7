import java.util.ArrayList;

public class Pregunta{
  private String pregunta;
  private String tema;
  private String altCorrecta;
  private ArrayList <String> alternativas;
  
  //Constructor
  public Pregunta(String pregunta, String tema, ArrayList <String> alternativas2, String altCorrecta){
    this.pregunta = pregunta;
    this.tema = tema;
    this.altCorrecta = altCorrecta;
    
    alternativas = new ArrayList();
    for(int i = 0; i < alternativas2.size(); i++){
      String alter = alternativas2.get(i);
      alternativas.add(i, alter);
    }
  }
  
  public Pregunta(String pregunta, String tema){
    this.pregunta = pregunta;
    this.tema = tema;
    alternativas = new ArrayList();
  }

  public Pregunta(){
    alternativas = new ArrayList();
  }

  //Getters
  public String getPregunta(){
    return pregunta;
  }

  public String getTema(){
    return tema;
  }

  public String getAltCorrecta(){
    return altCorrecta;
  }

  public ArrayList<String> getAlternativas(){
    ArrayList<String> aux = (ArrayList<String>) alternativas.clone();
    return aux;
  }

  //Setters
  public void setPregunta(String pregunta){
    this.pregunta = pregunta;
  }

  public void setTema(String tema){
    this.tema = tema;
  }

  public void setAltCorrecta(String altCorrecta){
    this.altCorrecta = altCorrecta;
  }

  public void setAlternativa(String alter, int index){
    alternativas.set(index, alter);
  }
  
  public void agregarAlternativas(ArrayList<String> alternativas2, String altCorrecta){
    alternativas = (ArrayList<String>) alternativas2.clone();
    this.altCorrecta = altCorrecta;
  }

  public boolean confirmarAlternativa(String alt){
    for(int i = 0; i < alternativas.size(); i++){
      String aux = alternativas.get(i);
      if(aux.equals(alt)){
        return true;
      }
    }
    return false;
  }
}