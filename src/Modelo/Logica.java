
package Modelo;

import java.util.ArrayList;

public class Logica {
	
	private ArrayList <Casilla> abiertos;
	//private ArrayList<Casilla> cerrados;
	private Mapa mapa;
	private Casilla meta;
	private Casilla salida;
	
	public Logica(Mapa mapa, Nodo m, Nodo s){
		//this.cerrados = cerrados;
		this.mapa = mapa;
		this.meta = mapa.getCasilla(m);
		this.salida = mapa.getCasilla(s);
	}
	
	public void algoritmo(){
		
		iniciar();
		Casilla actual = null;
		
		while(!abiertos.isEmpty()){
			
			actual = buscarFMenor();
			
		}
	}
	
	
	public void iniciar(){
		
		salida.h = distancia(salida, meta);
		
		abiertos.add(salida);
	}
	
	public double distancia(Casilla a, Casilla b){
		
		return Math.sqrt((Math.pow((a.nodo.x - b.nodo.x),2) + Math.pow((a.nodo.y - b.nodo.y),2)));
		
	}
	
	public void expandir(Casilla a){
		
	}
	
	public Casilla buscarFMenor(){
		
		Casilla seleccionada = new Casilla(null,true);
		
		for (Casilla actual : abiertos) {
			if(seleccionada.f > actual.f)
				seleccionada = actual;
		}
		return seleccionada;
		
	}
}

