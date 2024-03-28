import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;



public class Menu {
  private Colegio colegio;
  
  /**
   * Constructor de Colegio que Inicializa los parámetros.
   */
  public Menu(Colegio colegio){
    this.colegio = colegio;
  }

  /**
   * Método que genera la opciones del programa.
   * @throws IOException Error de I/O
   */
  public void opciones() throws IOException{
   
    // se utiliza el lector para registrar la eleccion del usuario
    BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
    colegio.datosIniciales();
    while(true){
      //Opciones
      System.out.println("Ingrese 1 para agregar una evaluacion");
      System.out.println("Ingrese 2 para agregar una pregunta");
      System.out.println("Ingrese 3 para agregar una nota");
      System.out.println("Ingrese 4 para eliminar una evaluación");
      System.out.println("Ingrese 5 para eliminar una pregunta");
      System.out.println("Ingrese 6 para eliminar una nota ");
      System.out.println("Ingrese 7 para editar una evaluación");
      System.out.println("Ingrese 8 para editar una pregunta de una evaluación");
      System.out.println("Ingrese 9 para ver todas las evaluaciones");
      System.out.println("Ingrese 10 para ver todas las evaluaciones de una asignatura");
      System.out.println("Ingrese 11 para ver una evaluacion");  
      System.out.println("Ingrese 12 para ver todas las preguntas de una evaluacion");
      System.out.println("Ingrese 13 para ver todas las motas de una evaluacion");
      System.out.println("Ingrese 14 para generar un reporte");  
      System.out.println("Ingrese 0 para salir de la aplicación");
      
      System.out.println("");

      int opcion = 0;
      try{
        String opcionStr = lector.readLine();
        opcion = Integer.parseInt(opcionStr);
      }catch(IOException e){
        System.out.println("Error de input");
        return;
      }catch(NumberFormatException e){
        System.out.println("Error de input NUMERO");
      }
      
      //int opcion = Integer.parseInt(lector.readLine());
      switch(opcion){
        case 0:
          System.out.println("--------PROGRAMA FINALIZADO--------");
          return;
        case 1:
          agregarEvaluacion(lector);
          System.out.println("");
          break;
        case 2:
          agregarPregunta(lector);
          System.out.println("");
          break;
        case 3:
          agregarNota(lector);
          System.out.println("");
          break;
        case 4:
          eliminarEvaluacion(lector);
          System.out.println("");
          break;
          
        case 5:
          eliminarPregunta(lector);
          System.out.println("");
          break;

        case 6:
          eliminarNota(lector);
          System.out.println("");
          break;
          
        case 7:
          editEvaluacion(lector);
          System.out.println("");
          break;
          
        case 8:
          editPregunta(lector);
          System.out.println("");
          break;
          
        case 9:
          verEvaluaciones(lector);
          System.out.println("");
          break;

        case 10:
          verEvaluacionesAsignatura(lector);
          System.out.println("");
          break;
          
        case 11:
          mostrarEvaluacion(lector);
          System.out.println("");
          break;
          
        case 12:
          verPreguntasEva(lector);
          System.out.println("");
          break;
          
        case 13:
          mostrarNotas(lector);
          System.out.println("");
          break;
        
        case 14:
          reporte();
          System.out.println("");
          break;
          
        default:
          System.out.println("No se ingresó una opción válida");
          break;
          
      }
    }  
  }

  /**
   * Método que agrega una evaluación
   * @param lector Lector de la consola 
   * @throws IOException Error de I/O.
   */
  public void agregarEvaluacion(BufferedReader lector) throws IOException{
    //Se agrega una evaluacion nueva.
    System.out.println("Ingrese el nombre de la evaluacion que desea agregar: ");
    String evaNueva = lector.readLine();
    Evaluacion evaNuevaEntera = new Evaluacion();
    try{
      evaNuevaEntera = colegio.buscarEvaluacion(evaNueva);
    }catch (EvaluacionNotFoundException e){
      Evaluacion eva = new Evaluacion();
      System.out.println ("Ingrese fecha");
      String fecha = lector.readLine();
      eva.setFecha(fecha);
      
      System.out.println ("Ingrese asignatura");
      String asignatura = lector.readLine();
      eva.setAsignatura(asignatura);
      
      //ingreso de notas
      System.out.println ("Ingrese cantidad de notas a insertar");
      String lec = lector.readLine(); 
      int cantNotas = Integer.parseInt(lec);
  
      for(int i = 0 ;i < cantNotas ; i++){
        System.out.println ("Ingrese nota n°"+(i+1));
        String lex = lector.readLine();
        double notaAct = Double.parseDouble(lex);
        
        System.out.println ("Ingrese estudiante de nota n°"+(i+1));
        String aluAct = lector.readLine();
        
        Nota newNot = new Nota(notaAct, aluAct);
        eva.anadirNota(newNot);
      }
      
  
      System.out.println ("Ingrese cantidad de preguntas a insertar");
      String luc = lector.readLine(); 
      int cantPreguntas = Integer.parseInt(luc);
  
      ArrayList <Pregunta> preguntas = new ArrayList();
      for(int i = 0 ;i < cantPreguntas ; i++){
        agregarPregunta(lector, eva);
      }
      colegio.agregarEvaluacion(eva);
    }
  }

