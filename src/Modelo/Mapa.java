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
	private Casilla meta;
	private Casilla salida;
	
	public Mapa(int m, int n) {
		matriz = new Casilla [m][n];
		this.m = m;
		this.n = n;
		
		for(int i=0; i<m;i++){
			for(int j=0; j<n;j++){
				matriz[i][j] = new Casilla(new Nodo(i,j));
			}
		}
	}
	
	/**
	 *  Inicializa los obstaculos
	 * @param m
	 * @param n
	 */
	public void setObstaculo(Nodo nodo){
		matriz[nodo.x][nodo.y].abierto = false;
	}
	public void setObstaculo(int x, int y){
		matriz[x][y].abierto = false;
	}
	
	public void removeObstaculo(Nodo nodo){
		matriz[nodo.x][nodo.y].abierto = true;
	}
	public void removeObstaculo(int x, int y){
		matriz[x][y].abierto = true;
	}
	
/********************/
	public void setPenalizacion(Nodo nodo){
		matriz[nodo.x][nodo.y].f=(double) 0.5;
		matriz[nodo.x][nodo.y].penalizacion = true;
	}
	public void setPenalizacion(int x, int y){
		matriz[x][y].f= (double)0.5;
		matriz[x][y].penalizacion = true;
	}
	
	public void removePenalizacion(Nodo nodo){
		matriz[nodo.x][nodo.y].f=(double) 0;
		matriz[nodo.x][nodo.y].penalizacion = false;
	}
	public void removePenalizacion(int x, int y){
		matriz[x][y].f=(double)0;
		matriz[x][y].penalizacion = false;
	}
	/**
	 * Inicializa la salida
	 * @param m
	 * @param n
	 */
	public void setSalida(Nodo nodo){
		salida = new Casilla(nodo);
	}
	public void setSalida(int x, int y){
		salida = new Casilla(new Nodo(x,y));
	}
	/**
	 * Inicializa la meta
	 * @param m
	 * @param n
	 */
	public void setMeta(Nodo nodo){
		meta = new Casilla(nodo);
	}
	public void setMeta(int x, int y){
		meta = new Casilla(new Nodo(x,y));
	}
	public Casilla getMeta(){
		return meta;
	}
	
	public Casilla getCasilla(Nodo nodo){
		return matriz[nodo.x][nodo.y];
	}

	public Casilla[][] getMatriz() {
		return matriz;
	}
	public Casilla getSalida(){
		return salida;
	}
	/***********************************/
	public Casilla abajo(Casilla c){
		if (!(c.nodo.y+1 >= n))
			return matriz[c.nodo.x][c.nodo.y+1];
		else
			return null;
	}
	
	public Casilla arriba(Casilla c){
		if (!(c.nodo.y-1 < 0))
			return matriz[c.nodo.x][c.nodo.y-1];
		else
			return null;
	}
	
	public Casilla izquierda(Casilla c){
		if (!(c.nodo.x-1 < 0))
			return matriz[c.nodo.x-1][c.nodo.y];
		else
			return null;
	}
	
	public Casilla derecha(Casilla c){
		if (!(c.nodo.x+1 >= m))
			return matriz[c.nodo.x+1][c.nodo.y];
		else
			return null;
	}
	
	public Casilla abajoIzquierda(Casilla c){
		if (!(c.nodo.x-1 < 0 || c.nodo.y+1 >= n))
			return matriz[c.nodo.x-1][c.nodo.y+1];
		else
			return null;
	}
	public Casilla arribaIzquierda(Casilla c){
		if (!(c.nodo.x-1 < 0 || c.nodo.y-1 < 0))
			return matriz[c.nodo.x-1][c.nodo.y-1];
		else
			return null;
	}
	public Casilla abajoDerecha(Casilla c){
		if (!(c.nodo.x+1 >= m  || c.nodo.y+1 >= n))
			return matriz[c.nodo.x+1][c.nodo.y+1];
		else
			return null;
	}
	public Casilla arribaDerecha(Casilla c){
		if (!(c.nodo.x+1 >= m || c.nodo.y-1 < 0))
			return matriz[c.nodo.x+1][c.nodo.y-1];
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
