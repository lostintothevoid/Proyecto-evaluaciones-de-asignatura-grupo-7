import java.util.ArrayList;
import java.util.HashMap;

//primera coleccion A
public class Colegio{
  private ArrayList <Evaluacion> arrayEvaluaciones;
  private HashMap <String, Evaluacion> mapaEvaluaciones;

  /**
   * Constructor de Colegio que Inicializa los parámetros.
   */  
  public Colegio(){
    arrayEvaluaciones = new ArrayList();
    mapaEvaluaciones = new HashMap();
  }

  
  /**
   * Método que busca una evaluación
   * @param nomUnidad Unidad de la evaluación a buscar
   * @return Evaluación buscada
   * @throws EvaluacionNotFoundException Error de evaluación no encontrada.
   */
  public Evaluacion buscarEvaluacion(String nomUnidad) throws EvaluacionNotFoundException{

    //Se revisa si el mapa contiene la evaluación, lo cual es lo más útil y rápido.
    if(mapaEvaluaciones.containsKey(nomUnidad) == true){
      //Si lo contiene, lo retorna.
      return mapaEvaluaciones.get(nomUnidad);
    }
    else{
      //En caso contrario lanza una excepción de una clase creada por nosotros que indica que la evaluación no se encontró.
      throw new EvaluacionNotFoundException();
    }
    // por ultimo de no encontrar nada en el proceso por defecto retornara null
    //return null;
  }


  /**
   * Méteodo que Busca todas las evaluaciones de una asignatura
   * @param asignatura Asignatura de las evaluaciones que se quieren mostrar.
   * @return ArrayList de evaluaciones que corresponden a esa asignatura.
   */
  public ArrayList <Evaluacion> buscarEvaluacionAsignatura(String asignatura){
    
    ArrayList <Evaluacion> aux = new ArrayList();
    //Revisa en el ArrayList de evaluaciones si es que hay evaluaciones de esa asignatura en específico.
    for(int i = 0; i < arrayEvaluaciones.size(); i++){
      Evaluacion ee = arrayEvaluaciones.get(i);
      if(ee.getAsignatura().equals(asignatura)){
        //Si es que hay, se agregan a un ArrayList con las evaluaciones de esa asignatura para retornarlo.
        aux.add(ee);
      }
    }

    //Realiza un try-catch para atrapar la excepción en caso de que no hayan evaluaciones de esa asignatura
    //(SinEvaluacionesException)
    try{
      hayEvaluaciones(arrayEvaluaciones);
      return aux;
    }catch(SinEvaluacionesException e){
      return null;
    }
    
  }

  
  /**
   * Método que Agrega una Evaluación.
   * @param ee Evaluación a agregar.
   * @return Verdadero si se agregó, falso en caso contrario.
   */
  public boolean agregarEvaluacion(Evaluacion ee){
    //Se recibe la evaluación, en caso de que no se encuentre se atrapa
    //la excepción y se añade al ArrayList y al HashMap
    //Si la asignatura se encuentra se devuelve un false
    //Si se añade retorna true
    try{
      Evaluacion aux = buscarEvaluacion(ee.getUnidad());
      return false;
    }catch (EvaluacionNotFoundException e){
      arrayEvaluaciones.add(ee);
      mapaEvaluaciones.put(ee.getUnidad(),ee);
      return true;
    }
    
  }

  /**
  * Método que Elimina una evaluacion
  * @param unidad Unidad de evaluación a eliminar.
  * @return Verdadero si se eliminó, falso en caso contrario.
  */
  public boolean eliminarEvaluacion(String unidad){
    //Se busca la evaluación y en caso de encontrarla se elimina
    //Sino se captura a la excepción de que no se encontró la evaluación y retorna false.
    Evaluacion ee = new Evaluacion();
    try{
       ee = buscarEvaluacion(unidad);
    }catch (EvaluacionNotFoundException e){
      return false;
    }
      //Busco en el ArrayList de Evaluacioens
    for(int i = 0; i < arrayEvaluaciones.size(); i++){
      Evaluacion eva = arrayEvaluaciones.get(i);
      if(eva.getUnidad().equals(unidad)){
        //Se elimina del ArrayList y del HashMap
        arrayEvaluaciones.remove(i);
        mapaEvaluaciones.remove(eva.getUnidad());
        return true;
      }
    }
    
    return false;
  }

  
  /**
   * Sobrecarga para eliminar una evaluacion
   * @param vieja Unidad de evaluación antigua para eliminar de HashMap.
   * @param nueva Unidad de evaluación para eliminar en ArrayList.
   */
  public void eliminarEvaluacion(String vieja,String nueva){
    //Se busca la evaluación en el ArrayList por la nueva unidad, al encontrarla se elimina
    //del ArrayLis y del mapa con la vieja unidad.
    for(int i = 0; i < arrayEvaluaciones.size(); i++){
      Evaluacion eva = arrayEvaluaciones.get(i);
      if(eva.getUnidad().equals(nueva)){
        arrayEvaluaciones.remove(i);
        mapaEvaluaciones.remove(vieja);
        return;
      }
    }
    
  }