  /**
   * Método que agrega una pregunta.
   * @param lector Lector de la consola 
   * @param ee Evaluacion a la que se agrega la pregunta.
   * @throws IOException Error de I/O.
   */
  public void agregarPregunta(BufferedReader lector, Evaluacion ee) throws IOException{
    
    System.out.println("Ingrese la pregunta: ");
    String nomPregunta = lector.readLine();

    Pregunta buscPreg = ee.buscarPregunta(nomPregunta);
    if(buscPreg != null){
      System.out.println("La pregunta ya existe");
      return;
    }

    System.out.println("Ingrese el tema de la pregunta: ");
    String tema = lector.readLine();

    System.out.println("Ingrese el tipo de pregunta: ");
    System.out.println("1 Desarrollo");
    System.out.println("2 Alternativas");
    String quePregunta = lector.readLine();
    switch(quePregunta){
      case "1":
        System.out.println("Ingrese la respuesta esperada a la pregunta: ");
        String respuesta = lector.readLine();
        PreguntaDesarrollo preguntaDes = new PreguntaDesarrollo(nomPregunta, tema, respuesta);
        colegio.anadirPregunta(preguntaDes, ee);
        break;
      case "2":
        System.out.println("Ingrese la cantidad de alternativas que tendrá la pregunta");
        String aux = lector.readLine();
        int cant = Integer.parseInt(aux);
        System.out.println("Ingrese las alternativas respuestas a la pregunta: ");
        ArrayList<String> alternativas = new ArrayList();
        int contador = 1;
        while(contador<=cant){
          String alt = lector.readLine();
          alternativas.add(alt);
          contador++;
        }
        System.out.println("Ingrese la alternativa correcta");
        String altCorrecta = lector.readLine();
        char chars = (!altCorrecta.isEmpty()) ? altCorrecta.charAt(0) : '\0';
        PreguntaAlternativas preguntaAlt = new PreguntaAlternativas(nomPregunta, tema,alternativas,chars);
        colegio.anadirPregunta(preguntaAlt, ee);
        break;
      default:
        break;
    }
  }

  /**
   * Método que agrega una pregunta.
   * @param lector Lector de la consola 
   * @throws IOException Error de I/O.
   */
  public void agregarPregunta(BufferedReader lector)throws IOException{
    //Se agrega una evaluación a una asignatura en específico
    System.out.println("Ingrese la unidad de la evaluacion a la que desea añadir la pregunta: ");
    String nombreEva = lector.readLine();
    //Si la asignatura no existe se notifica
    Evaluacion ee = new Evaluacion();
    try{
      ee = colegio.buscarEvaluacion(nombreEva);
    }catch (EvaluacionNotFoundException e){
      return;
    }
    
    System.out.println("Ingrese la pregunta: ");
    String nomPregunta = lector.readLine();

    Pregunta buscPreg = ee.buscarPregunta(nomPregunta);
    if(buscPreg != null){
      System.out.println("La pregunta ya existe");
      return;
    }

    System.out.println("Ingrese el tema de la pregunta: ");
    String tema = lector.readLine();

    System.out.println("Ingrese el tipo de pregunta: ");
    System.out.println("1 Desarrollo");
    System.out.println("2 Alternativas");
    String quePregunta = lector.readLine();
    switch(quePregunta){
      case "1":
        System.out.println("Ingrese la respuesta esperada a la pregunta: ");
        String respuesta = lector.readLine();
        PreguntaDesarrollo preguntaDes = new PreguntaDesarrollo(nomPregunta, tema, respuesta);
        colegio.anadirPregunta(preguntaDes, ee);
        break;
      case "2":
        System.out.println("Ingrese la cantidad de alternativas que tendrá la pregunta");
        String aux = lector.readLine();
        int cant = Integer.parseInt(aux);
        System.out.println("Ingrese las alternativas respuestas a la pregunta: ");
        ArrayList<String> alternativas = new ArrayList();
        int contador = 1;
        while(contador<=cant){
          String alt = lector.readLine();
          alternativas.add(alt);
          contador++;
        }
        System.out.println("Ingrese la alternativa correcta");
        String altCorrecta = lector.readLine();
        char chars = (!altCorrecta.isEmpty()) ? altCorrecta.charAt(0) : '\0';
        
        PreguntaAlternativas preguntaAlt = new PreguntaAlternativas(nomPregunta, tema,alternativas,chars);
        colegio.anadirPregunta(preguntaAlt, ee);
        break;
      default:
        break;
    }
  }

