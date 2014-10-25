package Modelo;
/**Clase que tendra el mapa y sus metodos**/
/* 0 indica vacio*/
/* 1 indica obstaculo*/
/* 2 indica salida*/
/* 3 indica meta*/

public class Mapa {
	private Casilla [][] matriz;
	private int m;
	private int n;
	
	public Mapa(int m, int n) {
		matriz = new Casilla [m][n];
		this.m = m;
		this.n = n;
		
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
		matriz[nodo.y][nodo.x].abierto = false;
	}
	
	public void removeObstaculo(Nodo nodo){
		matriz[nodo.y][nodo.x].abierto = true;
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
		return matriz[nodo.y][nodo.x];
	}

	public Casilla[][] getMatriz() {
		return matriz;
	}
	/***********************************/
	public Casilla derecha(Casilla c){
		if (!(c.nodo.x+1 >= n))
			return matriz[c.nodo.y][c.nodo.x+1];
		else
			return null;
	}
	
	public Casilla izquierda(Casilla c){
		if (!(c.nodo.x-1 < 0))
			return matriz[c.nodo.y][c.nodo.x-1];
		else
			return null;
	}
	
	public Casilla arriba(Casilla c){
		if (!(c.nodo.y-1 < 0))
			return matriz[c.nodo.y-1][c.nodo.x];
		else
			return null;
	}
	
	public Casilla abajo(Casilla c){
		if (!(c.nodo.y+1 >= m))
			return matriz[c.nodo.y+1][c.nodo.x];
		else
			return null;
	}
	
	public Casilla arribaDerecha(Casilla c){
		if (!(c.nodo.y-1 < 0 || c.nodo.x+1 >= n))
			return matriz[c.nodo.y-1][c.nodo.x+1];
		else
			return null;
	}
	public Casilla arribaIzquierda(Casilla c){
		if (!(c.nodo.y-1 < 0 || c.nodo.x-1 < 0))
			return matriz[c.nodo.y-1][c.nodo.x-1];
		else
			return null;
	}
	public Casilla abajoDerecha(Casilla c){
		if (!(c.nodo.y+1 >= m  || c.nodo.x+1 >= n))
			return matriz[c.nodo.y+1][c.nodo.x+1];
		else
			return null;
	}
	public Casilla abajoIzquierda(Casilla c){
		if (!(c.nodo.y+1 >= m || c.nodo.x-1 < 0))
			return matriz[c.nodo.y+1][c.nodo.x-1];
		else
			return null;
	}
/***************************************/
	public void setMatriz(Casilla[][] matriz) {
		this.matriz = matriz;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	
	
}
