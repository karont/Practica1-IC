
package Modelo;

public class Casilla {
 public Nodo nodo;
 public Nodo padre;
 public double g;
 public double h;
 public double f;
 public boolean abierto;
 
 public Casilla(Nodo n, boolean abierto){
	 this.nodo = n;
	 this.padre = null;
	 this.g = 0;
	 this.h = 0;
	 this.f = 0;
	 this.abierto = abierto;
 }
}