  /**
   * Método que muestra todas las evaluaciones pertenecientes a una asignatura.
   * @param lector Lector de la consola 
   * @throws IOException Error de I/O.
   */
  public void verEvaluacionesAsignatura(BufferedReader lector)throws IOException{
    System.out.println("Ingrese la asignatura para ver sus Evaluaciones");
    String asignatura = lector.readLine();
    ArrayList <Evaluacion> evalxAsig= colegio.buscarEvaluacionAsignatura(asignatura);
    if(evalxAsig == null){
      System.out.println("No habían evaluaciones registradas en esta asignatura");
    }
    for(int i = 0; i < evalxAsig.size(); i++){
      Evaluacion ee = evalxAsig.get(i);
      System.out.println("Unidad: " + ee.getUnidad() + " Promedio: " + ee.promedioEvaluacion());
    }
    
  }

  /**
   * Método que muestra las preguntas de una evaluacion.
   * @param lector Lector de la consola 
   * @throws IOException Error de I/O.
   */
  public void verPreguntasEva(BufferedReader lector)throws IOException{
    //Se muestran todas las preguntaspreguntas de una evaluacion
    System.out.println("Ingrese unidad de la evaluacion");

    String nombre = lector.readLine();
    
    Evaluacion eva = new Evaluacion();
    try{
      eva = colegio.buscarEvaluacion(nombre);
    }catch(EvaluacionNotFoundException e){
      return;
    }

    
    ArrayList <Pregunta> preguntas = eva.getPreguntas();
    if(preguntas.isEmpty()){
      System.out.println("No hay preguntas registradas para esta evaluacion");
    }
    ArrayList<Character> letrasArray = new ArrayList<>();
    for (char letra = 'a'; letra <= 'z'; letra++) {
      letrasArray.add(letra);
    }
    
    for(int i = 0; i < preguntas.size(); i++){
      Pregunta pp = preguntas.get(i);
      System.out.println("Pregunta " + (i+1) + ": " + pp.contenidos());
    }
  }
    
  /**
   * Método que muestra todas las evaluaciones.
   * @param lector Lector de la consola 
   * @throws IOException Error de I/O.
   */
  public void verEvaluaciones(BufferedReader lector)throws IOException{
    ArrayList <Evaluacion> arryEva = colegio.getEvaluaciones();
    
    try{
      colegio.hayEvaluaciones(arryEva);
    }catch(SinEvaluacionesException e){
      System.out.println("No hay evaluaciones registradas");
      return;
    }
    
    for(int i = 0; i < arryEva.size(); i++){
      Evaluacion actualEva = arryEva.get(i);
      System.out.println("Evaluacion "+ (i+1) +":");
      System.out.println("Asignatura :"+ actualEva.getAsignatura());
      System.out.println("Unidad :"+ actualEva.getUnidad());
      System.out.println("Fecha :"+ actualEva.getFecha());
      System.out.println("Promedio :"+ actualEva.promedioEvaluacion());    
      System.out.println("");
    }
    
  }
  
  /**
   * Método que agrega una evaluación
   * @param lector Lector de la consola 
   * @throws IOException Error de I/O.
   */
  public void editEvaluacion(BufferedReader lector)throws IOException{
    System.out.println("Ingrese unidad de la evaluacion a editar");
    String nombreEvaEdit = lector.readLine();

    Evaluacion evaEdit = new Evaluacion();
    try{
      evaEdit = colegio.buscarEvaluacion(nombreEvaEdit);
    }catch(EvaluacionNotFoundException e){
      System.out.println("error");
      return;
    }
    
    while(true){
      System.out.println("Ingrese elemento a editar");
      System.out.println("0. Salir");//botón llamado volver al menu
      System.out.println("1. Fecha");
      System.out.println("2. Unidad");
      System.out.println("3. Asignatura");
      System.out.println("4. Nota");
      System.out.println("5. Pregunta");
      String elementEvaEdit = lector.readLine();      

      if(elementEvaEdit == null){
        return;
      }
      switch(elementEvaEdit){
        case "Salir":   
          return;
          
        case "Fecha":
          System.out.println("Ingrese nueva fecha en el formato dd-mm-aaaa");
          String newFecha = lector.readLine();   
          evaEdit.setFecha(newFecha);
          break;
          
        case "Unidad":
          System.out.println("Ingrese nueva unidad");
          String newUnidad = lector.readLine();   
          evaEdit.setUnidad(newUnidad);
          
          colegio.eliminarEvaluacion(nombreEvaEdit,newUnidad);
          colegio.agregarEvaluacion(evaEdit);
          break;
          
        case "Asignatura":
          System.out.println("Ingrese nueva asignatura");
          String newAsignatura = lector.readLine();   
          evaEdit.setAsignatura(newAsignatura);
          break;

        case"Nota":
          editNota(lector,evaEdit);
          break;          

        case "Pregunta":
          editPregunta(evaEdit,lector);
          break;
          
        default:
          System.out.println("Ingrese opción válida");
          break;
      }
    }   
  }

