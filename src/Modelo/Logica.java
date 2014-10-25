package Modelo;

import java.util.ArrayList;

public class Logica {
	
	private ArrayList <Casilla> abiertos;
	private ArrayList<Casilla> cerrados;
	private Casilla meta;
	public Logica(){
		
	}
	
	public void algoritmo(){
		Casilla seleccionada = null;
		
		while(!abiertos.isEmpty()){
			
			for (Casilla actual : abiertos) {
				if(seleccionada.f > actual.f){
					seleccionada = actual;
				}
			}
			
			cerrarcasilla(seleccionada);
			
		}
		
	}
	
	public void cerrarcasilla(Casilla c){
		abiertos.remove(c);
		cerrados.add(c);
	}
	
	public void expandir(Casilla c){
		
	}
	
}
