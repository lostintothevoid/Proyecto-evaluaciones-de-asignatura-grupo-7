import java.io.*;
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
      return mapaAsignatura.get(nombre);
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
      return;
    }
    else{
      //Busco en el ArrayList
      for(int i=0; i < asignaturas.size(); i++){
        if(asignaturas.get(i).getNombre().equals(asigna.getNombre())){
          //Se elimina del ArrayList y del HashMap
          asignaturas.remove(i);
          mapaAsignaturas.remove(nombre);
          System.out.println("La asignatura ha sido borrada con exito");
          return;
        }
      }
    }
  }

  public void listarAsignaturas(){
    System.out.println("Asignaturas:");
    for(int i = 0; i < asignaturas.size(); i++){
      System.out.println(asignatura.get(i).getNombre());
    }
  }
}
