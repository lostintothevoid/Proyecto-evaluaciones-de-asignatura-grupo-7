import java.util.*;
import java.io.*;

public class SinEvaluacionesException extends Exception{
  public SinEvaluacionesException(){
    super("No hay ninguna evaluación en el sistema");
  }
  
}