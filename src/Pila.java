import java.util.*;
/**
* Clase Pila con herencia en Stack<Integer>.
Se le ha añadido un atributo nombre para llevar
a cabo un seguimiento de cada pila en Hanoi.
* @author Joaquin Sanchiz Navarro
*/
public class Pila extends Stack<Integer>{
  /**
  * Nombre de la pila para el seguimiento.
  */
  private String name_;

  /**
  * Constructor de la Pila a partir de un parametro nombre.
  * @param name Nombre identificador de la pila.
  */
  public Pila (String name){
    super();
    this.name_ = name;
  }
  /**
  * Imprime el nombre de la pila seguido de su contenido.
  * @return Nombre de la pila y contenido (P.ej: A = [3, 2, 1])
  */
  public String toString(){
    String pila = super.toString();
    String pilaToString = "";
    pilaToString = pilaToString + this.name_ + " = " + pila;
    return pilaToString;
  }
  public final String getName(){
    return name_;
  }
}
