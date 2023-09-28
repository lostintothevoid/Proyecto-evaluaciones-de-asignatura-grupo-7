import java.util.ArrayList;
import java.util.HashMap;

//primera coleccion A
public class Colegio{
  private ArrayList <Evaluacion> arrayEvaluaciones;
  private HashMap <String, Evaluacion> mapaEvaluaciones;

  //Constructor
  public Colegio(){
    arrayEvaluaciones = new ArrayList();
    mapaEvaluaciones = new HashMap();
  }

  //Busca una evaluación
  public Evaluacion buscarEvaluacion(String nomUnidad){
    /*
    if(arrayEvaluaciones.isEmpty()== true){
      return null;
    }
    */
    
    if(mapaEvaluaciones.containsKey(nomUnidad) == true){
      return mapaEvaluaciones.get(nomUnidad);
    }
    // por ultimo de no encontrar nada en el proceso por defecto retornara null
    return null;
  }

  //Busca todas las evaluaciones de una asignatura
  public ArrayList <Evaluacion> buscarEvaluacionAsignatura(String asignatura){
    ArrayList <Evaluacion> aux = new ArrayList();
    for(int i = 0; i < arrayEvaluaciones.size(); i++){
      Evaluacion ee = arrayEvaluaciones.get(i);
      if(ee.getAsignatura().equals(asignatura)){
        aux.add(ee);
      }
    }
    if(aux.isEmpty()) return null;
    return aux;
  }

  //Agrega una nota
  public boolean agregarEvaluacion(Evaluacion ee){
    //Si la asignatura no se encuentra se devuelve un false
    Evaluacion aux = buscarEvaluacion(ee.getUnidad());
    if(aux != null) return false;
    
    //Si pasa el if anterior significa que la asignatura no existe por lo tanto se agrega
    arrayEvaluaciones.add(ee);
    mapaEvaluaciones.put(ee.getUnidad(),ee);
    return true;
  }

  //Elimina una evaluacio
  public boolean eliminarEvaluacion(String unidad){
    //Se obtiene la asignatura
    Evaluacion ee = buscarEvaluacion(unidad);
    
    //Si no existe, no se elimina y retorna falso
    if (ee == null){
      return false;
    }
    else{
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
    }
    return false;
  }

