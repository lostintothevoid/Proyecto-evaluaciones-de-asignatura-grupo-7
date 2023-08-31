import java.io.*;
import java.util.ArrayList;

public class tipoFecha{
  private ArrayList <tipoEvaluacion> evaluaciones;


  public tipoFecha(){
    evaluaciones = new ArrayList();
  }

  public boolean addEva(tipoEvaluacion eval){
    if(evaluaciones.contains(eval.getUnidad())) return false;
    
    evaluaciones.add(eval);
    return true;
  }

  //public eliminarEva(String nombre)
}