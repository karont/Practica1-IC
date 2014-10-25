package Modelo;
/**Clase que tendra el mapa y sus metodos**/
/* 0 indica vacio*/
/* 1 indica obstaculo*/
/* 2 indica salida*/
/* 3 indica meta*/

public class Mapa {
	private Casilla [][] matriz;
	
	public Mapa(int m, int n) {
		matriz = new Casilla [m][n];
		
		for(int i=0; i<m;i++){
			for(int j=0; j<n;j++){
				matriz[i][j] = new Casilla(new Nodo(i,j),true);
			}
		}
	}
	
	/**
	 *  Inicializa los obstaculos
	 * @param m
	 * @param n
	 */
	public void setObstaculo(Nodo nodo){
		matriz[nodo.x][nodo.y] = new Casilla(nodo,false);
	}
	

	/**
	 * Inicializa la salida
	 * @param m
	 * @param n
	 *//*
	public void setSalida(Nodo nodo){
		matriz[nodo.x][nodo.y] = 2;
	}*/
	/**
	 * Inicializa la meta
	 * @param m
	 * @param n
	 *//*
	public void setMeta(Nodo nodo){
		matriz[nodo.x][nodo.y] = 3;
	}
	*/
	public Casilla getCasilla(Nodo nodo){
		return matriz[nodo.x][nodo.y];
	}
}
