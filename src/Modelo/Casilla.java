
package Modelo;

public class Casilla {
 public Nodo nodo;
 public Nodo padre;
 public Double g;
 public Double h;
 public Double f;
 public boolean abierto;
 
 public Casilla(Nodo n, boolean abierto){
	 this.nodo = n;
	 this.padre = null;
	 this.g = (double) 0;
	 this.h = (double) 0;
	 this.f = (double) 0;
	 this.abierto = abierto;
 }
 
 public Casilla(int x,int y, boolean abierto){
	 this.nodo = new Nodo(x,y);
	 this.padre = null;
	 this.g = (double) 0;
	 this.h = (double) 0;
	 this.f = (double) 0;
	 this.abierto = abierto;
 }
}
