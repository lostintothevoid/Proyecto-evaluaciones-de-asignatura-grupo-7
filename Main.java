import java.io.*;
import java.util.ArrayList;

class Main {
  public static void main(String[] args){
    Colegio colegio = new Colegio();
    
  }
}
//primera coleccion A
public class Colegio{
  private ArrayList <tipoAsignatura> asignaturas;
  private HashMap <String,tipoAsignatura> mapaAsignaturas;
  private int ultimo;
  
  public Colegio(){
    //largo = tamano;
    asignaturas = new ArrayList();
    mapaAsignaturas = new HashMap();
  
    ultimo=0;
  }

  public tipoAsignatura buscar(String nombre){
    if(asignatura.isEpmty()== true){
      return null;
    }
    if(mapaAsinatura.constainKey(nombre)== true){
      /*
      posible futuro cambio
      return asignatura.indexof(mapaAsignatura.get(nombre));
      */
      return mapaAsignatura.get(nombre);
    }
    return null;
  }

  public boolean agregar(tipoAsignatura asignatura){
    if(ultimo == asignaturas.size()) return false;
    if(buscar(nombre)==null) return false;

    asignaturas.add(asignatura);
    mapaAsignaturas.put(asignatura.getNombre(),asignatura);
    ultimo++;
    return true;
  }

  public void eliminar (String nombre){
    tipoAsignatura asigna = buscar(nombre);
    
    if (mapaAsignaturas.contains(asigna) == false){
      println("La asignatura no existe");
      return;
    }
    else{
      //Busco en el ArrayList
      for(int i=0; i < asignaturas.size(); i++){
        if(asignaturas.get(i) == asigna){
          asignaturas.remove(i);
          mapaAsignaturas.remove(asigna);//Eliminar del mapa
          println("La asignatura ha sido borrada con exito");
          return;
        }
      }
    }
  }

  public void listarAsignaturas(){
    system.out.println("Asignaturas:");
    for(int i = 0; i <= asignaturas.size(); i++){
      system.out.println(asignatura.get(i).getNombre());
    }
  }
  
}

public class tipoAsignatura{
  public String nombreAsignatura;
  public String[] evaluaciones; //por mientras solo pongo un arreglo de strings para los nombres de las evaluaciones
  public int cantEvaluaciones;
  
  public tipoAsignatura(String nombre, int tamano){
    nombreAsignatura = nombre;
    cantEvaluaciones = tamano;
    evaluaciones = new String[tamano];
    
  }
  public String getNombre(){
    return nombreAsignatura;
  }
  
}