  /**
   * Edita una pregunta con ingresandole su evaluación
   * 
   * @param eva Evaluación de la pregunta a editar
   * @param lector Lector de la consola
   * @throws IOException Error de I/O
   */
  public void editPregunta(Evaluacion eva, BufferedReader lector)throws IOException{

    System.out.println("Ingrese la pregunta que quiera editar");
    String nomPreg = lector.readLine();
    Pregunta preg = eva.buscarPregunta(nomPreg);
    if(preg == null){
      System.out.println("La pregunta no se encuentra registrada.");
      return;
    }

    System.out.println("Ingrese el tipo de pregunta que quiera editar");
    String tipoPreg = lector.readLine();

    switch(tipoPreg){
      case "Desarrollo":
         PreguntaDesarrollo ppDesa = (PreguntaDesarrollo) preg;
         while(true){
          System.out.println("1. Tema ");
          System.out.println("2. Respuesta esperada ");
          System.out.println("3. El enunciado de la pregunta");
          System.out.println("0. No hay más por editar");
          int opcion = Integer.parseInt(lector.readLine());
      
          switch(opcion){
            case 1:
              System.out.println("Ingrese el nuevo tema: ");
              String tema = lector.readLine();
              ppDesa.setTema(tema);
            break;
          
            case 2:
              System.out.println("Cual es la respuesta esperada?");
              String altCor = lector.readLine();
              ppDesa.setRespEsperada(altCor);
              break;
          
           case 3:
              System.out.println("Ingrese el nuevo enunciado de la pregunta:");
              String pregunta = lector.readLine();
              ppDesa.setPregunta(pregunta);
             break;
          
            case 0:
              return;
    
           default:
          
         }
       }

      case "Alternativas":
        PreguntaAlternativas ppAlt = (PreguntaAlternativas) preg;
        while(true){
          System.out.println("1. Tema ");
          System.out.println("2. Alternativas");
          System.out.println("3. Alternativa Correcta");
          System.out.println("4. El enunciado de la pregunta");
          System.out.println("0. No hay más por editar");
          int opcion = Integer.parseInt(lector.readLine());
      
          switch(opcion){
            case 1:
              System.out.println("Ingrese el nuevo tema: ");
              String tema = lector.readLine();
              ppAlt.setTema(tema);
            break;
          
            case 2:
              ArrayList <String> alternativas = (ArrayList <String>) ppAlt.getAlternativas();
              System.out.println("Escoga cual alternativa desea cambiar:");
          
              ArrayList<Character> letrasArray = new ArrayList<>();
              for (char letra = 'a'; letra <= 'z'; letra++) {
                letrasArray.add(letra);
              }
          
              for(int i = 0; i < alternativas.size(); i++){
                String alt = alternativas.get(i);
                System.out.println(letrasArray.get(i) + ") " + alt);
              }
              String alter = lector.readLine();
              char [] aux = alter.toCharArray();
              int posicion = 0;
              for(int i = 0; i<letrasArray.size(); i++) {
                if(letrasArray.get(i) == aux[0]){
                  posicion = i;
                  break;
                }
              } 
          
              System.out.println(posicion);
          
              System.out.println("Ingrese la nueva alternativa: ");
              String nuevaAlter = lector.readLine();
              ppAlt.setAlternativa(nuevaAlter, posicion);
              break;
          
            case 3:
              System.out.println("Cual es la alternativa correcta?");
              String altCor = lector.readLine();
              char chars = (!altCor.isEmpty()) ? altCor.charAt(0) : '\0';
              ppAlt.setAltCorrecta(chars);          
              break;
          
           case 4:
              System.out.println("Ingrese el nuevo enunciado de la pregunta:");
              String pregunta = lector.readLine();
              ppAlt.setPregunta(pregunta);
             break;
          
            case 0:
              return;
    
           default:
          
         }
       }

      default:
    }

  }

