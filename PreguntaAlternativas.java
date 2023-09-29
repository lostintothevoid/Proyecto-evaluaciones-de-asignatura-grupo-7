
import java.util.ArrayList;

public class PreguntaAlternativas extends Pregunta{
  private char altCorrecta;
  private ArrayList <String> alternativas;
  
  //Constructor
  public PreguntaAlternativas(String pregunta, String tema, ArrayList <String> alternativas2, char altCorrecta){
    super(pregunta, tema);
    this.altCorrecta = altCorrecta;
    
    alternativas = new ArrayList();
    for(int i = 0; i < alternativas2.size(); i++){
      String alter = alternativas2.get(i);
      alternativas.add(i, alter);
    }
  }
  
  public PreguntaAlternativas(String pregunta, String tema){
    super(pregunta, tema);
    alternativas = new ArrayList();
  }

  public PreguntaAlternativas(){
    super();
    alternativas = new ArrayList();
  }

  //Getters
  public char getAltCorrecta(){
    return altCorrecta;
  }

  public ArrayList<String> getAlternativas(){
    ArrayList<String> aux = (ArrayList<String>) alternativas.clone();
    return aux;
  }

  //Setters
  public void setAltCorrecta(char altCorrecta){
    this.altCorrecta = altCorrecta;
  }

  public void setAlternativa(String alter, int index){
    alternativas.set(index, alter);
  }
  
  public void setAlternativa(String alter){
    alternativas.add(alter);
  }

  //Extra Alternativas
  
  public void agregarAlternativas(ArrayList<String> alternativas2, char altCorrecta){
    alternativas = (ArrayList<String>) alternativas2.clone();
    this.altCorrecta = altCorrecta;
  }

  /*
  public boolean confirmarAlternativa(char alt){
    int i = 0;
    for (char letra = 'a'; letra <= 'z'; letra++, i++) {
      if(letra == alt){

      }
    }
    for(int i = 0; i < alternativas.size(); i++){
      String aux = alternativas.get(i);
      if(aux.equals(alt)){
        return true;
      }
    }
    return false;
  }
  */
  
  //Sobreescritura
  public String contenidos(){
    String cont = (getPregunta() + "\n" + "Tema: " + getTema() + "\n" + "Alternativa correcta: " + altCorrecta);
    ArrayList<Character> letrasArray = new ArrayList<>();
    for (char letra = 'a'; letra <= 'z'; letra++) {
      letrasArray.add(letra);
    }
    for(int i = 0; i < alternativas.size(); i++){
      cont = cont + "\n" + letrasArray.get(i) + alternativas.get(i);
    }
    return cont;
  }
}
