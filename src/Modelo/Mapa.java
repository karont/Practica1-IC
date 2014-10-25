package Modelo;
/**Clase que tendra el mapa y sus metodos**/
/* 0 indica vacio*/
/* 1 indica obstaculo*/
/* 2 indica salida*/
/* 3 indica meta*/

public class Mapa {
	private int [][] matriz;
	
	public Mapa(int m, int n) {
		matriz = new int [m][n];
	}
	
	/**
	 *  Inicializa los obstaculos
	 * @param m
	 * @param n
	 */
	public void setObstaculo(Nodo nodo){
		matriz[nodo.x][nodo.y] = 1;
	}
	

	/**
	 * Inicializa la salida
	 * @param m
	 * @param n
	 */
	public void setSalida(Nodo nodo){
		matriz[nodo.x][nodo.y] = 2;
	}
	/**
	 * Inicializa la meta
	 * @param m
	 * @param n
	 */
	public void setMeta(Nodo nodo){
		matriz[nodo.x][nodo.y] = 3;
	}
	
	public int getCasilla(Nodo nodo){
		return matriz[nodo.x][nodo.y];
	}
}
