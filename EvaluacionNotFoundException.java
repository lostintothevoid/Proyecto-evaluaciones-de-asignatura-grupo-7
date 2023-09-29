import java.util.*;
import java.io.*;

public class EvaluacionNotFoundException extends Exception{
  public EvaluacionNotFoundException(){
    super("La evaluacion no está registrada");
  }
  
}