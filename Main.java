import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
  public static void main(String[] args) throws IOException,AbrirArchivoException{
    Colegio colegio = new Colegio();
    Menu mainmenu = new Menu(colegio);
    mainmenu.importar();
    //colegio.datosIniciales();
    new AbrirArchivoException();
    mainmenu.opciones();
    mainmenu.exportar();
  }
}