  /**
   * Método que edita una pregunta
   * @param lector Lector de la consola 
   * @throws IOException Error de I/O.
   */
  public void editPregunta(BufferedReader lector)throws IOException{
    System.out.println("Ingrese la evaluacion de la cual quiere editar la pregunta");
    String nombre = lector.readLine();
    
    Evaluacion eva = new Evaluacion();
    try{
      eva = colegio.buscarEvaluacion(nombre);
    }catch(EvaluacionNotFoundException e){
      return;
    }
    

    System.out.println("Ingrese la pregunta que quiera editar");
    String nomPreg = lector.readLine();
    Pregunta preg = eva.buscarPregunta(nomPreg);
    if(preg == null){
      System.out.println("La pregunta no se encuentra registrada.");
      return;
    }

    System.out.println("Ingrese el tipo de pregunta que quiera editar");
    String tipoPreg = lector.readLine();

    switch(tipoPreg){
      case "Desarrollo":
         PreguntaDesarrollo ppDesa = (PreguntaDesarrollo) preg;
         while(true){
          System.out.println("1. Tema ");
          System.out.println("2. Respuesta esperada ");
          System.out.println("4. El enunciado de la pregunta");
          System.out.println("0. No hay más por editar");
          int opcion = Integer.parseInt(lector.readLine());
      
          switch(opcion){
            case 1:
              System.out.println("Ingrese el nuevo tema: ");
              String tema = lector.readLine();
              ppDesa.setTema(tema);
            break;
          
            case 2:
              System.out.println("Cual es la respuesta esperada?");
              String altCor = lector.readLine();
              ppDesa.setRespEsperada(altCor);
              break;
          
           case 3:
              System.out.println("Ingrese el nuevo enunciado de la pregunta:");
              String pregunta = lector.readLine();
              ppDesa.setPregunta(pregunta);
             break;
          
            case 0:
              return;
    
           default:
          
         }
       }

      case "Alternativas":
        PreguntaAlternativas ppAlt = (PreguntaAlternativas) preg;
        while(true){
          System.out.println("1. Tema ");
          System.out.println("2. Alternativas");
          System.out.println("3. Alternativa Correcta");
          System.out.println("4. El enunciado de la pregunta");
          System.out.println("0. No hay más por editar");
          int opcion = Integer.parseInt(lector.readLine());
      
          switch(opcion){
            case 1:
              System.out.println("Ingrese el nuevo tema: ");
              String tema = lector.readLine();
              ppAlt.setTema(tema);
            break;
          
            case 2:
              ArrayList <String> alternativas = (ArrayList <String>) ppAlt.getAlternativas();
              System.out.println("Escoga cual alternativa desea cambiar:");
          
              ArrayList<Character> letrasArray = new ArrayList<>();
              for (char letra = 'a'; letra <= 'z'; letra++) {
                letrasArray.add(letra);
              }
          
              for(int i = 0; i < alternativas.size(); i++){
                String alt = alternativas.get(i);
                System.out.println(letrasArray.get(i) + ") " + alt);
              }
              String alter = lector.readLine();
              char [] aux = alter.toCharArray();
              int posicion = 0;
              for(int i = 0; i<letrasArray.size(); i++) {
                if(letrasArray.get(i) == aux[0]){
                  posicion = i;
                  break;
                }
              } 
          
              System.out.println(posicion);
          
              System.out.println("Ingrese la nueva alternativa: ");
              String nuevaAlter = lector.readLine();
              ppAlt.setAlternativa(nuevaAlter, posicion);
              break;
          
            case 3:
              System.out.println("Cual es la alternativa correcta?");
              String altCor = lector.readLine();
              char chars = (!altCor.isEmpty()) ? altCor.charAt(0) : '\0';
              ppAlt.setAltCorrecta(chars);          
              break;
          
           case 4:
              System.out.println("Ingrese el nuevo enunciado de la pregunta:");
              String pregunta = lector.readLine();
              ppAlt.setPregunta(pregunta);
             break;
          
            case 0:
              return;
    
           default:
          
         }
       }

      default:
    }

  }
  
  /**
   * Método que edita una nota
   * @param lector Lector de la consola 
   * @param eva Evaluación donde se editará la nota.
   * @throws IOException Error de I/O.
   */
  public void editNota(BufferedReader lector, Evaluacion eva)throws IOException{
    
    System.out.println("Ingrese el alumno cuya nota desea editar");
    String nomAlu = lector.readLine();
    Nota nn = eva.buscarNota(nomAlu);
    if(nn == null){
      System.out.println("La nota no se encuentra registrada.");
      return;
    }

    while(true){
      System.out.println("0. Salir");
      System.out.println("1. Nota ");
      System.out.println("2. Alumno");
      String opcion = lector.readLine();
      int opcion1 = Integer.parseInt(opcion);
      
      switch(opcion1){
        case 0:
          return;
          
        case 1:
          System.out.println("Ingrese nueva nota del alumno "+ nn.getAlumno());
          String newNota = lector.readLine();   
          double novoNota = Double.parseDouble(newNota);
          nn.setNota(novoNota);
          break;
          
        case 2:
          System.out.println("Ingrese nuevo nombre del alumno");
          String newAlu = lector.readLine();   
          nn.setAlumno(newAlu);
          break;
          
        default:
          System.out.println("Ingrese una opción válida");
          break;
          
      }
    }
  }

  /**
   * Método que agrega una nota
   * @param lector Lector de la consola 
   * @throws IOException Error de I/O.
   */
  public void agregarNota(BufferedReader lector)throws IOException{
    System.out.println("Ingrese la evaluacion a la cual quiere agregar la nota");
    String nombre = lector.readLine();
    
    Evaluacion eva = new Evaluacion();
    try{
      eva = colegio.buscarEvaluacion(nombre);
    }catch(EvaluacionNotFoundException e){
      return;
    }
    
    System.out.println("Ingrese el nombre del alumno");
    String nomAlu = lector.readLine();

    System.out.println("Ingrese el nota del alumno");
    String newNota = lector.readLine();
    double novoNota = Double.parseDouble(newNota);
    
    Nota nn = new Nota(novoNota,nomAlu);
    if(eva.anadirNota(nn)){
      System.out.println("Se agregó la nota con éxito");
    }
    else{
      System.out.println("El alumno ya tenía una nota añadida");
    }
    return;
  }

