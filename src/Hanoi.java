import java.util.*;
/**
* Simulador del juego de las torres de Hanoi. El algoritmo se ha implementado mediante
la tecnica Divide y Venceras.
* @author Joaquin Sanchiz Navarro
*/
public class Hanoi {
  /**
  * Metodo principal de la clase que simula el juego.
  * @param n Tamaño del actual problema.
  * @param X Primera pila.
  * @param Y Segunda pila.
  * @param Z Tercera pila.
  * @param visualFlag Flag para el modo visual.
  * @return Contenido de la pila resultado.
  */
  private int movimientos;
  public final int getMovimientos(){
    return movimientos;
  }
  public Hanoi(){
    this.movimientos = 0;
  }
  public Pila playHanoi (int n, Pila X, Pila Y, Pila Z, Boolean visualFlag){
    if(visualFlag) System.out.println("N = " + n);
    if(visualFlag) System.out.println(X);
    if(visualFlag) System.out.println(Y);
    if(visualFlag) System.out.println(Z);
    if(visualFlag) System.out.println("-----------------");
    if(n == 1){
      this.move(X, Z, visualFlag);
    }
    else{
      this.playHanoi(n-1, X, Z, Y, visualFlag);
      if(visualFlag) System.out.println("N = " + n);
      this.move(X, Z, visualFlag);
      this.playHanoi(n-1, Y, X, Z, visualFlag);
    }
    return Z;
  }
  /**
  * Mueve el ultimo elemento de la Pila X a la Pila Y
  * @param X Pila que sacará el elemento.
  * @param Y Pila que insertara el elemento.
  * @param visualFlag Flag para el modo visual.
  */
  public void move (Pila X, Pila Y, Boolean visualFlag){
    movimientos++;
    if(visualFlag) System.out.println("Movimiento numero: " + movimientos);
    if(visualFlag) System.out.println("Moving " + X.getName() + " element to " + Y.getName());
    if(visualFlag) System.out.println(X);
    if(visualFlag) System.out.println(Y);
    Y.push(X.pop());
    if(visualFlag) System.out.println("Moved");
    if(visualFlag) System.out.println(X);
    if(visualFlag) System.out.println(Y);
    if(visualFlag) System.out.println("-----------------");
  }
  public static void main(String[] args) {
    Hanoi hanoi = new Hanoi();
    Pila A = new Pila("A");
    Pila B = new Pila("B");
    Pila C = new Pila("C");
    int n = Integer.parseInt(args[0]);
    Boolean visualFlag = false;
    if(Integer.parseInt(args[1]) == 1){
      visualFlag = true;
    }

    for (int i = n; i >= 1; i--) {
      A.push(i);
    }
    long time_start, time_end;
    time_start = System.currentTimeMillis();
    System.out.println("Final: " + hanoi.playHanoi(n, A, B, C, visualFlag));
    time_end = System.currentTimeMillis();
    System.out.println("Tiempo de ejecucion: "+ ( time_end - time_start ) +" milisegundos.");
    System.out.println("Numero total de movimientos: " + hanoi.getMovimientos() + " movimientos.");
  }
}
