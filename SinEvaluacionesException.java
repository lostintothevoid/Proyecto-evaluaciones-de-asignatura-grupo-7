import java.util.*;
import java.io.*;

public class SinEvaluacionesException extends Exception{
  /**Constructor de la excepción
   */
  public SinEvaluacionesException(){
    super("No hay ninguna evaluación en el sistema");
  }
  
}