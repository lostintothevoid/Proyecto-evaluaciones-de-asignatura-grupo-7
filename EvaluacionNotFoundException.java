import java.util.*;
import java.io.*;

public class EvaluacionNotFoundException extends Exception{
  /**Constructor de la excepción
   */
  public EvaluacionNotFoundException(){
    super("La evaluacion no está registrada");
  }
}