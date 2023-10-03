
import java.util.ArrayList;

public class PreguntaAlternativas extends Pregunta{
  private char altCorrecta;
  private ArrayList <String> alternativas;
  
  /**
   *Constructor con todos los parámetros, usado para intanciar un a pregunta de alternativas con su pregunta, tema, alternativas y respuesta correcta
   *
   *@param pregunta Pregunta de la Pregunta de alternativas
   *@param tema Tema de la pregunta
   *@param alternativas2 Conjunto de alternativas de la pregunta
   *@param altCorrecta Letra de la alternativa correcta
   */
  public PreguntaAlternativas(String pregunta, String tema, ArrayList <String> alternativas2, char altCorrecta){
    super(pregunta, tema);
    this.altCorrecta = altCorrecta;
    
    alternativas = new ArrayList();
    for(int i = 0; i < alternativas2.size(); i++){
      String alter = alternativas2.get(i);
      alternativas.add(i, alter);
    }
  }

  /**
   *Constructor que solo registra la pregunta y el tema e inicializa el ArrayList vacío
   *
   *@param pregunta Pregunta de la Pregunta de Alternativas
   *@param tema Tema de la pregunta
   */
  public PreguntaAlternativas(String pregunta, String tema){
    super(pregunta, tema);
    alternativas = new ArrayList();
  }

  /**
   *Constructor sin parámetros que inicializa ArrayList e instancia una variable PreguntaAlternativas
   */
  public PreguntaAlternativas(){
    super();
    alternativas = new ArrayList();
  }

  /**
   *Getter, usado para obtener la alternativa correcta
   *
   *@return Letra de la alternativa correcta
   */
  public char getAltCorrecta(){
    return altCorrecta;
  }

  /**
   *Entega una copia del ArrayList de alternativas
   *
   *@return Conjunto de alternativas
   */
  public ArrayList<String> getAlternativas(){
    ArrayList<String> aux = (ArrayList<String>) alternativas.clone();
    return aux;
  }

  /**
   *Setter usado para asignar la alternativa correcta
   *
   *@param altCorrecta Letra de la alternativa correcta
   */
  public void setAltCorrecta(char altCorrecta){
    this.altCorrecta = altCorrecta;
  }

  /**
   *Agrega alternativas a un índice específico del ArrayList para reemplazar una anterior
   *
   *@param alter Una alternativa
   *@param index el índice de la alternativa que reemplaza
   */
  public void setAlternativa(String alter, int index){
    alternativas.set(index, alter);
  }

  /**
   *Agrega alternativas al ArrayList
   *
   *@param alter Una alternativa
   */
  public void setAlternativa(String alter){
    alternativas.add(alter);
  }


  //Sobreescritura
  //@Override
  /**
   *Entrega un string con todos los contenidos de una pregunta de alternativas
   *
   *@return Todos los contenidos de la pregunta
   */
  public String contenidos(){
    String cont = ("Pregunta :" + getPregunta() + "\n" + "Tema: " + getTema());
    ArrayList<Character> letrasArray = new ArrayList<>();
    for (char letra = 'a'; letra <= 'z'; letra++) {
      letrasArray.add(letra);
    }
    for(int i = 0; i < alternativas.size(); i++){
      cont = cont + "\n" + letrasArray.get(i) + ") " + alternativas.get(i);
    }

    cont = (cont + "\n" + "Alternativa correcta: " + altCorrecta + "\n");
    return cont;
  }
}
