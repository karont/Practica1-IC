
package Modelo;

public class Casilla {
 public Nodo nodo;
 public Nodo padre;
 public double g;
 public double h;
 public double f;
 
 public Casilla(Nodo n){
	 this.nodo = n;
 }
}
