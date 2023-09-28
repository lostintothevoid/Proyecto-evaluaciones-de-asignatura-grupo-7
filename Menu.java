import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;

public class Menu {
  Colegio colegio;
  
  public Menu(Colegio colegio){
    this.colegio = colegio;
  }
  
  public void opciones() throws IOException,AbrirArchivoException{
   
    // se utiliza el lector para registrar la eleccion del usuario
    BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
    
    while(true){
      //Opciones
      System.out.println("Ingrese 1 para agregar una evaluacion");
      System.out.println("Ingrese 2 para agregar una pregunta");
      System.out.println("Ingrese 3 para ver todas las evaluaciones de una asignatura");
      System.out.println("Ingrese 4 para ver todas las preguntas de una evaluacion");
      System.out.println("Ingrese 5 para ver todas las evaluaciones");
      System.out.println("Ingrese 6 para editar una evaluación");
      System.out.println("Ingrese 7 para editar una pregunta de una evaluación");
      System.out.println("Ingrese 8 para agregar una nota");
      System.out.println("Ingrese 9 para eliminar una evaluación");
      System.out.println("Ingrese 10 para eliminar una pregunta");
      System.out.println("Ingrese 11 para eliminar una nota");
      System.out.println("Ingrese 0 para salir de la aplicación");
      
      System.out.println("");

      int opcion = Integer.parseInt(lector.readLine());
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
          verEvaluacionesAsignatura(lector);
          System.out.println("");
          break;
        case 4:
          verPreguntasEva(lector);
          System.out.println("");
          break;
        case 5:
          verEvaluaciones(lector);
          System.out.println("");
          break;
        case 6:
          editEvaluacion(lector);
          System.out.println("");
          break;
        case 7:
          editPregunta(lector);
          System.out.println("");
          break;
        case 8:
          agregarNota(lector);
          System.out.println("");
          break;
        case 9:
          eliminarEvaluacion(lector);
          System.out.println("");
          break;
        case 10:
          eliminarPregunta(lector);
          System.out.println("");
          break;
        case 11:
          eliminarNota(lector);
          System.out.println("");
          break;
        default:
          System.out.println("No se ingresó una opción válida");
          break;
          
      }
    }  
  }

  public void agregarEvaluacion(BufferedReader lector)throws IOException{
    //Se agrega una evaluacion nueva.
    System.out.println("Ingrese el nombre de la evaluacion que desea agregar: ");
    String evaNueva = lector.readLine();

    Evaluacion evaNuevaEntera = colegio.buscarEvaluacion(evaNueva);
    if(evaNuevaEntera != null){
      System.out.println ("La evaluacion ya se encuentra registrada");
      return;
    }

    System.out.println ("Ingrese fecha");
    String fecha = lector.readLine();
    
    System.out.println ("Ingrese asignatura");
    String asignatura = lector.readLine();

    //ingreso de notas
    System.out.println ("Ingrese cantidad de notas a insertar");
    String lec = lector.readLine(); 
    int cantNotas = Integer.parseInt(lec);

    ArrayList <Nota> notas = new ArrayList();
    for(int i = 0 ;i < cantNotas ; i++){
      System.out.println ("Ingrese nota n°"+(i+1));
      String lex = lector.readLine();
      double notaAct = Double.parseDouble(lex);
      
      System.out.println ("Ingrese estudiante de nota n°"+(i+1));
      String aluAct = lector.readLine();
      
      Nota newNot = new Nota(notaAct, aluAct);
      notas.add(newNot);
    }

    System.out.println ("Ingrese cantidad de preguntas a insertar");
    String luc = lector.readLine(); 
    int cantPreguntas = Integer.parseInt(luc);

    ArrayList <Pregunta> preguntas = new ArrayList();
    for(int i = 0 ;i < cantPreguntas ; i++){
      System.out.println("Ingrese la pregunta n°" + (i+1) + ": ");
      String nomPregunta = lector.readLine();

      System.out.println("Ingrese el tema de la pregunta: ");
      String tema = lector.readLine();

      System.out.println("Ingrese la cantidad de alternativas que tendrá la pregunta");
      String aux = lector.readLine();
      int cant = Integer.parseInt(aux);
      
      System.out.println("Ingrese las alternativas respuestas a la pregunta: ");
      ArrayList<String> alternativas = new ArrayList();
      int contador = 1;
      while(contador<=cant){
        System.out.println("Ingrese alternativa "+contador+": ");
        String alt = lector.readLine();
        alternativas.add(alt);
        contador++;
      }
      System.out.println("Ingrese la alternativa correcta");
      String altCorrecta = lector.readLine();

      Pregunta pp = new Pregunta(nomPregunta, tema, alternativas, altCorrecta);
      preguntas.add(pp);
    }

    Evaluacion eva = new Evaluacion(evaNueva, asignatura, fecha, notas, preguntas);
    colegio.agregarEvaluacion(eva);
  }

  public void agregarPregunta(BufferedReader lector)throws IOException{
    //Se agrega una evaluación a una asignatura en específico
    System.out.println("Ingrese la unidad de la evaluacion a la que desea añadir la pregunta: ");
    String nombreEva = lector.readLine();
    //Si la asignatura no existe se notifica
    
      Evaluacion ee = colegio.buscarEvaluacion(nombreEva);
    /*
      if()
      System.out.println("La no hay Asignatura registrada");
      System.out.println("");
    }catch(noEstaException e){
      System.out.println("La evaluacion no se encuentra registrada");
      System.out.println("");      
    }
    */
    System.out.println("Ingrese la pregunta: ");
    String nomPregunta = lector.readLine();

    System.out.println("Ingrese el tema de la pregunta: ");
    String tema = lector.readLine();

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

    Pregunta pp = new Pregunta(nomPregunta, tema, alternativas, altCorrecta);
    //Se agrega la evaluacion a la asignatura correspondiente
    colegio.anadirPregunta(pp, ee);
  }
  
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
    
  public void verPreguntasEva(BufferedReader lector)throws IOException{
    //Se muestran todas las preguntaspreguntas de una evaluacion
    System.out.println("Ingrese unidad de la evaluacion");

    String nombre = lector.readLine();
    Evaluacion eva = colegio.buscarEvaluacion(nombre);
    if(eva==null){
      System.out.println("La evaluación no se encuentra registrada");
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
      System.out.println("Pregunta " + (i+1) + ": " + pp.getPregunta());
      ArrayList<String> alternativas = pp.getAlternativas();
      if(alternativas.isEmpty()){
        System.out.println("No hay alternativas registradas para esta pregunta");
      }else{
        for(int j = 0; j < alternativas.size() ; j++){
          String alt = alternativas.get(j);
          System.out.println(letrasArray.get(j) + ") " + alt);
        }
        System.out.println("Alternativa Correcta: " + pp.getAltCorrecta());
      } 
    }
  }
    
  public void verEvaluaciones(BufferedReader lector)throws IOException{
    ArrayList <Evaluacion> arryEva = colegio.getEvaluaciones();
    if(arryEva.isEmpty()){
      System.out.println("no ai na");
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

  public void editEvaluacion(BufferedReader lector)throws IOException{
    System.out.println("Ingrese unidad de la evaluacion a editar");
    String nombreEvaEdit = lector.readLine();

    Evaluacion evaEdit = colegio.buscarEvaluacion(nombreEvaEdit);
    if(evaEdit == null){
      System.out.println("La evaluacion no existe");
      return;
    }

    while(true){
      System.out.println("Ingrese elemento a editar");
      System.out.println("0. Salir");//botón llamado volver al menu
      System.out.println("1. Fecha");
      System.out.println("2. Unidad");
      System.out.println("3. Asignatura");
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
          
        default:
          System.out.println("Ingrese opción válida");
          break;
      }
    }   
  }

  public void editPregunta(Evaluacion eva, BufferedReader lector)throws IOException{
    
    System.out.println("Ingrese la pregunta que quiera editar");
    String nomPreg = lector.readLine();
    Pregunta pp = eva.buscarPregunta(nomPreg);
    if(pp == null){
      System.out.println("La pregunta no se encuentra registrada.");
      return;
    }
    //int cont=0;
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
          pp.setTema(tema);
          break;
          
        case 2:
          ArrayList <String> alternativas = (ArrayList <String>) pp.getAlternativas();
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
          pp.setAlternativa(nuevaAlter, posicion);
          break;
          
        case 3:
          System.out.println("Cual es la alternativa correcta?");
          String altCor = lector.readLine();
          
          while(true){
            if(!pp.confirmarAlternativa(altCor)){
              System.out.println("La alternativa correcta no está entre las alternativas");
              altCor = lector.readLine();
            }
            else{
              pp.setAltCorrecta(altCor);
              break;
            }
          }
          break;
          
        case 4:
          System.out.println("Ingrese el nuevo enunciado de la pregunta:");
          String pregunta = lector.readLine();
          pp.setPregunta(pregunta);
          break;
          
        case 0:
          return;

        default:
          
      }
    }
  }
  
  public void editPregunta(BufferedReader lector)throws IOException{
    System.out.println("Ingrese la evaluacion de la cual quiere editar la pregunta");
    String nombre = lector.readLine();
    
    Evaluacion eva = colegio.buscarEvaluacion(nombre);
    if(eva == null){
      System.out.println("La evaluación no se encuentra registrada.");
      return;
    }
    System.out.println("Ingrese la pregunta que quiera editar");
    String nomPreg = lector.readLine();
    Pregunta pp = eva.buscarPregunta(nomPreg);
    if(pp == null){
      System.out.println("La pregunta no se encuentra registrada.");
      return;
    }
    //int cont=0;
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
          pp.setTema(tema);
          break;
          
        case 2:
          ArrayList <String> alternativas = (ArrayList <String>) pp.getAlternativas();
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
          pp.setAlternativa(nuevaAlter, posicion);
          break;
          
        case 3:
          System.out.println("Cual es la alternativa correcta?");
          String altCor = lector.readLine();
          
          while(true){
            if(!pp.confirmarAlternativa(altCor)){
              System.out.println("La alternativa correcta no está entre las alternativas");
              altCor = lector.readLine();
            }
            else{
              pp.setAltCorrecta(altCor);
              break;
            }
          }
          break;
          
        case 4:
          System.out.println("Ingrese el nuevo enunciado de la pregunta:");
          String pregunta = lector.readLine();
          pp.setPregunta(pregunta);
          break;
          
        case 0:
          return;

        default:
          
      }
    }
  }
  
  public void editNota(BufferedReader lector)throws IOException{
    System.out.println("Ingrese la evaluacion de la cual quiere editar la nota");
    String nombre = lector.readLine();
    Evaluacion eva = colegio.buscarEvaluacion(nombre);
    if(eva == null){
      System.out.println("La evaluación no se encuentra registrada.");
      return;
    }
    
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
      
      switch(opcion){
        case "Salir":
          return;
          
        case "Nota":
          System.out.println("Ingrese nueva nota del alumno "+ nn.getAlumno());
          String newNota = lector.readLine();   
          double novoNota = Double.parseDouble(newNota);
          nn.setNota(novoNota);
          break;
          
        case "Alumno":
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

  public void agregarNota(BufferedReader lector)throws IOException{
    System.out.println("Ingrese la evaluacion a la cual quiere agregar la nota");
    String nombre = lector.readLine();
    Evaluacion eva = colegio.buscarEvaluacion(nombre);
    if(eva == null){
      System.out.println("La evaluación no se encuentra registrada.");
      return;
    }
    
    System.out.println("Ingrese el nombre del alumno");
    String nomAlu = lector.readLine();

    System.out.println("Ingrese el nota del alumno");
    String newNota = lector.readLine();
    double novoNota = Double.parseDouble(newNota);
    
    Nota nn = new Nota(novoNota,nomAlu);
    eva.anadirNota(nn);
    return;
  }

  public void eliminarEvaluacion(BufferedReader lector)throws IOException{
    System.out.println("Ingrese unidad de la evaluacion a editar");
    String nombreEvaEdit = lector.readLine();

    Evaluacion evaEdit = colegio.buscarEvaluacion(nombreEvaEdit);
    if(evaEdit == null){
      System.out.println("La evaluacion no existe");
      return;
    }

    colegio.eliminarEvaluacion(nombreEvaEdit);
    System.out.println("Eliminación exitosa");   
  }

  public void eliminarPregunta(BufferedReader lector)throws IOException{
    System.out.println("Ingrese la evaluacion de la cual quiere eliminar la pregunta");
    String nombre = lector.readLine();
    
    Evaluacion eva = colegio.buscarEvaluacion(nombre);
    if(eva == null){
      System.out.println("La evaluación no se encuentra registrada.");
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

  public void eliminarNota(BufferedReader lector)throws IOException{
    System.out.println("Ingrese la evaluacion de la cual quiere editar la nota");
    String nombre = lector.readLine();
    Evaluacion eva = colegio.buscarEvaluacion(nombre);
    if(eva == null){
      System.out.println("La evaluación no se encuentra registrada.");
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

  public void importar() throws AbrirArchivoException, IOException{
    CSV csv = new CSV("exportar");
    if(csv == null){
      throw new AbrirArchivoException();
    }
    String linea = csv.firstLine();
    linea=csv.nextLine();
    int i = 0; //inidca cada elemento recorrido
    while(linea!=null){  
 
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
          Pregunta pp = new Pregunta();
          pp.setPregunta(csv.get_csvField(linea,i));
          i++;//5
          pp.setTema(csv.get_csvField(linea,i));
          i++;//6
          int cantAlt = Integer.parseInt(csv.get_csvField(linea,i));
          i++;//7

          //Alternativas
          for(int k = 0; k < cantAlt;k++){
            pp.setAlternativa(csv.get_csvField(linea,i));
            i++;
          }
          pp.setAltCorrecta(csv.get_csvField(linea, i));
          i++;
          ee.anadirPregunta(pp); 
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

  public void exportar()throws IOException{
    PrintWriter escritor = new PrintWriter(new BufferedWriter(new FileWriter(new File("exportar.csv"))));
    
    escritor.println("ASIGNATURA;UNIDAD;FECHA;CANTPREG;PREGUNTA;TEMA;CANTALT;ALTERNATIVAS;ALTCORRECTA;CANTNOTAS;NOTA;ALUMNO");
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
        ArrayList <String> alternativas = pp.getAlternativas();

        int tamano2 = alternativas.size();
        String cantAlt = Integer.toString(tamano2);
        escritor.print(pp.getPregunta() + ";" + pp.getTema() + ";" + cantAlt + ";");

        for (int k = 0 ; k < alternativas.size() ; k++){
          String alt = alternativas.get(k);
          escritor.print(alt + ";");
        }
        escritor.print(pp.getAltCorrecta() + ";");
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
}