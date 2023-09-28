import java.util.*;
import java.io.*;

public class AbrirArchivoException extends Exception{
  public AbrirArchivoException(){
    super("El archiov no pudo ser abierto");
  }
}