  /**
   * Método que elimina una evaluacion
   * @param lector Lector de la consola 
   * @throws IOException Error de I/O.
   */
  public void eliminarEvaluacion(BufferedReader lector)throws IOException{
    System.out.println("Ingrese unidad de la evaluacion a eliminar");
    String nombreEvaEdit = lector.readLine();

    if(colegio.eliminarEvaluacion(nombreEvaEdit)){
      System.out.println("Eliminación exitosa");
    }
    else{
      System.out.println("No se encontró la evaluación");
    }
  }

  /**
   * Método que elimina una pregunta
   * @param lector Lector de la consola 
   * @throws IOException Error de I/O.
   */
  public void eliminarPregunta(BufferedReader lector)throws IOException{
    System.out.println("Ingrese la evaluacion de la cual quiere eliminar la pregunta");
    String nombre = lector.readLine();
    
    Evaluacion eva = new Evaluacion();
    try{
      eva = colegio.buscarEvaluacion(nombre);
    }catch(EvaluacionNotFoundException e){
      return;
    }
    
    System.out.println("Ingrese la pregunta que quiere eliminar");
    String nomPreg = lector.readLine();
    Pregunta pp = eva.buscarPregunta(nomPreg);
    if(pp == null){
      System.out.println("La pregunta no se encuentra registrada.");
      return;
    }

    eva.eliminarPregunta(nomPreg);
    System.out.println("Eliminación exitosa"); 
  }

  /**
   * Método que elimina una nota
   * @param lector Lector de la consola 
   * @throws IOException Error de I/O.
   */
  public void eliminarNota(BufferedReader lector)throws IOException{
    System.out.println("Ingrese la evaluacion de la cual quiere editar la nota");
    String nombre = lector.readLine();
    
    Evaluacion eva = new Evaluacion();
    try{
      eva = colegio.buscarEvaluacion(nombre);
    }catch(EvaluacionNotFoundException e){
      return;
    }
    
    System.out.println("Ingrese el alumno cuya nota desea editar");
    String nomAlu = lector.readLine();
    Nota nn = eva.buscarNota(nomAlu);
    if(nn == null){
      System.out.println("La nota no se encuentra registrada.");
      return;
    }

    eva.eliminarNota(nomAlu);
    System.out.println("Eliminación exitosa"); 
  }  
  
  /**
   * Método que muestra todas las notas
   * @param lector Lector de la consola 
   * @throws IOException Error de I/O.
   */
  public void mostrarNotas(BufferedReader lector)throws IOException{
    System.out.println("Ingrese unidad de la evaluacion");
    String nombre = lector.readLine();
    
    Evaluacion eva = new Evaluacion();
    try{
      eva = colegio.buscarEvaluacion(nombre);
    }catch(EvaluacionNotFoundException e){
      System.out.println("La evaluación no se encuentra registrada");
      return;
    }
    ArrayList <Nota> notas = eva.getNotas();
    if(notas.isEmpty()){
      System.out.println("No hay notas registradas para esta evaluacion");
    }
    
    for(int i = 0; i < notas.size(); i++){
      Nota nn = notas.get(i);
      System.out.println("Alumno: " + nn.getAlumno() + "  Nota :" + nn.getNota());
    } 
  }

  /**
   * Método que muestra todas los parametros de una evaluacion.
   * @param lector Lector de la consola 
   * @throws IOException Error de I/O.
   */

  public void mostrarEvaluacion(BufferedReader lector)throws IOException{
    //Se agrega una evaluación a una asignatura en específico
    System.out.println("Ingrese la unidad de la evaluacion a la que desea añadir la pregunta: ");
    String nombreEva = lector.readLine();
    //Si la asignatura no existe se notifica
    Evaluacion eva = new Evaluacion();
    try{
      eva = colegio.buscarEvaluacion(nombreEva);
    }catch (EvaluacionNotFoundException e){
      System.out.println("La evaluación no se encuentra registrada");
      return;
    }


    ArrayList <Pregunta> preguntas =  eva.getPreguntas();
    int tamano = preguntas.size();
      String cantPreg = Integer.toString(tamano);
      
      System.out.println("Asignatura: "+ eva.getAsignatura() + "\n" + "Unidad: " + eva.getUnidad() + "\n" + "Fecha: " + eva.getFecha() + "\n");
      
        
      for(int j = 0 ; j < preguntas.size() ; j++){
        Pregunta pp = preguntas.get(j);
        String tipo;
        if(pp instanceof PreguntaDesarrollo){
          PreguntaDesarrollo ppDes = (PreguntaDesarrollo) pp;
          tipo = "* Pregunta de desarrollo *";
          System.out.println("\n" + tipo + "\n" + "Pregunta: " + ppDes.getPregunta() + "\n" + "Tema: " + ppDes.getTema() + "\n" + "Respuesta esperada: "+ppDes.getRespEsperada() + "\n");
        }else{
          PreguntaAlternativas ppAlt = (PreguntaAlternativas) pp;
          tipo = "* Pregunta de Alternativas *";
          ArrayList <String> alternativas = ppAlt.getAlternativas();
          int tamano2 = alternativas.size();
          String cantAlt = Integer.toString(tamano2);
          System.out.println("\n" + tipo + "\n" + "Pregunta: " + ppAlt.getPregunta() + "\n" + "Tema: " + ppAlt.getTema() + "\n");

          ArrayList<Character> letrasArray = new ArrayList<>();
            for (char letra = 'a'; letra <= 'z'; letra++) {
            letrasArray.add(letra);
          }
          
          for (int k = 0 ; k < alternativas.size() ; k++){
            String alt = alternativas.get(k);
            System.out.println(letrasArray.get(k) + ") " + alt + "\n");
          }
          System.out.println("Alternativa correcta: " + ppAlt.getAltCorrecta() + "\n");
        }
      }

      ArrayList <Nota> notas = eva.getNotas();

      int tamano3 = notas.size();
      String cantNotas = Integer.toString(tamano3);

      System.out.println("\n" + "* Notas de los alumnos en la prueba *" + "\n");

      for(int l = 0 ; l < notas.size() ; l++){
        Nota nn = notas.get(l);
        System.out.println("Nota: " + nn.getNotaString() + "  Alumno: " + nn.getAlumno() + "\n");
      }
  }