  /**
   * Método que Elimina una pregunta
   * @param pregunta pregunta a eliminar.
   * @return Verdadero si se eliminó, falso en caso contrario.
   */
  public boolean eliminarPregunta(String pregunta){
    //Se busca la pregunta en las evaluaciones, cuando se encuentre en una evaluación
    //la elimina y retorna true, en caso contrario retorna false.
    for(int i = 0; i < arrayEvaluaciones.size(); i++){
      Evaluacion eva = arrayEvaluaciones.get(i);
      Pregunta preg = eva.buscarPregunta(pregunta);
      if(preg != null){
        eva.eliminarPregunta(pregunta);
        return true;
      }
    }
    return false;
  }

  
  /**
   * Método que Agrega una pregunta.  
   * @param pregunta pregunta a añadir.
   * @param ee Evaluación a la que se agrega la pregunta.
   * @return Verdadero si se añadió, falso en caso contrario.
   */
  public boolean anadirPregunta(Pregunta pregunta, Evaluacion ee){
    //Busca la pregunta y si está repetida no la añade, en caso contrario si.
    Pregunta pregunta2 = ee.buscarPregunta(pregunta.getPregunta()); 
    if(pregunta2 !=null){
      return false;
    }
    else{
      ee.anadirPregunta(pregunta);
      return true;
    }
    
  }

  /**
   * Método que verifica si hay evaluaciones.
   * @param ee ArrayList de evaluaciones.
   * @return Verdadero si no está vacío, falso en caso contrario.
   * @throws SinEvaluacionesException Error de que no hay evaluaciones.
   */
  public boolean hayEvaluaciones(ArrayList <Evaluacion> ee)throws SinEvaluacionesException{
    //En caso de que hayan evaluaciones, retorna true, en caso contrario
    //Lanza una excepción creada en otra clase para señalar que no hay evaluaciones.
    
    if(ee.isEmpty()!=true){
      return true;
    }
    else{
      throw new SinEvaluacionesException();
    }
  }

