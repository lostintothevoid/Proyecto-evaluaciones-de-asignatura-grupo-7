import java.util.ArrayList;
import java.util.HashMap;

//primera coleccion A
public class Colegio{
  //Se guardan las asignaturas de un colegio en un ArrayList y un HashMap
  private ArrayList <tipoAsignatura> asignaturas;
  private HashMap <String,tipoAsignatura> mapaAsignaturas;
  
  public Colegio(){
    asignaturas = new ArrayList();
    mapaAsignaturas = new HashMap();
  }
  
  public tipoAsignatura buscar(String nombre){
    // condicion la cual verificar si el ArrayList se encuentra vacio
    if(asignaturas.isEmpty()== true){
      return null;
    }
    /* con la ayuda del mapa se busca si la asignatura se encuentra de estar retorna una variable tipoAsignatura con */
    if(mapaAsignaturas.containsKey(nombre)== true){
      return mapaAsignaturas.get(nombre);
    }
    // por ultimo de no encontrar nada en el proceso por defecto retornara null
    return null;
  }

  public boolean agregar(tipoAsignatura asignatura){
    //Si la asignatura no se encuentra o el arreglo esta vacio se devuelve un false

    tipoAsignatura asig = buscar(asignatura.getNombre());
    if(asig != null) return false;
    
    //Si pasa el if anterior significa que la asignatura no existe por lo tanto se agrega
    asignaturas.add(asignatura);
    mapaAsignaturas.put(asignatura.getNombre(),asignatura);
    return true;
  }

  public void eliminar (String nombre){
    //Se obtiene la asignatura
    tipoAsignatura asigna = buscar(nombre);
    
    if (asigna == null){
      System.out.println("La asignatura no existe");
      //return no necesario segun netbean
      return;
    }
    else{
      //Busco en el ArrayList
      for(int i=0; i < asignaturas.size(); i++){
        if(asignaturas.get(i).getNombre().equals(asigna.getNombre())){
          //Se elimina del ArrayList y del HashMap
          asignaturas.remove(i);
          mapaAsignaturas.remove(asigna.getNombre());
          System.out.println("La asignatura ha sido borrada con exito");
          return;
        }
      }
    }
  }

  public void listarAsignaturas(){
    if(asignaturas.isEmpty()){
      System.out.println("No hay asignaturas registradas.");
      return;
    }
    
    System.out.println("Asignaturas:");
    for(int i = 0; i < asignaturas.size(); i++){
      System.out.println(asignaturas.get(i).getNombre());
    }
  }

  public void listarAsignaturasYevaluaciones(){
    if(asignaturas.isEmpty()){
      System.out.println("No hay Asignaturas registradas.");
      return;
    }
    
    for (int i = 0; i < asignaturas.size(); i++){
      /*if (i == 0){
        System.out.println(asignaturas.get(i).getNombre() + ":");
        for()
      }
      */
      tipoAsignatura asig = asignaturas.get(i);
      asig.listarEvaluaciones();
    }
  }