  /**
  *Importa las evaluaciones desde un archivo CSV
  *@throws IOException si ocurre un error I/O al leer el archivo
  */

  public void importar() throws IOException {
    CSV csv = new CSV("Datos");
    
    String linea = csv.firstLine();
    linea=csv.nextLine();
    int i = 0; //inidca cada elemento recorrido
    while(linea!=null){  
      i = 0;
      Evaluacion ee = new Evaluacion(); 
      ee.setAsignatura(csv.get_csvField(linea,i));
      i++;//1
      ee.setUnidad(csv.get_csvField(linea,i));
      i++;//2
      ee.setFecha(csv.get_csvField(linea,i));
      i++;//3
      int cantPreg = Integer.parseInt(csv.get_csvField(linea,i));
      i++;//4
      
      while((csv.get_csvField(linea,i)) != null){

        //Preguntas
        for(int j = 0; j < cantPreg;j++){
          /*
          Pregunta pp = new Pregunta();
          pp.setPregunta(csv.get_csvField(linea,i));
          i++;//5
          pp.setTema(csv.get_csvField(linea,i));
          i++;//6
          */
          String preg = csv.get_csvField(linea,i);
          i++;
          String Tem = csv.get_csvField(linea,i);
          i++;

          //tipo de pregunta
          String tipoPreg = csv.get_csvField(linea,i);
          i++;
          
          //Pregunta de desarrollo
          if(tipoPreg.equals("des")){
            PreguntaDesarrollo ppDes = new PreguntaDesarrollo();
            ppDes.setPregunta(preg);
            ppDes.setTema(Tem);
            
            String altCorr = csv.get_csvField(linea,i);
            ppDes.setRespEsperada(altCorr);
            i++;
            colegio.anadirPregunta(ppDes, ee);
          }
          //Pregunta de alternativa
          if(tipoPreg.equals("alt")){
            //Alternativas
            PreguntaAlternativas ppAlt = new PreguntaAlternativas();
            ppAlt.setPregunta(preg);
            ppAlt.setTema(Tem);
              
            int cantAlt = Integer.parseInt(csv.get_csvField(linea,i));
            i++;
            
            for(int k = 0; k < cantAlt;k++){
              ppAlt.setAlternativa(csv.get_csvField(linea,i));
              i++;
            }
            String altCorrecta = csv.get_csvField(linea, i);
            char chars = (!altCorrecta.isEmpty()) ? altCorrecta.charAt(0) : '\0';
            ppAlt.setAltCorrecta(chars);
            i++;
            colegio.anadirPregunta(ppAlt, ee);
          }
        }

        int cantNotas = Integer.parseInt(csv.get_csvField(linea,i));
        i++;
        for(int j = 0; j < cantNotas; j++){
          Nota nn = new Nota();
          double nota = Double.parseDouble(csv.get_csvField(linea, i));
          i++;
          nn.setNota(nota);
          nn.setAlumno(csv.get_csvField(linea, i));
          i++;
          ee.anadirNota(nn); 
        }
      }
      colegio.agregarEvaluacion(ee);
      linea=csv.nextLine();
    }
    csv.close();
    
  }

  /**
  * Exporta las evaluaciones a un archivo CSV
  *@throws IOException si ocurre un error I/O al escribir el archivo.
  */