  //Sobrecarda para eliminar una evaluacion
  public void eliminarEvaluacion(String vieja,String nueva){
    for(int i = 0; i < arrayEvaluaciones.size(); i++){
      Evaluacion eva = arrayEvaluaciones.get(i);
      if(eva.getUnidad().equals(nueva)){
        arrayEvaluaciones.remove(i);
        mapaEvaluaciones.remove(vieja);
        return;
      }
    }
    
  }
  //Elimina una pregunta
  public boolean eliminarPregunta(String pregunta){
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

  //Agrega una pregunta
  public boolean anadirPregunta(Pregunta pregunta, Evaluacion ee){
    Pregunta pregunta2 = ee.buscarPregunta(pregunta.getPregunta()); 
    if(pregunta2 !=null){
      return false;
    }
    ee.anadirPregunta(pregunta);
    return true;
  }
  
/*
  public boolean anadirPregunta(Pregunta pregunta, String unidad){
    Evaluacion ee = mapaEvaluaciones.get(unidad);

    if(ee==null){
      return false;
    }else{
      anadirPregunta(pregunta,ee);
      return true;
    }
  }
*/
  //Se inicializan datos para que no esté todo vacío
  
  public void datosIniciales(){
    //Se crea una asignatura       unidad, asignatura, tema
    Evaluacion eva1 = new Evaluacion("Limites", "Matematicas", "12-06-2022");
    agregarEvaluacion(eva1);
                                //pregunta, tema
    Pregunta pregunta11 = new Pregunta("¿Cómo se define el límite lateral derecho de una función en un punto específico?", "Limites Laterales");
    ArrayList <String> alternativas11= new ArrayList();
    alternativas11.add("El límite de la función a medida que la variable se aproxima a ese punto desde valores menores a dicho punto.");
    alternativas11.add("El límite de la función a medida que la variable se aproxima a ese punto desde valores mayores a dicho punto.");
    alternativas11.add("El límite de la función a medida que la variable se aproxima a ese punto desde ambos lados, pero sin incluir el punto.");
    alternativas11.add("El límite de la función a medida que la variable se aproxima a ese punto desde ambos lados, incluyendo el punto.");
    String altCorrecta11 = "El límite de la función a medida que la variable se aproxima a ese punto desde valores mayores a dicho punto.";
    pregunta11.agregarAlternativas(alternativas11, altCorrecta11);
    eva1.anadirPregunta(pregunta11);
    
    Pregunta pregunta12 = new Pregunta("¿Qué condiciones deben cumplirse para que una función tenga límite lateral derecho en un punto?", "Limites Laterales");
    ArrayList<String> alternativas12 = new ArrayList<>();
    alternativas12.add("La función debe ser continua en ese punto.");
    alternativas12.add("La función debe ser derivable en ese punto.");
    alternativas12.add("La función debe estar definida en ese punto.");
    alternativas12.add("La función debe ser acotada en ese punto.");
    String altCorrecta12 = "La función debe estar definida en ese punto.";

    pregunta12.agregarAlternativas(alternativas12, altCorrecta12);
    eva1.anadirPregunta(pregunta12);
    

    Nota nota11 = new Nota(3.0, "Alex");
    Nota nota12 = new Nota(4.4, "Javier");
    Nota nota13 = new Nota(5.7, "Roberto");
    eva1.anadirNota(nota11);
    eva1.anadirNota(nota12);
    eva1.anadirNota(nota13);

    Evaluacion eva2 = new Evaluacion("Comprensión de Lectura", "Lenguaje", "10-07-2022");
agregarEvaluacion(eva2);

    Pregunta pregunta21 = new Pregunta("¿Qué es la intertextualidad en un texto literario?", "Intertextualidad");
    ArrayList<String> alternativas21 = new ArrayList<>();
    alternativas21.add("Es la relación entre un texto y su autor.");
    alternativas21.add("Es la relación entre un texto y otros textos.");
    alternativas21.add("Es la interpretación personal de un texto.");
    alternativas21.add("Es la estructura de un texto.");
    String altCorrecta21 = "Es la relación entre un texto y otros textos.";
    
    pregunta21.agregarAlternativas(alternativas21, altCorrecta21);
    eva2.anadirPregunta(pregunta21);
    
    Pregunta pregunta22 = new Pregunta("¿Cuál es el propósito principal de un texto expositivo?", "Tipos de Texto");
    ArrayList<String> alternativas22 = new ArrayList<>();
    alternativas22.add("Entretener al lector.");
    alternativas22.add("Persuadir al lector.");
    alternativas22.add("Informar al lector.");
    alternativas22.add("Despertar emociones en el lector.");
    String altCorrecta22 = "Informar al lector.";
    
    pregunta22.agregarAlternativas(alternativas22, altCorrecta22);
    eva2.anadirPregunta(pregunta22);
    
    Pregunta pregunta23 = new Pregunta("¿Qué es la anáfora en un poema?", "Recursos Literarios");
    ArrayList<String> alternativas23 = new ArrayList<>();
    alternativas23.add("Repetición de una palabra al principio de versos sucesivos.");
    alternativas23.add("Comparación directa entre dos elementos.");
    alternativas23.add("Uso de palabras que imitan sonidos naturales.");
    alternativas23.add("Exageración de una idea.");
    String altCorrecta23 = "Repetición de una palabra al principio de versos sucesivos.";
    
    pregunta23.agregarAlternativas(alternativas23, altCorrecta23);
    eva2.anadirPregunta(pregunta23);
    
    Pregunta pregunta24 = new Pregunta("¿Qué es un soneto?", "Formas Poéticas");
    ArrayList<String> alternativas24 = new ArrayList<>();
    alternativas24.add("Una poesía sin rima.");
    alternativas24.add("Un poema de catorce versos con una estructura específica.");
    alternativas24.add("Un poema con solo dos versos.");
    alternativas24.add("Un poema sin métrica.");
    String altCorrecta24 = "Un poema de catorce versos con una estructura específica.";
    
    pregunta24.agregarAlternativas(alternativas24, altCorrecta24);
    eva2.anadirPregunta(pregunta24);
    
    Pregunta pregunta25 = new Pregunta("¿Qué es la función apelativa del lenguaje?", "Funciones del Lenguaje");
    ArrayList<String> alternativas25 = new ArrayList<>();
    alternativas25.add("Persuadir o convencer al receptor.");
    alternativas25.add("Informar o transmitir información.");
    alternativas25.add("Expresar sentimientos o emociones.");
    alternativas25.add("Imitar sonidos naturales.");
    String altCorrecta25 = "Persuadir o convencer al receptor.";
    
    pregunta25.agregarAlternativas(alternativas25, altCorrecta25);
    eva2.anadirPregunta(pregunta25);
    
    Nota nota21 = new Nota(6.8, "Daniel");
    Nota nota22 = new Nota(5.0, "Laura");
    Nota nota23 = new Nota(7.2, "Ana");
    Nota nota24 = new Nota(5.5, "Carlos");
    eva2.anadirNota(nota21);
    eva2.anadirNota(nota22);
    eva2.anadirNota(nota23);
    eva2.anadirNota(nota24);

    Evaluacion eva3 = new Evaluacion("Revolución Industrial", "Historia", "15-07-2022");
agregarEvaluacion(eva3);

    Pregunta pregunta31 = new Pregunta("¿En qué siglo comenzó la Revolución Industrial?", "Revolución Industrial");
    ArrayList<String> alternativas31 = new ArrayList<>();
    alternativas31.add("Siglo XVIII");
    alternativas31.add("Siglo XIX");
    alternativas31.add("Siglo XVII");
    alternativas31.add("Siglo XX");
    String altCorrecta31 = "Siglo XVIII";
    
    pregunta31.agregarAlternativas(alternativas31, altCorrecta31);
    eva3.anadirPregunta(pregunta31);
    
    Pregunta pregunta32 = new Pregunta("¿En qué país se originó la Revolución Industrial?", "Revolución Industrial");
    ArrayList<String> alternativas32 = new ArrayList<>();
    alternativas32.add("Reino Unido");
    alternativas32.add("Francia");
    alternativas32.add("Estados Unidos");
    alternativas32.add("Alemania");
    String altCorrecta32 = "Reino Unido";
    
    pregunta32.agregarAlternativas(alternativas32, altCorrecta32);
    eva3.anadirPregunta(pregunta32);
    
    Pregunta pregunta33 = new Pregunta("¿Cuál fue uno de los principales avances tecnológicos durante la Revolución Industrial?", "Revolución Industrial");
    ArrayList<String> alternativas33 = new ArrayList<>();
    alternativas33.add("Máquina de vapor");
    alternativas33.add("Electricidad");
    alternativas33.add("Computadora");
    alternativas33.add("Avión");
    String altCorrecta33 = "Máquina de vapor";
    
    pregunta33.agregarAlternativas(alternativas33, altCorrecta33);
    eva3.anadirPregunta(pregunta33);
    
    Pregunta pregunta34 = new Pregunta("¿Qué consecuencia social tuvo la Revolución Industrial?", "Revolución Industrial");
    ArrayList<String> alternativas34 = new ArrayList<>();
    alternativas34.add("Urbanización");
    alternativas34.add("Aumento de la agricultura");
    alternativas34.add("Disminución de la población");
    alternativas34.add("Descenso de la producción");
    String altCorrecta34 = "Urbanización";
    
    pregunta34.agregarAlternativas(alternativas34, altCorrecta34);
    eva3.anadirPregunta(pregunta34);
    
    Pregunta pregunta35 = new Pregunta("¿Cuál fue la importancia de las fábricas durante la Revolución Industrial?", "Revolución Industrial");
    ArrayList<String> alternativas35 = new ArrayList<>();
    alternativas35.add("Centralización de la producción");
    alternativas35.add("Descentralización de la producción");
    alternativas35.add("Aumento de la producción artesanal");
    alternativas35.add("Reducción de la demanda");
    String altCorrecta35 = "Centralización de la producción";
    
    pregunta35.agregarAlternativas(alternativas35, altCorrecta35);
    eva3.anadirPregunta(pregunta35);
    
    Nota nota31 = new Nota(7.0, "Martina");
    Nota nota32 = new Nota(5.8, "Luis");
    Nota nota33 = new Nota(6.5, "David");
    Nota nota34 = new Nota(4.9, "Marta");
    Nota nota35 = new Nota(7.0, "Pedro");
    Nota nota36 = new Nota(6.2, "Ana");
    eva3.anadirNota(nota31);
    eva3.anadirNota(nota32);
    eva3.anadirNota(nota33);
    eva3.anadirNota(nota34);
    eva3.anadirNota(nota35);
    eva3.anadirNota(nota36);

    Evaluacion eva4 = new Evaluacion("Química Orgánica", "Ciencias", "25-06-2022");
agregarEvaluacion(eva4);

    Pregunta pregunta41 = new Pregunta("¿Cuál es el elemento básico en las moléculas orgánicas?", "Química Orgánica");
    ArrayList<String> alternativas41 = new ArrayList<>();
    alternativas41.add("Carbono");
    alternativas41.add("Hidrógeno");
    alternativas41.add("Oxígeno");
    alternativas41.add("Nitrógeno");
    String altCorrecta41 = "Carbono";
    
    pregunta41.agregarAlternativas(alternativas41, altCorrecta41);
    eva4.anadirPregunta(pregunta41);
    
    Pregunta pregunta42 = new Pregunta("¿Qué tipo de enlace es característico de las moléculas orgánicas?", "Química Orgánica");
    ArrayList<String> alternativas42 = new ArrayList<>();
    alternativas42.add("Enlace covalente");
    alternativas42.add("Enlace iónico");
    alternativas42.add("Enlace metálico");
    alternativas42.add("Enlace de hidrógeno");
    String altCorrecta42 = "Enlace covalente";
    
    pregunta42.agregarAlternativas(alternativas42, altCorrecta42);
    eva4.anadirPregunta(pregunta42);
    
    Pregunta pregunta43 = new Pregunta("¿Cuál es la fórmula química del agua?", "Química Orgánica");
    ArrayList<String> alternativas43 = new ArrayList<>();
    alternativas43.add("H₂O");
    alternativas43.add("CO₂");
    alternativas43.add("O₂");
    alternativas43.add("HCl");
    String altCorrecta43 = "H₂O";
    
    pregunta43.agregarAlternativas(alternativas43, altCorrecta43);
    eva4.anadirPregunta(pregunta43);
    
    Pregunta pregunta44 = new Pregunta("¿Qué representa la sigla pH en química?", "Química Orgánica");
    ArrayList<String> alternativas44 = new ArrayList<>();
    alternativas44.add("Potencial de Hidrógeno");
    alternativas44.add("Potencial de Oxígeno");
    alternativas44.add("Porcentaje de Hidrógeno");
    alternativas44.add("Porcentaje de Oxígeno");
    String altCorrecta44 = "Potencial de Hidrógeno";
    
    pregunta44.agregarAlternativas(alternativas44, altCorrecta44);
    eva4.anadirPregunta(pregunta44);
    
    Pregunta pregunta45 = new Pregunta("¿Cuál es el proceso de combustión completo de un hidrocarburo?", "Química Orgánica");
    ArrayList<String> alternativas45 = new ArrayList<>();
    alternativas45.add("CO₂ y H₂O");
    alternativas45.add("CO₂ y O₂");
    alternativas45.add("CH₄ y O₂");
    alternativas45.add("C y O₂");
    String altCorrecta45 = "CO₂ y H₂O";
    
    pregunta45.agregarAlternativas(alternativas45, altCorrecta45);
    eva4.anadirPregunta(pregunta45);
    
    Nota nota41 = new Nota(6.0, "Martín");
    Nota nota42 = new Nota(5.5, "Laura");
    Nota nota43 = new Nota(7.0, "Carlos");
    Nota nota44 = new Nota(4.8, "Ana");
    Nota nota45 = new Nota(6.7, "Pedro");
    eva4.anadirNota(nota41);
    eva4.anadirNota(nota42);
    eva4.anadirNota(nota43);
    eva4.anadirNota(nota44);
    eva4.anadirNota(nota45);

    Evaluacion eva5 = new Evaluacion("Verbos Irregulares", "Inglés", "20-07-2022");
agregarEvaluacion(eva5);

    Pregunta pregunta51 = new Pregunta("¿Cuál es la forma en pasado del verbo 'eat'?", "Verbos Irregulares");
    ArrayList<String> alternativas51 = new ArrayList<>();
    alternativas51.add("Ate");
    alternativas51.add("Eated");
    alternativas51.add("Eat");
    alternativas51.add("Eaten");
    String altCorrecta51 = "Ate";
    
    pregunta51.agregarAlternativas(alternativas51, altCorrecta51);
    eva5.anadirPregunta(pregunta51);
    
    Pregunta pregunta52 = new Pregunta("¿Cuál es la forma en pasado del verbo 'go'?", "Verbos Irregulares");
    ArrayList<String> alternativas52 = new ArrayList<>();
    alternativas52.add("Went");
    alternativas52.add("Gone");
    alternativas52.add("Go");
    alternativas52.add("Goes");
    String altCorrecta52 = "Went";
    
    pregunta52.agregarAlternativas(alternativas52, altCorrecta52);
    eva5.anadirPregunta(pregunta52);
    
    Pregunta pregunta53 = new Pregunta("¿Cuál es la forma en pasado del verbo 'see'?", "Verbos Irregulares");
    ArrayList<String> alternativas53 = new ArrayList<>();
    alternativas53.add("Saw");
    alternativas53.add("Seen");
    alternativas53.add("Sees");
    alternativas53.add("See");
    String altCorrecta53 = "Saw";
    
    pregunta53.agregarAlternativas(alternativas53, altCorrecta53);
    eva5.anadirPregunta(pregunta53);
    
    Pregunta pregunta54 = new Pregunta("¿Cuál es la forma en pasado del verbo 'break'?", "Verbos Irregulares");
    ArrayList<String> alternativas54 = new ArrayList<>();
    alternativas54.add("Broke");
    alternativas54.add("Broken");
    alternativas54.add("Breaks");
    alternativas54.add("Breaked");
    String altCorrecta54 = "Broke";
    
    pregunta54.agregarAlternativas(alternativas54, altCorrecta54);
    eva5.anadirPregunta(pregunta54);
    
    Pregunta pregunta55 = new Pregunta("¿Cuál es la forma en pasado del verbo 'drink'?", "Verbos Irregulares");
    ArrayList<String> alternativas55 = new ArrayList<>();
    alternativas55.add("Drank");
    alternativas55.add("Drinked");
    alternativas55.add("Drunk");
    alternativas55.add("Drinks");
    String altCorrecta55 = "Drank";
    
    pregunta55.agregarAlternativas(alternativas55, altCorrecta55);
    eva5.anadirPregunta(pregunta55);
    
    Nota nota51 = new Nota(6.0, "Marcos");
    Nota nota52 = new Nota(5.5, "Lucía");
    Nota nota53 = new Nota(4.8, "Elena");
    Nota nota54 = new Nota(7.0, "Miguel");
    Nota nota55 = new Nota(6.2, "Sofía");
    Nota nota56 = new Nota(5.9, "Javier");
    Nota nota57 = new Nota(7.0, "Cristina");
    eva5.anadirNota(nota51);
    eva5.anadirNota(nota52);
    eva5.anadirNota(nota53);
    eva5.anadirNota(nota54);
    eva5.anadirNota(nota55);
    eva5.anadirNota(nota56);
    eva5.anadirNota(nota57);

  }

  public ArrayList <Evaluacion> getEvaluaciones(){
    ArrayList <Evaluacion> aux = (ArrayList <Evaluacion>) arrayEvaluaciones.clone();
    return aux;
  }

}
