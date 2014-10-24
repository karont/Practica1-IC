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
	public void setobstaculo(int m, int n){
		matriz[m][n] = 1;
	}
	

	/**
	 * Inicializa la salida
	 * @param m
	 * @param n
	 */
	public void setsalida(int m, int n){
		matriz[m][n] = 2;
	}
	/**
	 * Inicializa la meta
	 * @param m
	 * @param n
	 */
	public void setmeta(int m, int n){
		matriz[m][n] = 3;
	}
}
