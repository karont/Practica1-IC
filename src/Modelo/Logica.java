
package Modelo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
//import java.util.Queue;
//import java.util.Stack;

public class Logica {
	
	private ArrayList <Casilla> abiertos;
	//private ArrayList<Casilla> cerrados;
	private Mapa mapa;
	private Casilla meta;
	private Casilla salida;
	
	public Logica(Mapa mapa){
		//this.cerrados = cerrados;
		this.mapa = mapa;
		this.meta = mapa.getMeta();
		this.salida = mapa.getSalida();
	}
//	public Logica(Mapa mapa, int sx, int sy, int mx, int my){
//		//this.cerrados = cerrados;
//		this.mapa = mapa;
//		this.meta = mapa.getCasilla(new Nodo(mx,my));
//		this.salida = mapa.getCasilla(new Nodo(sx,sy));
//	}
	public Deque<Casilla> algoritmo(){
		
		iniciar();
		
		Casilla actual = null;
		boolean finalizado = false;
		Deque<Casilla> resultado = null;
		
		while(!abiertos.isEmpty() && finalizado == false){
			
			actual = buscarFMenor();
			
			//System.out.println("x = "+actual.nodo.x + ",y = "+actual.nodo.y);
			expandir(actual);
			if(actual.nodo.x == meta.nodo.x && actual.nodo.y == meta.nodo.y){
				finalizado = true;
			}
		}
		
		if(finalizado == true){
			resultado = recuperarSolucion(actual);
		}
		
		return resultado;
	}
	
	
	private void iniciar(){
		abiertos = new ArrayList<Casilla>();
		salida.h = distancia(salida, meta);	
		abiertos.add(salida);
	}
	
	private Double distancia(Casilla a, Casilla b){
		
		return Math.sqrt((Math.pow((a.nodo.x - b.nodo.x),2) + Math.pow((a.nodo.y - b.nodo.y),2)));
		
	}
	
	private void expandir(Casilla a){
		
		heuristica(mapa.arriba(a),a);
		heuristica(mapa.abajo(a),a);
		heuristica(mapa.derecha(a),a);
		heuristica(mapa.izquierda(a),a);
		heuristica(mapa.arribaDerecha(a),a);
		heuristica(mapa.arribaIzquierda(a),a);
		heuristica(mapa.abajoDerecha(a),a);
		heuristica(mapa.abajoIzquierda(a),a);
		
	}
	
	private void heuristica(Casilla c, Casilla p){
		
		if(c!=null && c.abierto == true){
			if(!abiertos.contains(c)){
				c.padre = p.nodo;
				c.g = p.g + distancia(c,p);
				c.h = distancia(c,meta);
				c.f = c.g + c.h + c.f;
				abiertos.add(c);
			}
			else{
				double g = p.g + distancia(c,p);
				double h = distancia(c,meta);
				double f  = g + h + c.f;
				
				if(f < c.f){
					c.padre = p.nodo;
					c.g = g;
					c.h = h;
					c.f = f;
				}
			}
		}
	}
	private Casilla buscarFMenor(){
		
		Casilla seleccionada = new Casilla(null);
		seleccionada.f = Double.MAX_VALUE;
		for (Casilla actual : abiertos) {
			if(actual.nodo.x == meta.nodo.x && actual.nodo.y == meta.nodo.y){
				actual.abierto = false;
				abiertos.remove(actual);
				return actual;
			}
				
			else if(seleccionada.f > actual.f)
				seleccionada = actual;
			
		}
		abiertos.remove(seleccionada);
		seleccionada.abierto = false;
		return seleccionada;
		
	}
	
	private Deque<Casilla> recuperarSolucion(Casilla a) {
		Deque<Casilla> solucion = new ArrayDeque<Casilla>();
		a = mapa.getCasilla(a.padre);
		while((a.nodo.x != salida.nodo.x) || (a.nodo.y != salida.nodo.y)){
			solucion.add(a);
			a = mapa.getCasilla(a.padre);
		}
	
		return solucion;
	}
}