  public void datosIniciales(){
    tipoAsignatura asig1 =  new tipoAsignatura("Ciencias Naturales");
    agregar(asig1);

    ArrayList<String> celulas = new ArrayList<>();
    celulas.add("¿Cuáles son las principales estructuras de una célula?");
    celulas.add("Explique las diferencias entre células procariotas y células eucariotas.");
    celulas.add("¿Qué es la mitosis y en qué proceso celular ocurre?");

    ArrayList<String> astronomia = new ArrayList<>();
    astronomia.add("¿Cuál es la diferencia entre una estrella y un planeta?");
    astronomia.add("Explique qué es un agujero negro y cómo se forma.");
    astronomia.add("¿Qué son las galaxias y cuál es la Vía Láctea?");

    ArrayList<String> sistemaNervioso = new ArrayList<>();
    sistemaNervioso.add("¿Cuál es la función principal del sistema nervioso?");
    sistemaNervioso.add("Explique la diferencia entre el sistema nervioso central y el sistema nervioso periférico.");
    sistemaNervioso.add("¿Qué son las neuronas y cómo transmiten información?");    
    
    tipoEvaluacion ev11 = new tipoEvaluacion(4.0, "11-6-2021", "Células", celulas);
    tipoEvaluacion ev12 = new tipoEvaluacion(5.5, "13-8-2021", "Astronomía", astronomia);
    tipoEvaluacion ev13 = new tipoEvaluacion(3.9, "5-4-2021", "Sistema nervioso", sistemaNervioso);

    asig1.agregarEvaluacion(ev11);
    asig1.agregarEvaluacion(ev12);
    asig1.agregarEvaluacion(ev13);
    
    ArrayList<String> generoLiterario = new ArrayList<>();
    generoLiterario.add("¿Qué es un género literario?");
    generoLiterario.add("Menciona algunos ejemplos de géneros literarios.");
    generoLiterario.add("Explica las características principales de la poesía.");

    ArrayList<String> generoNarrativo = new ArrayList<>();
    generoNarrativo.add("¿En qué consiste el género narrativo?");
    generoNarrativo.add("Diferencia entre un narrador en primera persona y un narrador en tercera persona.");
    generoNarrativo.add("Habla sobre las partes típicas de una narración, como introducción, nudo y desenlace.");

    ArrayList<String> elPrincipito = new ArrayList<>();
    elPrincipito.add("¿Quién es el autor de 'El Principito'?");
    elPrincipito.add("¿Cuál es el tema principal de 'El Principito'?");
    elPrincipito.add("Menciona algunos personajes memorables que aparecen en 'El Principito'.");
    
    tipoAsignatura asig2 =  new tipoAsignatura("Lenguaje");
    agregar(asig2);

    tipoEvaluacion ev21 = new tipoEvaluacion(5.0, "24-5-2021", "Género literario", generoLiterario);
    tipoEvaluacion ev22 = new tipoEvaluacion(4.3, "7-8-2021", "Género Narrativo", generoNarrativo);
    tipoEvaluacion ev23 = new tipoEvaluacion(4.0, "2-9-2021", "El principito", elPrincipito);

    asig2.agregarEvaluacion(ev21);
    asig2.agregarEvaluacion(ev22);
    asig2.agregarEvaluacion(ev23);
                                             
    ArrayList<String> limites = new ArrayList<>();
    limites.add("¿Qué es el límite de una función en matemáticas?");
    limites.add("¿Cómo se calculan los límites indeterminados?");
    limites.add("¿Cuál es la importancia de los límites en el cálculo?");

    ArrayList<String> derivadas = new ArrayList<>();
    derivadas.add("¿Qué es la derivada de una función y cuál es su interpretación geométrica?");
    derivadas.add("¿Cómo se calculan las derivadas de funciones algebraicas?");
    derivadas.add("Menciona algunas aplicaciones de las derivadas en situaciones del mundo real.");

    ArrayList<String> integrales = new ArrayList<>();
    integrales.add("¿Qué representa la integral definida en matemáticas?");
    integrales.add("¿Cuál es la diferencia entre la integral definida y la integral indefinida?");
    integrales.add("¿Cómo se calculan integrales usando el método de integración por partes?");
      
    tipoAsignatura asig3 = new tipoAsignatura("Matematica");
    agregar(asig3);

    tipoEvaluacion ev31 = new tipoEvaluacion(3.2, "7-5-2021", "Límites", limites);
    tipoEvaluacion ev32 = new tipoEvaluacion(4.9, "14-8-2021", "Derivadas", derivadas);
    tipoEvaluacion ev33 = new tipoEvaluacion(5.8, "1-9-2021", "Integrales", integrales);

    asig3.agregarEvaluacion(ev31);
    asig3.agregarEvaluacion(ev32);
    asig3.agregarEvaluacion(ev33);

    
    tipoAsignatura asig4 = new tipoAsignatura("Historia");
    agregar(asig4);
    
    ArrayList<String> guerraCivilFrancia = new ArrayList<>();
    guerraCivilFrancia.add("¿En qué año comenzó la Guerra Civil de Francia?");
    guerraCivilFrancia.add("¿Quiénes fueron los bandos principales en conflicto?");
    guerraCivilFrancia.add("¿Cuál fue el resultado de la Guerra Civil de Francia?");
    
    ArrayList<String> colonizacion = new ArrayList<>();
    colonizacion.add("¿Qué países europeos estuvieron más involucrados en la colonización de América?");
    colonizacion.add("¿Cuáles fueron las consecuencias más significativas de la colonización en América?");
    colonizacion.add("¿Cómo afectó la colonización a las poblaciones nativas?");
    
    ArrayList<String> guerraPacifico = new ArrayList<>();
    guerraPacifico.add("¿Cuáles fueron los países involucrados en la Guerra del Pacífico?");
    guerraPacifico.add("¿Qué territorios estaban en disputa durante esta guerra?");
    guerraPacifico.add("¿Cuál fue el resultado y el impacto de la Guerra del Pacífico en la región?");
          
    tipoEvaluacion ev41 = new tipoEvaluacion(4.0, "1-9-2021", "Guerra civil de Francia", guerraCivilFrancia);
    tipoEvaluacion ev42 = new tipoEvaluacion(4.0, "6-8-2021", "Colonización", colonizacion);
    tipoEvaluacion ev43 = new tipoEvaluacion(4.0, "11-10-2021", "Guerra del pacífico", guerraPacifico);

    asig4.agregarEvaluacion(ev41);
    asig4.agregarEvaluacion(ev42);
    asig4.agregarEvaluacion(ev43);
  }
      
}