  public void exportar()throws IOException{
    PrintWriter escritor = new PrintWriter(new BufferedWriter(new FileWriter(new File("Datos.csv"))));
    
    escritor.println("ASIGNATURA;UNIDAD;FECHA;CANTPREG;PREGUNTA;TEMA;TIPOPREGUNTA;RESPUESTACORRECTA;CANTALT;ALTERNATIVAS;ALTCORRECTA;CANTNOTAS;NOTA;ALUMNO");
    //escritor.newLine();
    
    ArrayList <Evaluacion> evaluaciones = colegio.getEvaluaciones();
    
    for(int i = 0 ; i < evaluaciones.size(); i++){
      Evaluacion eva = evaluaciones.get(i);
      ArrayList <Pregunta> preguntas =  eva.getPreguntas();
      
      int tamano = preguntas.size();
      String cantPreg = Integer.toString(tamano);
      
      escritor.print(eva.getAsignatura() + ";" + eva.getUnidad() + ";" + eva.getFecha() + ";" + cantPreg + ";");
      
      for(int j = 0 ; j < preguntas.size() ; j++){
        Pregunta pp = preguntas.get(j);
        String tipo;
        if(pp instanceof PreguntaDesarrollo){
          PreguntaDesarrollo ppDes = (PreguntaDesarrollo) pp;
          tipo = "des";
          escritor.print(ppDes.getPregunta() + ";" + ppDes.getTema()+ ";" + tipo + ";"+ ppDes.getRespEsperada() + ";");
        }else{
          PreguntaAlternativas ppAlt = (PreguntaAlternativas) pp;
          tipo = "alt";
          ArrayList <String> alternativas = ppAlt.getAlternativas();
          int tamano2 = alternativas.size();
          String cantAlt = Integer.toString(tamano2);
          escritor.print(ppAlt.getPregunta() + ";" + ppAlt.getTema() + ";" + tipo + ";" + cantAlt + ";");
  
          for (int k = 0 ; k < alternativas.size() ; k++){
            String alt = alternativas.get(k);
            escritor.print(alt + ";");
          }
          escritor.print(ppAlt.getAltCorrecta() + ";");
        }
      }

      ArrayList <Nota> notas = eva.getNotas();

      int tamano3 = notas.size();
      String cantNotas = Integer.toString(tamano3);

      escritor.print(cantNotas + ";");

      for(int l = 0 ; l < notas.size() ; l++){
        Nota nn = notas.get(l);
        escritor.print(nn.getNotaString() + ";" + nn.getAlumno() + ";");
      }
     escritor.println();
    }
    escritor.close();
  }

  /**
   *genera un reporte de las evaluaciones y lo guarda en un archivo csv
   *@throws IOException Si ocurre un error I/O al escribir en el archivo
   */

  public void reporte()throws IOException{
    PrintWriter escritor = new PrintWriter(new BufferedWriter(new FileWriter(new File("reporte.csv"))));
    
    //escritor.println("ASIGNATURA;UNIDAD;FECHA;CANTPREG;PREGUNTA;TEMA;TIPOPREGUNTA;RESPUESTACORRECTA;CANTALT;ALTERNATIVAS;ALTCORRECTA;CANTNOTAS;NOTA;ALUMNO");
    //escritor.newLine();
    
    ArrayList <Evaluacion> evaluaciones = colegio.getEvaluaciones();
    
    for(int i = 0 ; i < evaluaciones.size(); i++){
      Evaluacion eva = evaluaciones.get(i);
      ArrayList <Pregunta> preguntas =  eva.getPreguntas();
      
      int tamano = preguntas.size();
      String cantPreg = Integer.toString(tamano);
      
      escritor.print("Asignatura: "+ eva.getAsignatura() + "\n" + "Unidad: " + eva.getUnidad() + "\n" + "Fecha: " + eva.getFecha() + "\n");
      
        
      for(int j = 0 ; j < preguntas.size() ; j++){
        Pregunta pp = preguntas.get(j);
        String tipo;
        if(pp instanceof PreguntaDesarrollo){
          PreguntaDesarrollo ppDes = (PreguntaDesarrollo) pp;
          tipo = "* Pregunta de desarrollo *";
          escritor.print("\n" + tipo + "\n" + ppDes.contenidos());
        }else{
          PreguntaAlternativas ppAlt = (PreguntaAlternativas) pp;
          tipo = "* Pregunta de Alternativas *";
          ArrayList <String> alternativas = ppAlt.getAlternativas();
          int tamano2 = alternativas.size();
          String cantAlt = Integer.toString(tamano2);
          escritor.print("\n" + tipo + "\n" + ppAlt.contenidos());

        }
      }

      ArrayList <Nota> notas = eva.getNotas();

      int tamano3 = notas.size();
      String cantNotas = Integer.toString(tamano3);

      escritor.print("\n" + "* Notas de los alumnos en la prueba *" + "\n");

      for(int l = 0 ; l < notas.size() ; l++){
        Nota nn = notas.get(l);
        escritor.print("Nota: " + nn.getNotaString() + "  Alumno: " + nn.getAlumno() + "\n");
      }
      //Imprimir promedio
      //escritor.print("Nota: " + nn.getNotaString() + "  Alumno: " + nn.getAlumno() + "\n");
      escritor.println("\n" + "=============================================================================================================");
      escritor.println("");
      
    }
    escritor.close();
    System.out.pinrtln("El reporte se realizó con éxito");
  }
  
}