  /**
   * Método que inicializa datos, es ocupado solo una vez ya que luego se quedan guardados en el csv "Datos".
   */
  public void datosIniciales(){
    
    Evaluacion eva1 = new Evaluacion("Limites", "Matematicas", "12-06-2022");
    agregarEvaluacion(eva1);
    
    ArrayList <String> alternativas11= new ArrayList();
    alternativas11.add("El límite de la función a medida que la variable se aproxima a ese punto desde valores menores a dicho punto.");
    alternativas11.add("El límite de la función a medida que la variable se aproxima a ese punto desde valores mayores a dicho punto.");
    alternativas11.add("El límite de la función a medida que la variable se aproxima a ese punto desde ambos lados, pero sin incluir el punto.");
    alternativas11.add("El límite de la función a medida que la variable se aproxima a ese punto desde ambos lados, incluyendo el punto.");
    char altCorrecta11 = 'b';
    
    PreguntaAlternativas pregunta11 = new PreguntaAlternativas("¿Cómo se define el límite lateral derecho de una función en un punto específico?", "Limites Laterales", alternativas11, altCorrecta11);
    eva1.anadirPregunta(pregunta11);
    
    
    ArrayList<String> alternativas12 = new ArrayList<>();
    alternativas12.add("La función debe ser continua en ese punto.");
    alternativas12.add("La función debe ser derivable en ese punto.");
    alternativas12.add("La función debe estar definida en ese punto.");
    alternativas12.add("La función debe ser acotada en ese punto.");
    char altCorrecta12 = 'c';

    PreguntaAlternativas pregunta12 = new PreguntaAlternativas("¿Qué condiciones deben cumplirse para que una función tenga límite lateral derecho en un punto?", "Limites Laterales", alternativas12, altCorrecta12);
    eva1.anadirPregunta(pregunta12);
    
    PreguntaDesarrollo pregunta13 = new PreguntaDesarrollo(" ¿Qué representa el límite de una función en un punto específico?", "Límites en Cálculo", "El límite de una función en un punto representa hacia dónde tiende la función a medida que la variable se acerca a ese punto.");
    eva1.anadirPregunta(pregunta13);
    
    Nota nota11 = new Nota(3.0, "Alex");
    Nota nota12 = new Nota(4.4, "Javier");
    Nota nota13 = new Nota(5.7, "Roberto");
    eva1.anadirNota(nota11);
    eva1.anadirNota(nota12);
    eva1.anadirNota(nota13);

    // Evaluación de Lenguaje
    Evaluacion evaLenguaje = new Evaluacion("Análisis del Lenguaje", "Lenguaje", "12-06-2022");
    
    // Pregunta de desarrollo
    PreguntaDesarrollo preguntaLenguaje1 = new PreguntaDesarrollo("Escribe un poema relacionado con la naturaleza.", "Poesía", "Escribe aquí tu poema sobre la naturaleza.");
    evaLenguaje.anadirPregunta(preguntaLenguaje1);
    
    // Pregunta de alternativas
    ArrayList<String> alternativasLenguaje2 = new ArrayList<>();
    alternativasLenguaje2.add("Sujeto");
    alternativasLenguaje2.add("Predicado");
    alternativasLenguaje2.add("Complemento directo");
    alternativasLenguaje2.add("Complemento indirecto");
    char altCorrectaLenguaje2 = 'b';
    
    PreguntaAlternativas preguntaLenguaje2 = new PreguntaAlternativas("Identifica la parte de la oración que contiene el verbo.", "Gramática", alternativasLenguaje2, altCorrectaLenguaje2);
    evaLenguaje.anadirPregunta(preguntaLenguaje2);
    
    // Pregunta de desarrollo
    PreguntaDesarrollo preguntaLenguaje3 = new PreguntaDesarrollo("Escribe una carta formal.", "Redacción", "Escribe aquí tu carta formal.");
    evaLenguaje.anadirPregunta(preguntaLenguaje3);
    
    // Pregunta de alternativas
    ArrayList<String> alternativasLenguaje4 = new ArrayList<>();
    alternativasLenguaje4.add("Sílaba tónica");
    alternativasLenguaje4.add("Sílaba átona");
    alternativasLenguaje4.add("Sílaba trabada");
    alternativasLenguaje4.add("Diptongo");
    char altCorrectaLenguaje4 = 'a';
    
    PreguntaAlternativas preguntaLenguaje4 = new PreguntaAlternativas("Identifica la sílaba con acento en la palabra 'rápido'.", "Ortografía", alternativasLenguaje4, altCorrectaLenguaje4);
    evaLenguaje.anadirPregunta(preguntaLenguaje4);
    
    // Pregunta de desarrollo
    PreguntaDesarrollo preguntaLenguaje5 = new PreguntaDesarrollo("Explica qué es una metáfora.", "Figuras Literarias", "Escribe aquí tu definición de metáfora.");
    evaLenguaje.anadirPregunta(preguntaLenguaje5);
    
    // Notas
    evaLenguaje.anadirNota(new Nota(6.7, "Estudiante1"));
    evaLenguaje.anadirNota(new Nota(7.8, "Estudiante2"));
    evaLenguaje.anadirNota(new Nota(5.9, "Estudiante3"));
    evaLenguaje.anadirNota(new Nota(8.2, "Estudiante4"));
    evaLenguaje.anadirNota(new Nota(6.1, "Estudiante5"));
    
    // Agregar la evaluación
    agregarEvaluacion(evaLenguaje);

        // Evaluación de Historia
    Evaluacion evaHistoria = new Evaluacion("Evolución de la Sociedad", "Historia", "12-06-2022");
    
    // Pregunta de desarrollo
    PreguntaDesarrollo preguntaHistoria1 = new PreguntaDesarrollo("Describe la Revolución Industrial y su impacto en la sociedad.", "Historia Moderna", "La Revolución Industrial fue un período de transformación económica y social que comenzó en Gran Bretaña a finales del siglo XVIII.");
    evaHistoria.anadirPregunta(preguntaHistoria1);
    
    // Pregunta de alternativas
    ArrayList<String> alternativasHistoria2 = new ArrayList<>();
    alternativasHistoria2.add("Napoleón Bonaparte");
    alternativasHistoria2.add("George Washington");
    alternativasHistoria2.add("Simón Bolívar");
    alternativasHistoria2.add("Winston Churchill");
    char altCorrectaHistoria2 = 'a';
    
    PreguntaAlternativas preguntaHistoria2 = new PreguntaAlternativas("¿Quién fue el líder durante las Guerras Napoleónicas?", "Historia Contemporánea", alternativasHistoria2, altCorrectaHistoria2);
    evaHistoria.anadirPregunta(preguntaHistoria2);
    
    // Pregunta de desarrollo
    PreguntaDesarrollo preguntaHistoria3 = new PreguntaDesarrollo("Explica qué fue la Guerra Fría.", "Historia Contemporánea", "Escribe aquí tu explicación de la Guerra Fría.");
    evaHistoria.anadirPregunta(preguntaHistoria3);
    
    // Pregunta de alternativas
    ArrayList<String> alternativasHistoria4 = new ArrayList<>();
    alternativasHistoria4.add("Sí");
    alternativasHistoria4.add("No");
    char altCorrectaHistoria4 = 'a';
    
    PreguntaAlternativas preguntaHistoria4 = new PreguntaAlternativas("¿La Revolución Rusa de 1917 estableció un gobierno comunista?", "Revolución Rusa", alternativasHistoria4, altCorrectaHistoria4);
    evaHistoria.anadirPregunta(preguntaHistoria4);
    
    // Pregunta de desarrollo
    PreguntaDesarrollo preguntaHistoria5 = new PreguntaDesarrollo("Habla sobre el imperio romano.", "Historia Antigua", "Escribe aquí sobre el imperio romano.");
    evaHistoria.anadirPregunta(preguntaHistoria5);
    
    // Notas
    evaHistoria.anadirNota(new Nota(7.3, "Estudiante1"));
    evaHistoria.anadirNota(new Nota(8.5, "Estudiante2"));
    evaHistoria.anadirNota(new Nota(6.6, "Estudiante3"));
    evaHistoria.anadirNota(new Nota(9.1, "Estudiante4"));
    evaHistoria.anadirNota(new Nota(7.9, "Estudiante5"));
    
    // Agregar la evaluación
    agregarEvaluacion(evaHistoria);
    
// Evaluación de Ciencias
    Evaluacion evaCiencias = new Evaluacion("Biología, Química y Física", "Ciencias", "12-06-2022");
    
    // Pregunta de desarrollo
    PreguntaDesarrollo preguntaCiencias1 = new PreguntaDesarrollo("Explica el ciclo del agua.", "Biología", "El ciclo del agua, también conocido como ciclo hidrológico, es el proceso de circulación del agua en la atmósfera y en la tierra.");
    evaCiencias.anadirPregunta(preguntaCiencias1);
    
    // Pregunta de alternativas
    ArrayList<String> alternativasCiencias2 = new ArrayList<>();
    alternativasCiencias2.add("Sólido");
    alternativasCiencias2.add("Líquido");
    alternativasCiencias2.add("Gas");
    alternativasCiencias2.add("Plasma");
    char altCorrectaCiencias2 = 'b';
    
    PreguntaAlternativas preguntaCiencias2 = new PreguntaAlternativas("¿Cuál es el estado de la materia con forma y volumen definidos?", "Física", alternativasCiencias2, altCorrectaCiencias2);
    evaCiencias.anadirPregunta(preguntaCiencias2);
    
    // Pregunta de desarrollo
    PreguntaDesarrollo preguntaCiencias3 = new PreguntaDesarrollo("Explica la teoría de la relatividad de Einstein.", "Física Moderna", "La teoría de la relatividad propuesta por Albert Einstein revolucionó nuestra comprensión del espacio, el tiempo y la gravedad.");
    evaCiencias.anadirPregunta(preguntaCiencias3);
    
    // Pregunta de alternativas
    ArrayList<String> alternativasCiencias4 = new ArrayList<>();
    alternativasCiencias4.add("ADN");
    alternativasCiencias4.add("ARN");
    alternativasCiencias4.add("ARNt");
    alternativasCiencias4.add("ARNm");
    char altCorrectaCiencias4 = 'a';
    
    PreguntaAlternativas preguntaCiencias4 = new PreguntaAlternativas("¿Cuál es la molécula que contiene la información genética en las células?", "Genética", alternativasCiencias4, altCorrectaCiencias4);
    evaCiencias.anadirPregunta(preguntaCiencias4);
    
    // Pregunta de desarrollo
    PreguntaDesarrollo preguntaCiencias5 = new PreguntaDesarrollo("Explica la ley de la conservación de la energía.", "Física", "La ley de la conservación de la energía establece que la energía no se crea ni se destruye, solo se transforma.");
    evaCiencias.anadirPregunta(preguntaCiencias5);
    
    // Notas
    evaCiencias.anadirNota(new Nota(8.0, "Estudiante1"));
    evaCiencias.anadirNota(new Nota(7.5, "Estudiante2"));
    evaCiencias.anadirNota(new Nota(9.2, "Estudiante3"));
    evaCiencias.anadirNota(new Nota(8.7, "Estudiante4"));
    evaCiencias.anadirNota(new Nota(7.9, "Estudiante5"));
    
    // Agregar la evaluación
    agregarEvaluacion(evaCiencias);

    // Evaluación de Inglés
    Evaluacion evaIngles = new Evaluacion("Vocabulary", "Inglés", "12-06-2022");
    
    // Pregunta de desarrollo
    PreguntaDesarrollo preguntaIngles1 = new PreguntaDesarrollo("Describe tu rutina diaria en inglés.", "Vocabulario y Rutinas", "Write about your daily routine using English.");
    evaIngles.anadirPregunta(preguntaIngles1);
    
    // Pregunta de alternativas
    ArrayList<String> alternativasIngles2 = new ArrayList<>();
    alternativasIngles2.add("London");
    alternativasIngles2.add("Paris");
    alternativasIngles2.add("Madrid");
    alternativasIngles2.add("Rome");
    char altCorrectaIngles2 = 'a';
    
    PreguntaAlternativas preguntaIngles2 = new PreguntaAlternativas("What is the capital of England?", "Geography", alternativasIngles2, altCorrectaIngles2);
    evaIngles.anadirPregunta(preguntaIngles2);
    
    // Pregunta de desarrollo
    PreguntaDesarrollo preguntaIngles3 = new PreguntaDesarrollo("Explique el uso del presente continuo en inglés.", "Gramática", "Explain the use of present continuous tense in English.");
    evaIngles.anadirPregunta(preguntaIngles3);
    
    // Pregunta de alternativas
    ArrayList<String> alternativasIngles4 = new ArrayList<>();
    alternativasIngles4.add("Red");
    alternativasIngles4.add("Blue");
    alternativasIngles4.add("Green");
    alternativasIngles4.add("Yellow");
    char altCorrectaIngles4 = 'c';
    
    PreguntaAlternativas preguntaIngles4 = new PreguntaAlternativas("What color is the grass?", "Colors", alternativasIngles4, altCorrectaIngles4);
    evaIngles.anadirPregunta(preguntaIngles4);
    
    // Pregunta de desarrollo
    PreguntaDesarrollo preguntaIngles5 = new PreguntaDesarrollo("Habla sobre tus vacaciones ideales en inglés.", "Vocabulario y Viajes", "Talk about your ideal vacation using English.");
    evaIngles.anadirPregunta(preguntaIngles5);
    
    // Notas
    evaIngles.anadirNota(new Nota(7.6, "Estudiante1"));
    evaIngles.anadirNota(new Nota(8.2, "Estudiante2"));
    evaIngles.anadirNota(new Nota(6.9, "Estudiante3"));
    evaIngles.anadirNota(new Nota(9.0, "Estudiante4"));
    evaIngles.anadirNota(new Nota(8.3, "Estudiante5"));
    
    // Agregar la evaluación
    agregarEvaluacion(evaIngles);
  }

  /**
   * @return clon del ArrayList de evaluaciones.
   */
  public ArrayList <Evaluacion> getEvaluaciones(){
    ArrayList <Evaluacion> aux = (ArrayList <Evaluacion>) arrayEvaluaciones.clone();
    return aux;
  }

}
